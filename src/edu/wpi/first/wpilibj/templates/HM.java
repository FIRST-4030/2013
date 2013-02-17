package edu.wpi.first.wpilibj.templates;

/**
 * This class holds various helpful methods, such as rounding.
 */
public class HM {

    public static double round(int place, double value) {
        return ((double) ((int) (value * place))) / (place);
    }

    public static double round(double value) {
        return round(100, value);
    }
}
