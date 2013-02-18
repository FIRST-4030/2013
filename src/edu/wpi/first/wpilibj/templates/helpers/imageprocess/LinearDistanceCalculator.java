package edu.wpi.first.wpilibj.templates.helpers.imageprocess;

import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.templates.helpers.ProcessError;
import edu.wpi.first.wpilibj.templates.variablestores.VstC;

/**
 * Robot Distance Calculator. Class full of static methods to calculate the
 * distance to a target. This Class ONLY Calculates the Distance to a target,
 * NOT the angle or any other values.
 */
public class LinearDistanceCalculator {

    /**
     * This Calculates the linear distance to a target, it will take the biggest
     * target from the list.
     */
    public static LinearDistanceReport calculateLinearDistance(ProcessedTarget[] pts) {
        if (pts == null) {
            System.err.println("DistanceCalculator calculate(ProcessedTarget[]): list is null");
            return new LinearDistanceReport(new ProcessError("LinearDistanceCalculator calculateLinearDistance", "Processed Target List Passed Is Null"));
        }
        if (pts.length < 1) {
            System.err.println("DistanceCalculator calculate(ProcessedTarget[]): list is empty");
            return new LinearDistanceReport(new ProcessError("LinearDistanceCalculator calculateLinearDistance", "Processed Target List Passed Is Empty"));

        }
        ProcessError possibleError = new ProcessError("LinearDistanceCalculator");
        ProcessedTarget pt = findMiddleTarget(pts);
        return possibleError.isError() ? new LinearDistanceReport(possibleError) : internalCalculate(pt, pts.length);
    }

    /**
     * This Calculates the linear distance to a target, it will take the biggest
     * target from the list.
     */
    public static LinearDistanceReport calculateLinearDistance(ParticleAnalysisReport[] pars) {
        if (pars == null) {
            System.err.println("DistanceCalculator calculate(ParticalAnalaysisReport[]): list is null");
            return new LinearDistanceReport(new ProcessError("LinearDistanceCalculator calculateLinearDistance", "Processed Target List Passed Is Null"));
        }
        if (pars.length < 1) {
            System.err.println("DistanceCalculator calculate(ParticalAnalaysisReport[]): list is empty");
            return new LinearDistanceReport(new ProcessError("LinearDistanceCalculator calculateLinearDistance", "Processed Target List Passed Is Empty"));
        }

        ProcessError possibleError = new ProcessError("LinearDistanceCalculator");
        ProcessedTarget pt = findMiddleTarget(pars);
        return possibleError.isError() ? new LinearDistanceReport(possibleError) : internalCalculate(pt, pars.length);
    }

    public static void targetToNetwork(ParticleAnalysisReport[] para){
        //========================================
        //Robot Code
        // declare object
        NetworkTable cameraTable;

        // getinstance (table is a singleton, if one does not exist then one will
        // be created otherwise returns reference to existing instance
        cameraTable = NetworkTable.getTable("camera");

        // get data element from the table
        // default values returned if no data has been provided from another source yet

        ProcessedTarget t =findMiddleTarget(para);
        
        int a[] = {t.getX(),t.getY(),t.getWidth(),t.getHeight()};
        cameraTable.putValue("middleTarget", a);
    }

    private static LinearDistanceReport internalCalculate(ProcessedTarget pt, int numberOfTargets) {
        double distance;
        ProcessError possibleError = new ProcessError("LinearDistanceCalculator");
        distance = calculateDistance(pt, possibleError);
        return possibleError.isError() ? new LinearDistanceReport(possibleError) : new LinearDistanceReport(distance, numberOfTargets, pt);
    }

    private static double calculateDistance(ProcessedTarget pt, ProcessError possibleError) {
        double heightToTarget = pt.getDistanceFromGround() - VstC.HEIGHT_OF_AXIS_CAMERA;
        double angleToTarget = getAngleToTarget(pt, possibleError);
        double returnValue = (heightToTarget) / Math.tan(angleToTarget);
        return returnValue;
    }

    private static double getAngleToTarget(ProcessedTarget pt, ProcessError possibleError) {
        if (pt == null) {
            possibleError.setErrored("LinearDistanceCalculator", "Null ProcesseTarget passed to getAngleToTarget");
            return 0.0;
        }
        double bottomOfTargetY = pt.getY() + pt.getHeight();
        double percentOfImageHeight = bottomOfTargetY * 100 / VstC.PIXEL_HEIGHT_OF_CAMERA;
        double totalAngle = VstC.AXIS_CAMERA_H_OBSERVATION_ANGLE;
        double angleToTarget = (totalAngle / 2) - (totalAngle * percentOfImageHeight);
        return angleToTarget;
    }

    private static ProcessedTarget findBiggestTarget(ProcessedTarget[] pts, ProcessError possibleError) {
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
            possibleError.setErrored("LinearDistanceCalculator", "BIGGEST TARGET ERROR THIS SHOULD NEVER HAPPEN");
            return null;
        }
        if (biggestTarget > pts.length) {
            possibleError.setErrored("LinearDistanceCalculator", "BIGGEST TARGET ERROR 2 THIS SHOULD NEVER HAPPEN");
            return null;
        }
        return pts[biggestTarget];
    }

    private static ProcessedTarget findBiggestTarget(ParticleAnalysisReport[] pars, ProcessError possibleError) {
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
            possibleError.setErrored("LinearDistanceCalculator", "BIGGEST TARGET ERROR THIS SHOULD NEVER HAPPEN");
            return null;
        }
        if (biggestTarget > pars.length) {
            possibleError.setErrored("LinearDistanceCalculator", "BIGGEST TARGET ERROR 2 THIS SHOULD NEVER HAPPEN");
            return null;
        }
        return new ProcessedTarget(pars[biggestTarget]);
    }
    
    private static ProcessedTarget findMiddleTarget(ProcessedTarget[] pts) {
        if (pts.length < 1) {
            return null;
        }
        int biggestArea = 0;
        int biggestTarget = -1;
        int biggestWidth = 0;
        for (int i = 0; i < pts.length; i++) {
            if (biggestTarget == -1) {
                biggestTarget = i;
                continue;
            }
            int area = pts[i].getArea();
            if (area > biggestArea) {
                biggestArea = area;
                biggestTarget = i;
                biggestWidth = pts[i].getWidth();
            }
        }
        int width;
        int middleTarget=0;
        for(int i=0; i<pts.length; i++){
            width = pts[i].getWidth();
            if(width > biggestWidth*.8){
                if(width/pts[i].getHeight() > 2.5){
                    middleTarget = i;
                    break;
                }
            }
        }
        return pts[biggestTarget];
    }
    
    private static ProcessedTarget findMiddleTarget(ParticleAnalysisReport[] pars) {
        if (pars.length < 1) {
            return null;
        }
        int biggestArea = 0;
        int biggestTarget = -1;
        int biggestWidth = 0;
        for (int i = 0; i < pars.length; i++) {
            if (biggestTarget == -1) {
                biggestTarget = i;
                continue;
            }
            int area = pars[i].boundingRectHeight * pars[i].boundingRectWidth;
            if (area > biggestArea) {
                biggestArea = area;
                biggestTarget = i;
                biggestWidth = pars[i].boundingRectWidth;
            }
        }
        int width;
        int middleTarget=0;
        for(int i=0; i<pars.length; i++){
            width = pars[i].boundingRectWidth;
            if(width > biggestWidth*.8){
                if(width/pars[i].boundingRectHeight > 2.5){
                    middleTarget = i;
                    break;
                }
            }
        }
        return new ProcessedTarget(pars[middleTarget]);
    }
}
