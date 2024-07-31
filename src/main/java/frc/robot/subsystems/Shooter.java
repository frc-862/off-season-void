package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {

    // TODO: create a TalonFX variable named "shooterMotor"

    private TalonFX shooterMotor;
    /*
     * REMEMBER: use the "private" keywords
     * (you don't want this "shooterMotor" variable to be used outside the subsystem)
     * (you don't want this "shooterMotor" variable to be changed)
     */

    
    /** Creates a new Shooter Subsystem. */
    public Shooter() {
        shooterMotor = new TalonFX(ShooterConstants.SHOOTER_MOTOR_CAN);
        // TODO: set a TalonFX object to the newly created shooter motor while using the CAN ID from "ShooterConstants"
        // REMEMBER: use "new" when creating an object from a class
    }

    // TODO: create the method "setPower" with the double type "power" as a parameter
    public void setPower(power){
        shooterMotor.set(power);
    }
    /*
     * REMEMBER: you want to use the "public" keyword
     * (you want to use the method outside of the class)
     */

    // TODO: create the method "stop" which calls the "setPower" method with the "power" parameter set to zero
    public void stop(){
        shooterMotor.setPower(0);
    }
    /*
     * REMEMBER: you want to use the "public" keyword
     * (you want to use the method outside of the class)
     */

    @Override
    public void periodic() {}
}
