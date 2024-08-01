package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {

    private TalonFX shooterMotor;

    
    /** Creates a new Shooter Subsystem. */
    public Shooter() {
        shooterMotor = new TalonFX(ShooterConstants.SHOOTER_MOTOR_CAN);
    }

    public void setPower(double power) {
        shooterMotor.set(power);
    }

    public void stop() {
        setPower(0);
    }

    @Override
    public void periodic() {}
}
