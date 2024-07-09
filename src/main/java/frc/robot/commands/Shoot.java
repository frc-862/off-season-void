package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;
import frc.robot.Constants.ShooterConstants;

public class Shoot extends Command {

    // TODO: create a "shooter" variable
    /*
     * REMEMBER: use the "private" and "final" keywords
     * (you don't want this "shooter" variable to be used outside the command)
     * (you don't want this "shooter" variable to be changed)
     */

    // TODO: create a DoubleSupplier "shootPower" variable
    /*
     * REMEMBER: use the "private" keyword
     * (you don't want this "shootPower" variable to be used outside the command)
     */

    /** Creates a new Shoot Command. */
    public Shoot(Shooter shooter, DoubleSupplier shootPower) {
        // TODO: set up the "shooter" variable for the constructor
        // REMEMBER: use the "this" keyword to refer to the current object

        // TODO: set up the "shootPower" variable for the constructor
        // REMEMBER: use the "this" keyword to refer to the current object

        // REMEMBER: the "addRequirements" method is to make sure that subsystems aren't used in other commands
        addRequirements(shooter);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // TODO: use the "setPower" method from your "shooter" variable and set the power with the "shootPower" variable
        // REMEMBER: when using a DoubleSupplier, use the "getAsDouble" method
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // TODO: use the "stop" method from your "shooter" variable
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
