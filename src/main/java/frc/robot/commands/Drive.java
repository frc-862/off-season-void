package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class Drive extends Command {

    private final Drivetrain drivetrain;
    private DoubleSupplier leftPower;
    private DoubleSupplier rightPower;

    /** Creates a new Drive. */
    public Drive(Drivetrain drivetrain, DoubleSupplier leftPower, DoubleSupplier rightPower) {
        this.drivetrain = new Drivetrain();

        this.leftPower = leftPower;
        this.rightPower = rightPower;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        drivetrain.setLeftPower(leftPower.getAsDouble());
        drivetrain.setRightPower(rightPower.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
