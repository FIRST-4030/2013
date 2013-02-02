package edu.wpi.first.wpilibj.templates.helpers;

/**
 *
 * @author daboross
 */
public class DistanceReport {

    private int distance;
    private ProcessedTarget target;
    private int numberOfTargets;

    public DistanceReport(int distance, int numberOfTargets, ProcessedTarget target) {
        this.distance = distance;
        this.target = target;
        this.numberOfTargets = numberOfTargets;
    }

    public int getDistance() {
        return distance;
    }

    public ProcessedTarget getTarget() {
        return target;
    }

    public int getNumberOfTargets() {
        return numberOfTargets;
    }
}
