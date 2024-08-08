package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CollectorConstants;

public class Collector extends SubsystemBase {

    private TalonFX collectorMotor;

    /** Creates a new Collector Subsystem. */
    public Collector() {
        collectorMotor = new TalonFX(CollectorConstants.COLLECTOR_MOTOR_CAN);
    }

    @Override
    public void periodic() {}

    /** Sets power to the collector motor 
     * @param power Percentage of power given to the motor
     */
    public void setPower(double power){
        if(Math.abs(power) >= 0 && Math.abs(power) <= 0.1){
            power = 0;
        }

        collectorMotor.set(power);
    }

    /** Stops the collector motor */
    public void stop(){
        setPower(0);
    }
}
