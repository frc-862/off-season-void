package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {

    private TalonFX left1;
    private TalonFX left2;
    private TalonFX left3;

    private TalonFX right1;
    private TalonFX right2;
    private TalonFX right3;

    /** Creates a new Drivetrain Subsystem. */
    public Drivetrain() {
        left1 = new TalonFX(DrivetrainConstants.LEFT_ONE_CAN);
        left2 = new TalonFX(DrivetrainConstants.LEFT_TWO_CAN);
        left3 = new TalonFX(DrivetrainConstants.LEFT_THREE_CAN);

        right1 = new TalonFX(DrivetrainConstants.RIGHT_ONE_CAN);
        right2 = new TalonFX(DrivetrainConstants.RIGHT_TWO_CAN);
        right3 = new TalonFX(DrivetrainConstants.RIGHT_THREE_CAN);

        right1.setInverted(true);
        right2.setInverted(true);
        right3.setInverted(true);
    }

    /** Sets power to the left side of the drivetrain */
    public void setLeftPower(double power){
        left1.set(power);
        left2.set(power);
        left3.set(power);
    }

    /** Sets power to the right side of the drivetrain */
    public void setRightPower(double power){
        right1.set(power);
        right2.set(power);
        right3.set(power);
    }

    /** Stops the drivetrain on both sides */
    public void stop(){
        setLeftPower(0);
        setRightPower(0);
    }

    @Override
    public void periodic() {}
}
