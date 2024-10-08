package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;

public class Index extends Command {

    private final Indexer indexer;
    private DoubleSupplier indexPower;

    /** Creates a new Index Command. */
    public Index(Indexer indexer, DoubleSupplier indexPower) {
        this.indexer = indexer;

        this.indexPower = indexPower;

        addRequirements(indexer);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        indexer.setPower(indexPower.getAsDouble());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        indexer.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
