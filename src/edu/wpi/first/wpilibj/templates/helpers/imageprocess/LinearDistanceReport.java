package edu.wpi.first.wpilibj.templates.helpers.imageprocess;

/**
 * Distance Report
 */
public class LinearDistanceReport {

    private double distance;
    private ProcessedTarget target;
    private int numberOfTargets;

    public LinearDistanceReport(double distance, int numberOfTargets, ProcessedTarget target) {
        this.distance = distance;
        this.target = target;
        this.numberOfTargets = numberOfTargets;
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
}
