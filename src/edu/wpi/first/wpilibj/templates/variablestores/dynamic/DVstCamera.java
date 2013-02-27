package edu.wpi.first.wpilibj.templates.variablestores.dynamic;

/**
 *
 * @author daboross
 */
public class DVstCamera {

    /**
     * False is left, true is right.
     */
    private static boolean cameraPosition;

    public static void setCameraPosition(final boolean cameraPositionV) {
        cameraPosition = cameraPositionV;
    }

    public static boolean cameraPosition() {
        return cameraPosition;
    }
}
