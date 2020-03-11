package ca.gc.dfo.spine.vectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2Tests {
    @Test
    void testConstructors()
    {
        Vector2 v = new Vector2(1,2);
        Assertions.assertEquals(1, v.x);
        Assertions.assertEquals(2, v.y);

        Point2 p1 = new Point2(1,3);
        Point2 p2 = new Point2(4,2);
        v = new Vector2(p1, p2);
        Assertions.assertEquals(3, v.x);
        Assertions.assertEquals(-1, v.y);

        Segment2 s = new Segment2(p1, p2);
        v = new Vector2(s);
        Assertions.assertEquals(3, v.x);
        Assertions.assertEquals(-1, v.y);
    }
    @Test
    void testAngle()
    {
        final Vector2 u = new Vector2(3,0);
        Vector2 v = new Vector2(-5,0);
        double rad = Vector2.angle(u, v);
        Assertions.assertEquals(Math.PI, rad);

        v = new Vector2(0,23);
        rad = Vector2.angle(u, v);
        Assertions.assertEquals(Math.PI/2, rad);

        v = new Vector2(17,17);
        rad = Vector2.angle(u, v);
        Assertions.assertEquals(Math.PI/4, rad);
    }
    @Test
    void testDot2()
    {
        // This test is valid for unit vectors only
        final Vector2 u = new Vector2(1,0);
        final Vector2 v = new Vector2(0,1);
        final Vector2 w = new Vector2(-1,0);

        // 0 deg --- acos(1) = 0
        double cosTheta = Vector2.dot2(u, u);
        Assertions.assertEquals(1, cosTheta);
        // 90 deg --- acos(0) = pi/2
        cosTheta = Vector2.dot2(u, v);
        Assertions.assertEquals(0, cosTheta);
        // 180 deg --- acos(-1) = pi
        cosTheta = Vector2.dot2(u, w);
        Assertions.assertEquals(-1, cosTheta);
    }
    @Test
    void testLength()
    {
        final Vector2 v = new Vector2(3,4);
        final double l = Vector2.length(v);
        Assertions.assertEquals(5, l);
    }
    @Test
    void testLengthSquared()
    {
        final Vector2 v = new Vector2(3,4);
        final double ls = Vector2.lengthSquared(v);
        Assertions.assertEquals(25, ls);
    }
    @Test
    void testMult()
    {
        final Vector2 v1 = new Vector2(3,4);
        final Vector2 v2 = Vector2.mult(v1,3);
        Assertions.assertEquals(9, v2.x);
        Assertions.assertEquals(12, v2.y);
    }
    @Test
    void testProjection()
    {
        Vector2 u = new Vector2(1,5);
        final Vector2 v = new Vector2(4,0);
        double t = Vector2.projection(u, v);
        Assertions.assertEquals(0.25, t);

        u = new Vector2(2,5);
        t = Vector2.projection(u, v);
        Assertions.assertEquals(0.5, t);
    }
}
