package edu.wpi.first.wpilibj.templates.helpers.imageprocess;

import edu.wpi.first.wpilibj.templates.helpers.ProcessError;

/**
 * Distance Report
 */
public class LinearDistanceReport {

    private double distance;
    private ProcessedTarget target;
    private int numberOfTargets;
    private ProcessError error;

    public LinearDistanceReport(double distance, int numberOfTargets, ProcessedTarget target) {
        this.distance = distance;
        this.target = target;
        this.numberOfTargets = numberOfTargets;
        this.error = new ProcessError(null);
    }

    public LinearDistanceReport(ProcessError error) {
        distance = -1;
        target = null;
        numberOfTargets = -1;
        this.error = error;
    }

    public double getDistance() {
        return distance;
    }

    public ProcessedTarget getTarget() {
        return target;
    }

    public int getNumberOfTargets() {
        return numberOfTargets;
    }

    public ProcessError getError() {
        return error;
    }
}
