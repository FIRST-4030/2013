package edu.wpi.first.wpilibj.templates.helpers;

/**
 *
 * @author daboross
 */
public class DistanceReport {

    private double distance;
    private ProcessedTarget target;
    private int numberOfTargets;

    public DistanceReport(double distance, int numberOfTargets, ProcessedTarget target) {
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
