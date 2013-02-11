package edu.wpi.first.wpilibj.templates.helpers;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ProcessError {

    private String errorString;
    private String creator;
    private boolean isError;

    /**
     * This creates a new Error that is NOT an error.
     *
     * @param owner The object creating this error.
     */
    public ProcessError(String owner) {
        if (owner != null) {
            creator = owner;
        }
        isError = false;
        errorString = "No Error";
    }

    /**
     * This creates a new Error that is an error with the given message
     *
     * @param error The Error.
     * @param owner The object creating this error.
     */
    public ProcessError(String owner, String error) {
        if (error == null) {
            throw new NullPointerException();
        }
        if (owner != null) {
            creator = owner;
        }
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

    /**
     * Use this method to create an error on a already created ProcessError.
     * One implementation of this is creating a non-error ProcessError, then passing it as an argument to another method, and then retrieving an error from it if that method added an error.
     * @param error The Error.
     * @param owner The object creating this error.
     */
    public void setErrored(String owner, String error) {
        if (error == null) {
            throw new NullPointerException();
        }
        if (owner != null) {
            creator = creator == null ? owner : creator + "+" + owner;
        }
        isError = true;
        errorString = errorString == null ? error : errorString + "+" + error;
    }
}
