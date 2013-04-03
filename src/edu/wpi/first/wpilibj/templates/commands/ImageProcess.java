//package edu.wpi.first.wpilibj.templates.commands;
//
//import edu.wpi.first.wpilibj.templates.helpers.imageprocess.ImageProcessMain;
//import edu.wpi.first.wpilibj.templates.subsystems.Camera;
//
///**
// * This is a Command that initializes Image Processing once, then is finished.
// */
//public class ImageProcess extends CommandBase {
//
//    private boolean finished = false;
//
//    public ImageProcess() {
//        requires(mainCamera);
//    }
//
//    protected void initialize() {
//    }
//
//    protected void execute() {
//        if (Camera.cameraEnabled) {
//            ImageProcessMain.runReport(mainCamera);
//        } else {
//            System.out.println("ImageProcess tried to execute when Camera was disabled, Change this in Camera.java.");
//        }
//        finished = true;
//    }
//
//    protected boolean isFinished() {
//        return finished;
//    }
//
//    protected void end() {
//    }
//}
