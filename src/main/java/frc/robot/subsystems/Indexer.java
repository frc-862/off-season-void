package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.filter.Debouncer;
import frc.robot.Constants.IndexerConstants;

public class Indexer extends SubsystemBase {

    private final VictorSPX indexerMotor;

    private final DigitalInput enterBeambreak;
    private final DigitalInput exitBeambreak;

    private final Debouncer enterDebouncer;
    private final Debouncer exitDebouncer;

    /** Creates a new Indexer Subsystem. */
    public Indexer() {
        indexerMotor = new VictorSPX(IndexerConstants.INDEXER_MOTOR_CAN);

        enterBeambreak = new DigitalInput(IndexerConstants.ENTER_BEAMBREAK);
        exitBeambreak = new DigitalInput(IndexerConstants.EXIT_BEAMBREAK);

        enterDebouncer = new Debouncer(IndexerConstants.DEBOUNCER_TIME);
        exitDebouncer = new Debouncer(IndexerConstants.DEBOUNCER_TIME);
    }

    @Override
    public void periodic() {}

    /** Gets the input of the enter beambreak
     * @return the breambreak status (true means yes ball, false means no ball)
     */
    public boolean getEnterStatus(){
        return enterDebouncer.calculate(!enterBeambreak.get());
    }

    /** Gets the input of the exit beambreak
     * @return the breambreak status (true means yes ball, false means no ball)
     */
    public boolean getExitStatus(){
        return exitDebouncer.calculate(!exitBeambreak.get());
    }

    /** Sets power to the indexer motor 
     * @param power Percentage of power given to the motor
     */
    public void setPower(double power) {
        indexerMotor.set(VictorSPXControlMode.PercentOutput, power);
    }

    /** Stops the indexer motor */
    public void stop() {
        setPower(0);
    }
}
