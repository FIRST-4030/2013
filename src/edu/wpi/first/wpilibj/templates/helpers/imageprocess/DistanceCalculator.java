package edu.wpi.first.wpilibj.templates.helpers.imageprocess;

import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.templates.variablestores.VstC;

/**
 * Robot Distance Calculator. Class full of static methods to calculate the
 * distance to a target.
 */
public class DistanceCalculator {

    public static DistanceReport calculateLinearDistance(ProcessedTarget[] pts) {
        if (pts == null) {
            System.err.println("DistanceCalculator calculate(ProcessedTarget[]): list is null");
            return null;
        }
        if (pts.length < 1) {
            System.err.println("DistanceCalculator calculate(ProcessedTarget[]): list is empty");
            return null;
        }
        ProcessedTarget pt = findBiggestTarget(pts);
        return internalCalculate(pt, pts.length);
    }

    public static DistanceReport calculateLinearDistance(ParticleAnalysisReport[] pars) {
        if (pars == null) {
            System.err.println("DistanceCalculator calculate(ParticalAnalaysisReport[]): list is null");
            return null;
        }
        if (pars.length < 1) {
            System.err.println("DistanceCalculator calculate(ParticalAnalaysisReport[]): list is empty");
            return null;
        }
        ProcessedTarget pt = findBiggestTarget(pars);
        return internalCalculate(pt, pars.length);
    }

    private static DistanceReport internalCalculate(ProcessedTarget pt, int numberOfTargets) {
        double distance;
        distance = calculateDistance(pt);
        return new DistanceReport(distance, numberOfTargets, pt);
    }

    private static double calculateDistance(ProcessedTarget pt) {
        double heightToTarget = pt.getDistanceFromGround() - VstC.HEIGHT_OF_AXIS_CAMERA;
        double angleToTarget = getAngleToTarget(pt);
        double returnValue = (heightToTarget) / Math.tan(angleToTarget);
        return returnValue;
    }

    private static double getAngleToTarget(ProcessedTarget pt) {
        double bottomOfTargetY = pt.getY() + pt.getHeight();
        double percentOfImageHeight = bottomOfTargetY * 100 / VstC.PIXEL_HEIGHT_OF_CAMERA;
        double totalAngle = VstC.AXIS_CAMERA_H_OBSERVATION_ANGLE;
        double angleToTarget = (totalAngle / 2) - (totalAngle * percentOfImageHeight);
        return angleToTarget;
    }

    private static ProcessedTarget findBiggestTarget(ProcessedTarget[] pts) {
        if (pts.length < 1) {
            return null;
        }
        int biggestArea = 0;
        int biggestTarget = -1;
        for (int i = 0; i < pts.length; i++) {
            if (biggestTarget == -1) {
                biggestTarget = i;
                continue;
            }
            int area = pts[i].getArea();
            if (area > biggestArea) {
                biggestArea = area;
                biggestTarget = i;
            }
        }
        if (biggestTarget < 0) {
            System.err.println("DistanceCalculator findBiggestTarget(ProcessedTarget[]): BIGGEST TARGET ERROR THIS SHOULD NEVER HAPPEN");
            return null;
        }
        if (biggestTarget > pts.length) {
            System.err.println("DistanceCalculator findBiggestTarget(ProcessedTarget[]): SECOND BIGGEST TARGET ERROR THIS SHOULD NEVER HAPPEN");
            return null;
        }
        return pts[biggestTarget];
    }

    private static ProcessedTarget findBiggestTarget(ParticleAnalysisReport[] pars) {
        if (pars.length < 1) {
            return null;
        }
        int biggestArea = 0;
        int biggestTarget = -1;
        for (int i = 0; i < pars.length; i++) {
            if (biggestTarget == -1) {
                biggestTarget = i;
                continue;
            }
            int area = pars[i].boundingRectHeight * pars[i].boundingRectWidth;
            if (area > biggestArea) {
                biggestArea = area;
                biggestTarget = i;
            }
        }
        if (biggestTarget < 0) {
            System.err.println("DistanceCalculator findBiggestTarget(ParticleAnalysisReport[]): BIGGEST TARGET ERROR THIS SHOULD NEVER HAPPEN");
            return null;
        }
        if (biggestTarget > pars.length) {
            System.err.println("DistanceCalculator findBiggestTarget(ParticleAnalysisReport[]): SECOND BIGGEST TARGET ERROR THIS SHOULD NEVER HAPPEN");
            return null;
        }
        return new ProcessedTarget(pars[biggestTarget]);
    }
}
