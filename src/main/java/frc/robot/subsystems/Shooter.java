package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    // TODO: create the shooter motor using the motor CAN id from the ShooterConstants class
    /*
     * REMEMBER: you need the TalonFX variable type and "private" keyword 
     * (you don't want to use the motor outside of the class)
     */

    
    /** Creates a new Shooter. */
    public Shooter() {
        // TODO: set a TalonFX object to the newly created shooter motor
        // REMEMBER: use "new" when creating an object from a class
    }

    // TODO: create the method "setPower" with the double type "power" as a parameter
    /*
     * REMEMBER: you want to use the "public" keyword
     * (you want to use the method outside of the class)
     */

    // TODO: create the method "stop" which calls "setPower" with the "power" of zero
    /*
     * REMEMBER: you want to use the "public" keyword
     * (you want to use the method outside of the class)
     */

    @Override
    public void periodic() {}
}
