package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TurretConstants;
import frc.thunder.shuffleboard.LightningShuffleboard;

public class Turret extends SubsystemBase {

    private final TalonSRX turretMotor;

    private double targetAngle = 0d;
    // boolean value to disable the turret
    private boolean disableTurret = false;
    // boolean value to manually override normal turret operations
    private boolean manualOverride = false;

    private PIDController turretPIDFast = new PIDController(TurretConstants.TURRET_kP_FAST, TurretConstants.TURRET_kI_FAST, TurretConstants.TURRET_kD_FAST);
    private PIDController turretPIDSlow = new PIDController(TurretConstants.TURRET_kP_SLOW, TurretConstants.TURRET_kI_SLOW, TurretConstants.TURRET_kD_SLOW);

    /** Creates a new Turret Subsystem. */
    public Turret() {
        turretMotor = new TalonSRX(TurretConstants.TURRET_MOTOR_CAN);
        turretMotor.setNeutralMode(NeutralMode.Brake);
        turretMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);  

        LightningShuffleboard.setDoubleSupplier("Turret", "Current Angle", () -> getCurrentAngle().getDegrees());
        LightningShuffleboard.setDoubleSupplier("Turret", "Target Angle", () -> getTargetAngle());
        LightningShuffleboard.setBoolSupplier("Turret", "Hit Left Limit Switch", () -> getLeftLimitSwitch());
        LightningShuffleboard.setBoolSupplier("Turret", "Hit Right Limit Switch", () -> getRightLimitSwitch());

        // resets the target angle and encoder position
        targetAngle = 0;
        resetEncoder();
    }

    @Override
    public void periodic() {
        // if the turret is not disabled and not manually overridden, set the motor power to the PID output
        if(!disableTurret && !manualOverride){
            var power = getMotorOutput(getTargetAngle());
            turretMotor.set(TalonSRXControlMode.PercentOutput, MathUtil.clamp(power, -TurretConstants.TURRET_MAX_MOTOR_OUTPUT, TurretConstants.TURRET_MAX_MOTOR_OUTPUT));
        // if the turret is disabled, stop the motor
        } else if(disableTurret){
            turretMotor.set(TalonSRXControlMode.PercentOutput, 0);
        }
    }

    /** @return The current angle of the turret by converting the sensor position into readable units. */
    public Rotation2d getCurrentAngle(){
        return Rotation2d.fromDegrees(getEncoderRotation() / TurretConstants.TURRET_TURN_GEAR_RATIO * 360);
    }

    /** @return The raw sensor position of the turret motor. */
    public double getEncoderRotation(){
        return turretMotor.getSelectedSensorPosition() / 4096;
    }

    /** @return The boolean value from the left limit switch (1 means closed and 0 means open). */
    public boolean getLeftLimitSwitch(){
        return turretMotor.isFwdLimitSwitchClosed() == 1;
    }

    /** @return The boolean value from the right limit switch (1 means closed and 0 means open). */
    public boolean getRightLimitSwitch(){
        return turretMotor.isRevLimitSwitchClosed() == 1;
    }

    /** @return The target angle of the turret. */
    public double getTargetAngle(){
        return targetAngle;
    }

    public double getMotorOutput(double targetAngle){
        // power to be set to the turret motor
        double motorOutput;

        // decides which PID controller to use based on the distance from the target angle
        if(Math.abs(targetAngle - getCurrentAngle().getDegrees()) <= TurretConstants.TURRET_SLOW_PID_THRESHOLD){
            motorOutput = turretPIDSlow.calculate(getCurrentAngle().getDegrees(), targetAngle);
        } else {
            motorOutput = turretPIDFast.calculate(getCurrentAngle().getDegrees(), targetAngle);
        }

        // checks if the motor output is above the minimum power threshold
        if(Math.abs(motorOutput) > (TurretConstants.TURRET_kP_SLOW) && Math.abs(motorOutput) < TurretConstants.MIN_TURRET_POWER){
            motorOutput = Math.signum(motorOutput) * TurretConstants.MIN_TURRET_POWER;
        }

        return motorOutput;
    }

    /** Resets the encoder position of the turret. */
    public void resetEncoder(){
        turretMotor.setSelectedSensorPosition(0);
    }

    /** Sets the target angle of the turret. 
     * @param targetAngle The target angle to set the turret to.
     */
    public void setTargetAngle(double targetAngle){
        // stops any manual overrides
        manualOverride = false;

        // keeps the sign of the target angle consistent during calculations
        double signOfTarget = Math.signum(targetAngle);

        // calculates the target angle
        targetAngle = signOfTarget * (((Math.abs(targetAngle) + 180) % 360) - 180);

        // makes sure the target angle is within the turret's constraints
        this.targetAngle = MathUtil.clamp(targetAngle, TurretConstants.MIN_TURRET_ANGLE, TurretConstants.MAX_TURRET_ANGLE);
    }

    /** Enables/Disables the Turret. 
     * @param disableTurret The boolean value to disable or enable the turret.
     */
    public void setDisableTurret(boolean disableTurret){
        this.disableTurret = disableTurret;
    }
    
    /** Manually sets power to the turret motor 
     * @param power Percentage of power given to the motor
     */
    public void setPower(double power){
        manualOverride = true;
        turretMotor.set(TalonSRXControlMode.PercentOutput, power);
    }

    /** Manually stops the turret motor */
    public void stop(){
        manualOverride = true;
        turretMotor.set(TalonSRXControlMode.PercentOutput, 0);
    }
}
