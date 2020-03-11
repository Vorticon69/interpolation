package ca.gc.dfo.spine.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsMathsTests {
    @Test
    void testCloseTo() {
        Assertions.assertTrue(Utils.Maths.closeTo(0,0));
        Assertions.assertTrue(Utils.Maths.closeTo(0.1,0.1));
        Assertions.assertTrue(Utils.Maths.closeTo(-0.1,-0.1));

        Assertions.assertTrue(Utils.Maths.closeTo(5,4.99999));
        Assertions.assertFalse(Utils.Maths.closeTo(5,4.9));

    }
    @Test
    void testCloseToZero() {
        Assertions.assertTrue(Utils.Maths.closeToZero(0));

        Assertions.assertFalse(Utils.Maths.closeToZero(1));
        Assertions.assertFalse(Utils.Maths.closeToZero(-1));

        Assertions.assertTrue(Utils.Maths.closeToZero(0.0001));
        Assertions.assertTrue(Utils.Maths.closeToZero(-0.0001));

        Assertions.assertFalse(Utils.Maths.closeToZero(0.1));
        Assertions.assertFalse(Utils.Maths.closeToZero(-0.1));
    }
    @Test
    void testDot2() {
        /*
        Pythagoras
        a^2 + b^2 = c^2

        3^2 + 4^2 = 5^2
        */
        double a = 3;
        double b = 4;
        double res = Math.sqrt(Utils.Maths.dot2(a, b));
        Assertions.assertTrue(Utils.Maths.closeTo(5, res));
    }
    @Test
    void testGreaterThan() {
        Assertions.assertTrue(Utils.Maths.greaterThan(5, 2));
        Assertions.assertFalse(Utils.Maths.greaterThan(2, 5));
        Assertions.assertTrue(Utils.Maths.greaterThan(-2, -5));
        Assertions.assertFalse(Utils.Maths.greaterThan(-5, -2));

        Assertions.assertTrue(Utils.Maths.closeTo(5,4.99999));
        // so we assume that they are equals
        Assertions.assertFalse(Utils.Maths.greaterThan(5, 4.99999));
    }
    @Test
    void testLessThan() {
        Assertions.assertFalse(Utils.Maths.lessThan(5, 2));
        Assertions.assertTrue(Utils.Maths.lessThan(2, 5));
        Assertions.assertFalse(Utils.Maths.lessThan(-2, -5));
        Assertions.assertTrue(Utils.Maths.lessThan(-5, -2));

        Assertions.assertTrue(Utils.Maths.closeTo(5,4.99999));
        // so we assume that they are equals
        Assertions.assertFalse(Utils.Maths.lessThan(5, 4.99999));
    }
    @Test
    void testLinearInterpolation() {
        double res = Utils.Maths.linearInterpolation(-1,1,2);
        Assertions.assertTrue(Utils.Maths.closeTo(0, res));
        res = Utils.Maths.linearInterpolation(0,1,2);
        Assertions.assertTrue(Utils.Maths.closeTo(1, res));
        res = Utils.Maths.linearInterpolation(.5,1,2);
        Assertions.assertTrue(Utils.Maths.closeTo(1.5, res));
        res = Utils.Maths.linearInterpolation(1,1,2);
        Assertions.assertTrue(Utils.Maths.closeTo(2, res));
        res = Utils.Maths.linearInterpolation(2,1,2);
        Assertions.assertTrue(Utils.Maths.closeTo(3, res));
    }
}
