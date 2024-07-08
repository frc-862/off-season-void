package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CollectorConstants;;

public class Collector extends SubsystemBase {

    private TalonFX collectorMotor;

    /** Creates a new Collector Subsystem. */
    public Collector() {
        collectorMotor = new TalonFX(CollectorConstants.COLLECTOR_MOTOR_CAN);
    }

    /** Sets power to the collector motor */
    public void setPower(double power){
        collectorMotor.set(power);
    }

    /** Stops the collector motor */
    public void stop(){
        setPower(0);
    }

    @Override
    public void periodic() {}
}
