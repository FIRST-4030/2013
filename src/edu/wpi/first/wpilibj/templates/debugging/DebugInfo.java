package edu.wpi.first.wpilibj.templates.debugging;

/**
 *
 * @author daboross
 */
public interface DebugInfo {

    public String key();

    public String message();
    public boolean isConsole();
    public boolean isDashboard();
}
