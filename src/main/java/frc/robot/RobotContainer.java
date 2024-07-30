package frc.robot;

import frc.robot.commands.Drive;
import frc.robot.commands.Shoot;
import frc.robot.commands.Collect;
import frc.robot.commands.Index;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Indexer;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.IndexerConstants;
import frc.robot.Constants.ShooterConstants;
import frc.thunder.LightningContainer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer extends LightningContainer {

    private XboxController driver;
    private XboxController copilot;

    private Drivetrain drivetrain;
    private Shooter shooter;
    private Collector collector;
    private Indexer indexer;
   
    @Override
    protected void initializeSubsystems() {
        driver = new XboxController(OperatorConstants.DRIVER_PORT);
        copilot = new XboxController(OperatorConstants.COPILOT_PORT);

        drivetrain = new Drivetrain();
        shooter = new Shooter();
        collector = new Collector();
        indexer = new Indexer();
    }

    @Override
    protected void initializeNamedCommands() {}

    @Override
    protected void configureButtonBindings() {
        // Indexer
        new Trigger(copilot::getRightBumper).whileTrue(new Index(indexer, () -> IndexerConstants.INDEXER_POWER));
        new Trigger(copilot::getLeftBumper).whileTrue(new Index(indexer, () -> -IndexerConstants.INDEXER_POWER));

        // TODO: create a new Trigger that calls a new "Shoot" command when the "A" button is pressed
        // TODO: using a Lambda expression, set the DoubleSupplier needed to the "SHOOTER_POWER" constant from "ShooterConstants"
    }

    @Override
    protected void configureSystemTests() {}

    @Override
    protected void configureDefaultCommands() {
        // drivetrain
        drivetrain.setDefaultCommand(new Drive(drivetrain, () -> driver.getLeftY(), () -> driver.getRightY()));

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