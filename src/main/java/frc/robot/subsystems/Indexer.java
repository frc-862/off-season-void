package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {

    private final VictorSPX indexerMotor;

    /** Creates a new Indexer Subsystem. */
    public Indexer() {
        indexerMotor = new VictorSPX(16);
    }

    /** Sets power to the indexer motor */
    public void setPower(double power) {
        indexerMotor.set(VictorSPXControlMode.PercentOutput, power);
    }

    /** Stops the indexer motor */
    public void stop() {
        setPower(0);
    }

    @Override
    public void periodic() {}
}
