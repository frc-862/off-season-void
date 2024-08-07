package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    /** Constant values for our Operator Ports and Interface */
    public final class OperatorConstants {
        public static final int DRIVER_PORT = 0;
        public static final int COPILOT_PORT = 1;
    }
    
    /** Constant values and CAN IDs for our Drivetrain */
    public final class DrivetrainConstants {
        // left motors
        public static final int LEFT_ONE_CAN = 4;
        public static final int LEFT_TWO_CAN = 5;
        public static final int LEFT_THREE_CAN = 6;

        // right motors
        public static final int RIGHT_ONE_CAN = 1;
        public static final int RIGHT_TWO_CAN = 2;
        public static final int RIGHT_THREE_CAN = 3;
    }

    /** Constant values and CAN IDs for our Shooter */
    public final class ShooterConstants {
        public static final int SHOOTER_MOTOR_CAN = 11;

        public static final double SHOOTER_POWER = 1d;
    }

    /** Constant values and CAN IDs for our Collector */
    public final class CollectorConstants {
        public static final int COLLECTOR_MOTOR_CAN = 15;
    }

    /** Constant values and CAN IDs for our Indexer */
    public final class IndexerConstants {
        public static final int INDEXER_MOTOR_CAN = 16;

        public static final double INDEXER_POWER = 1d;
    }

    /** Constant values and CAN IDs for our Turret */
    public final class TurretConstants {
        public static final int TURRET_MOTOR_CAN = 12;

        public static final double TURRET_kP_FAST = 0.02;
        public static final double TURRET_kI_FAST = 0d;
        public static final double TURRET_kD_FAST = 0.001;

        public static final double TURRET_kP_SLOW = 0.03;
        public static final double TURRET_kI_SLOW = 0d;
        public static final double TURRET_kD_SLOW = 0.0009;

        public static final double TURRET_SLOW_PID_THRESHOLD = 10d; // degrees

        public static final double MIN_TURRET_ANGLE = -100d;
        public static final double MAX_TURRET_ANGLE = 100d;

        public static final double MIN_TURRET_POWER = 0.054;

        public static final double TURRET_MAX_MOTOR_OUTPUT =  0.6d;

        public static final double TURRET_TURN_GEAR_RATIO = 14d;

        // for testing (temporary)
        public static final double TURRET_TARGET_ANGLE = 30d;
    }

    /** Ignore This */
    public final class PoseConstants {
        public static final Translation2d FIELD_LIMIT = null;
    }
}
