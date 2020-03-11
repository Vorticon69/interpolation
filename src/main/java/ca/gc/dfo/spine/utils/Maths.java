package ca.gc.dfo.spine.utils;

    public class Maths {
        public static final double EPSILON = 0.0001;

        public static Boolean closeTo(double x, double y) { return closeToZero(x - y); }
        public static Boolean closeToZero(double x) { return Math.abs(x) <= EPSILON; }
        public static double dot2(double x, double y) { return dot2(x, y, x, y); }
        public static double dot2(double x1, double y1, double x2, double y2) { return x1*x2 + y1*y2; }
        public static Boolean greaterThan(double x, double y) { return x > y && !closeTo(x, y); }
        public static Boolean lessThan(double x, double y) { return x < y && !closeTo(x, y); }
        public static double linearInterpolation(double x, double a, double b) { return a + x*(b - a); }
    }
