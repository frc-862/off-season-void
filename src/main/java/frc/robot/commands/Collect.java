package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Collector;

public class Collect extends Command {

    private final Collector collector;
    private DoubleSupplier Collectpower;

    /** Creates a new Collect Command. */
    public Collect(Collector collector, DoubleSupplier Collectpower) {
        this.collector = collector;

        this.Collectpower = Collectpower;

        addRequirements(collector);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        collector.setPower(Collectpower.getAsDouble());
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        collector.setPower(Collectpower.getAsDouble());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        collector.stop();
    }

    // Returns true when the command should end.
    @Override
        public boolean isFinished() {
        return false;
    }
}
