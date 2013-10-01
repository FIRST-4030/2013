package org.ingrahamrobotics.robot2013;

/**
 * This class holds various helpful methods, such as rounding.
 */
public class HM {

    /**
     * This multiplies the value by the place, then rounds the value to the
     * nearest whole number, then divides the value by the place.
     *
     * @param place The number of decimal places.
     * @param value The value to round.
     * @return The value rounded to place decimal places.
     */
    public static double round(int place, double value) {
        return ((int) (value * place)) / ((double) place);
    }

    /**
     * This calls round(100, value).
     *
     * @param value The value to round
     * @return round(100, value)
     */
    public static double round(double value) {
        return round(100, value);
    }
}
