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
    public final class OperatorConstants {
        public static final int DRIVER_PORT = 0;
        public static final int COPILOT_PORT = 1;
    }
    
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

    public final class ShooterConstants {
        public static final int SHOOTER_MOTOR_CAN = 11;

        // REMEMBER: power is percentage based (1 = 100%)!
        public static final double SHOOTER_POWER = 1;
    }

    public final class PoseConstants {
        public static final Translation2d FIELD_LIMIT = null;
    }
}
