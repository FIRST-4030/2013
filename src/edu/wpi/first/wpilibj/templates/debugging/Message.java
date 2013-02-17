package edu.wpi.first.wpilibj.templates.debugging;

/**
 * This is a "message" that is to be sent to the Console. It will not output
 * into SmartDashboard when given to RobotDebugger.
 *
 * @author daboross
 */
public class Message extends DebugInfo {

    private static int number = 0;
    private String message;
    private String key;

    public Message(String message) {
        number++;
        this.message = message;
        key = "Message:" + number;
    }

    public String key() {
        return key;
    }

    public String message() {
        return message;
    }

    public boolean isConsole() {
        return true;
    }

    public boolean isDashboard() {
        return false;
    }
}
