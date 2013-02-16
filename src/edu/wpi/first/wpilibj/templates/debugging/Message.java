package edu.wpi.first.wpilibj.templates.debugging;

/**
 *
 * @author daboross
 */
public class Message implements DebugInfo {

    private static int number = 0;
    private String message;
    private int numberthis;

    public Message(String message) {
        number++;
        this.message = message;
        numberthis = number;
    }

    public String key() {
        return "Message" + numberthis;
    }

    public String message() {
        return message;
    }

    public boolean isConsole() {
        return false;
    }

    public boolean isDashboard() {
        return true;
    }
}
