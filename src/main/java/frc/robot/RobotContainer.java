package frc.robot;

import frc.robot.commands.Drive;
import frc.robot.commands.Shoot;
import frc.robot.commands.Collect;
import frc.robot.commands.Index;
import frc.robot.commands.AimTurret;
import frc.robot.commands.ResetTurretAngle;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Turret;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.Constants.ShooterConstants;
import frc.robot.Constants.CollectorConstants;
import frc.robot.Constants.IndexerConstants;
import frc.robot.Constants.TurretConstants;
import frc.thunder.LightningContainer;
import frc.thunder.filter.XboxControllerFilter;
import frc.thunder.filter.XboxControllerFilter.filterMode;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer extends LightningContainer {

    private XboxControllerFilter driver;
    private XboxControllerFilter copilot;

    private Drivetrain drivetrain;
    private Shooter shooter;
    private Collector collector;
    private Indexer indexer;
    private Turret turret;
   
    @Override
    protected void initializeSubsystems() {
        driver = new XboxControllerFilter(OperatorConstants.DRIVER_PORT, 0.1, -0.9, 0.9, filterMode.SQUARED);
        copilot = new XboxControllerFilter(OperatorConstants.COPILOT_PORT, 0.05, -0.9, 0.9, filterMode.SQUARED);

        drivetrain = new Drivetrain();
        shooter = new Shooter();
        collector = new Collector();
        indexer = new Indexer();
        turret = new Turret();
    }

    @Override
    protected void initializeNamedCommands() {}

    @Override
    protected void configureButtonBindings() {
        // Indexer
        new Trigger(copilot::getRightBumper).whileTrue(new Index(indexer, () -> IndexerConstants.INDEXER_POWER));
        new Trigger(copilot::getLeftBumper).whileTrue(new Index(indexer, () -> -IndexerConstants.INDEXER_POWER));

        // Shooter
        new Trigger(copilot::getAButton).whileTrue(new Shoot(shooter, () -> ShooterConstants.SHOOTER_POWER));

        // turret
        new Trigger(copilot::getBButton).whileTrue(new AimTurret(turret, () -> TurretConstants.TURRET_TARGET_ANGLE)).whileFalse(new AimTurret(turret, () -> 0));
        new Trigger(copilot::getXButton).whileTrue(new ResetTurretAngle(turret));
    }

    @Override
    protected void configureSystemTests() {}

    @Override
    protected void configureDefaultCommands() {
        // drivetrain
        drivetrain.setDefaultCommand(new Drive(drivetrain, () -> driver.getLeftY(), () -> -driver.getRightY()));

        // collector
        collector.setDefaultCommand(new Collect(collector, () -> copilot.getRightTriggerAxis() - copilot.getLeftTriggerAxis()));
    }

    @Override
    protected void releaseDefaultCommands() {}

    @Override
    protected void initializeDashboardCommands() {}

    @Override
    protected void configureFaultCodes() {}

    @Override
    protected void configureFaultMonitors() {}

    @Override
    protected Command getAutonomousCommand() {
        return null;
    }
}