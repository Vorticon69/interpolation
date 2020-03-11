package ca.gc.dfo.spine.utils;

    public class Maths {
        public static final double EPSILON = 0.0001;

        public static Boolean closeTo(final double x, final double y) { return closeToZero(x - y, EPSILON); }
        public static Boolean closeTo(final double x, final double y, final double tolerance) { return closeToZero(x - y, tolerance); }
        public static Boolean closeToZero(final double x) { return closeToZero(x, EPSILON); }
        public static Boolean closeToZero(final double x, final double tolerance) { return Math.abs(x) <= Math.abs(tolerance); }
        public static double dot2(final double x, final double y) { return dot2(x, y, x, y); }
        public static double dot2(final double x1, final double y1, final double x2, final double y2) { return x1*x2 + y1*y2; }
        public static Boolean greaterThan(final double x, final double y) { return x > y && !closeTo(x, y); }
        public static Boolean lessThan(final double x, final double y) { return x < y && !closeTo(x, y); }
        public static double linearInterpolation(final double x, final double a, final double b) { return a + x*(b - a); }
    }
