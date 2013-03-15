package edu.wpi.first.wpilibj.templates.variablestores.dynamic;

/**
 * Dynamic Camera (Motor) Variable Store.
 *
 * @author daboross
 */
public class DVstCamera {

    /**
     * False is left, true is right.
     */
    private static boolean cameraPosition;

    /**
     * False is left, true is right.
     */
    public static void setCameraPosition(final boolean cameraPositionSet) {
        cameraPosition = cameraPositionSet;
    }

    /**
     * False is left, true is right.
     */
    public static boolean cameraPosition() {
        return cameraPosition;
    }
}
