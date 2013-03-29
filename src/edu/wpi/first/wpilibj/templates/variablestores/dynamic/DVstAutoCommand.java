package edu.wpi.first.wpilibj.templates.variablestores.dynamic;

/**
 *
 * @author daboross
 */
public class DVstAutoCommand {

    private static long autoCommandWaitTime = 7000;

    public static long getAutoCommandWaitTime() {
        return autoCommandWaitTime;
    }

    public static void setAutoCommandWaitTime(final long autoCommandWaitTime) {
        DVstAutoCommand.autoCommandWaitTime = autoCommandWaitTime;
    }
}
