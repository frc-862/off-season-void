package frc.robot;

import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Drive;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Drivetrain;
import frc.robot.Constants.OperatorConstants;
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

    private static final XboxController driver = new XboxController(OperatorConstants.DRIVER_PORT);
    private static final XboxController copilot = new XboxController(OperatorConstants.COPILOT_PORT);

    private static final Drivetrain drivetrain = new Drivetrain();
   
    @Override
    protected void initializeSubsystems() {}

    @Override
    protected void initializeNamedCommands() {}

    @Override
    protected void configureButtonBindings() {}

    @Override
    protected void configureSystemTests() {}

    @Override
    protected void configureDefaultCommands() {
        drivetrain.setDefaultCommand(new Drive(drivetrain, () -> driver.getLeftY(), () -> driver.getRightY()));
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