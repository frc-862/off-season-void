package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Turret;

public class ResetTurretAngle extends Command {

    private final Turret turret;

    /** Creates a new ResetTurretAngle. */
    public ResetTurretAngle(Turret turret) {
        this.turret = turret;

        addRequirements(turret);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        turret.resetEncoder();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
