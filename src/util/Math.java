package util;

public class Math {
    public static double roundTo0_05(double value) {
        double roundingFactor = 100d/5d;
        return java.lang.Math.round(value * roundingFactor) / roundingFactor;
    }
}
