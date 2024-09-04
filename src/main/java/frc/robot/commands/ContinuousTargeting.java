package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Turret;

public class ContinuousTargeting extends Command {

    private final Turret turret;
    private DoubleSupplier target;
    /** Creates a new ContinuousTargeting. */
    public ContinuousTargeting(Turret turret, DoubleSupplier target){
        this.turret = turret;
        this.target = target;

        addRequirements(turret);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        turret.setTargetAngle(turret.getTargetAngle() + target.getAsDouble());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        turret.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
