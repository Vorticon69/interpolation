package ca.gc.dfo.spine.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathsTests {
    @Test
    void testCloseTo() {
        Assertions.assertTrue(Maths.closeTo(0,0));
        Assertions.assertTrue(Maths.closeTo(0.1,0.1));
        Assertions.assertTrue(Maths.closeTo(-0.1,-0.1));

        Assertions.assertTrue(Maths.closeTo(5,4.99999));
        Assertions.assertFalse(Maths.closeTo(5,4.9));

        Assertions.assertTrue(Maths.closeTo(0.2, 0.3, 0.1));
        Assertions.assertFalse(Maths.closeTo(0.3, 0.2, 0.01));
    }
    @Test
    void testCloseToZero() {
        Assertions.assertTrue(Maths.closeToZero(0));

        Assertions.assertFalse(Maths.closeToZero(1));
        Assertions.assertFalse(Maths.closeToZero(-1));

        Assertions.assertTrue(Maths.closeToZero(0.0001));
        Assertions.assertTrue(Maths.closeToZero(-0.0001));

        Assertions.assertFalse(Maths.closeToZero(0.1));
        Assertions.assertFalse(Maths.closeToZero(-0.1));

        Assertions.assertTrue(Maths.closeToZero(0.1,0.1));
        Assertions.assertFalse(Maths.closeToZero(-0.1,0.01));
    }
    @Test
    void testDot2() {
        /*
        Pythagoras
        a^2 + b^2 = c^2

        3^2 + 4^2 = 5^2
        */
        final double a = 3;
        final double b = 4;
        final double res = Math.sqrt(Maths.dot2(a, b));
        Assertions.assertTrue(Maths.closeTo(5, res));
    }
    @Test
    void testGreaterThan() {
        Assertions.assertTrue(Maths.greaterThan(5, 2));
        Assertions.assertFalse(Maths.greaterThan(2, 5));
        Assertions.assertTrue(Maths.greaterThan(-2, -5));
        Assertions.assertFalse(Maths.greaterThan(-5, -2));

        Assertions.assertTrue(Maths.closeTo(5,4.99999));
        // so we assume that they are equals
        Assertions.assertFalse(Maths.greaterThan(5, 4.99999));
    }
    @Test
    void testLessThan() {
        Assertions.assertFalse(Maths.lessThan(5, 2));
        Assertions.assertTrue(Maths.lessThan(2, 5));
        Assertions.assertFalse(Maths.lessThan(-2, -5));
        Assertions.assertTrue(Maths.lessThan(-5, -2));

        Assertions.assertTrue(Maths.closeTo(5,4.99999));
        // so we assume that they are equals
        Assertions.assertFalse(Maths.lessThan(5, 4.99999));
    }
    @Test
    void testLinearInterpolation() {
        double res = Maths.linearInterpolation(-1,1,2);
        Assertions.assertTrue(Maths.closeTo(0, res));
        res = Maths.linearInterpolation(0,1,2);
        Assertions.assertTrue(Maths.closeTo(1, res));
        res = Maths.linearInterpolation(.5,1,2);
        Assertions.assertTrue(Maths.closeTo(1.5, res));
        res = Maths.linearInterpolation(1,1,2);
        Assertions.assertTrue(Maths.closeTo(2, res));
        res = Maths.linearInterpolation(2,1,2);
        Assertions.assertTrue(Maths.closeTo(3, res));
    }
}
