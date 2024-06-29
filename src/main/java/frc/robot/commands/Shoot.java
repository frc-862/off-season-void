package frc.robot.commands;

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

    /** Creates a new Shoot. */
    public Shoot(Shooter shooter) {

        // TODO: set a new "Shooter" object to the newly created "shooter" variable
        // REMEMBER: use "new" when creating an object from a class

        addRequirements(shooter);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // TODO: use the "setPower" method from your "shooter" object and set the power from "ShooterConstants"
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // TODO: use the "stop" method from you "shooter" object
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
