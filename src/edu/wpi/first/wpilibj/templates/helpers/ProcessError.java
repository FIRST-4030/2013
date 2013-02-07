package edu.wpi.first.wpilibj.templates.helpers;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Dabo Ross <Dabo.Ross at daboross.net>
 */
public class ProcessError {

    private String errorString;
    private String creator;
    private boolean isError;

    /**
     * This creates a new Error that is NOT an error.
     *
     * @param o The object creating this error. Always use this or null.
     */
    public ProcessError(Object o) {
        if (o != null) {
            creator = o.getClass().getName();
        }
        isError = false;
        errorString = "No Error";
    }

    /**
     * This creates a new Error that is an error with the given message
     *
     * @param error The Error.
     * @param o The object creating this error. Always use this.
     */
    public ProcessError(Object o, String error) {
        if (o == null || error == null) {
            throw new NullPointerException();
        }
        creator = o.getClass().getName();
        isError = true;
        errorString = error;

    }

    /**
     * @return Whether or not this error holder has an error.
     */
    public boolean isError() {
        return isError;
    }

    /**
     * @return Get the message held by this error. Will return "No Error" if no
     * error.
     */
    public String getMessage() {
        if (!isError) {
            return "No Error";
        }

        return errorString;
    }

    /**
     * @return The object that this originated in, its NAME.
     */
    public String getCreator() {

        return creator == null ? "Unknown" : creator;
    }

    /**
     * This method broadcasts this error to the System.err stream.
     */
    public void broadcast() {
        String message = "Error Broadcast: Origin: " + getCreator() + " Error: " + errorString;
        System.err.println(message);
    }

    /**
     * This method puts this error's message and creator to the SmartDashboard
     * under the name specified.
     *
     * @param key The key to put the message under.
     * @param putOwner Whether or not to include the creator's name in this
     * message.
     */
    public void putToSmartDashboard(String key, boolean putOwner) {
        if (key == null) {
            throw new NullPointerException();
        }
        String message = (putOwner && creator != null ? "ErrCreator: " + creator + " " : "") + "ErrMessage: " + errorString;
        SmartDashboard.putString(key, message);
    }
}
