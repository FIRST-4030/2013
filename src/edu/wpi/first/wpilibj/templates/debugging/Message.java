package edu.wpi.first.wpilibj.templates.debugging;

/**
 * This is a "message" that is to be sent to the Console. It will not output
 * into SmartDashboard when given to RobotDebugger.
 *
 * @author daboross
 */
public class Message extends DebugInfo {

    private static int number = 0;
    private final String message;
    private final String key;
    private final int level;

    public Message(String message, int level) {
        if (level < DebugLevel.NEVER || level > DebugLevel.ALWAYS) {
            throw new IllegalArgumentException("To low/high of a level in Message()");
        }
        if (message == null) {
            throw new IllegalArgumentException("Null Message");
        }
        number++;
        this.message = message;
        key = "[Message]" + number;
        this.level = level;
    }

    protected String key() {
        return key;
    }

    protected String message() {
        return message;
    }

    protected boolean isConsole() {
        return true;
    }

    protected boolean isDashboard() {
        return false;
    }

    protected int debugLevel() {
        return level;
    }
}
