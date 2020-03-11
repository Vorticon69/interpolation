package ca.gc.dfo.spine.vectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2Tests {
    @Test
    void testConstructors()
    {
        final Vector2 v1 = new Vector2(1,2);
        Assertions.assertEquals(1, v1.x);
        Assertions.assertEquals(2, v1.y);

        final Point2 p1 = new Point2(1,3);
        final Point2 p2 = new Point2(4,2);
        final Vector2 v2 = new Vector2(p1, p2);
        Assertions.assertEquals(3, v2.x);
        Assertions.assertEquals(-1, v2.y);

        final Segment2 s = new Segment2(p1, p2);
        final Vector2 v3 = new Vector2(s);
        Assertions.assertEquals(3, v3.x);
        Assertions.assertEquals(-1, v3.y);
    }
    @Test
    void testAngle()
    {
        final Vector2 u = new Vector2(3,0);
        final Vector2 v1 = new Vector2(-5,0);
        final double rad1 = Vector2.angle(u, v1);
        Assertions.assertEquals(Math.PI, rad1);

        final Vector2 v2 = new Vector2(0,23);
        final double rad2 = Vector2.angle(u, v2);
        Assertions.assertEquals(Math.PI/2, rad2);

        final Vector2 v3 = new Vector2(17,17);
        final double rad3 = Vector2.angle(u, v3);
        Assertions.assertEquals(Math.PI/4, rad3);
    }
    @Test
    void testDot2()
    {
        // This test is valid for unit vectors only
        final Vector2 u = new Vector2(1,0);
        final Vector2 v = new Vector2(0,1);
        final Vector2 w = new Vector2(-1,0);

        // 0 deg --- acos(1) = 0
        final double cosTheta1 = Vector2.dot2(u, u);
        Assertions.assertEquals(1, cosTheta1);
        // 90 deg --- acos(0) = pi/2
        final  double cosTheta2 = Vector2.dot2(u, v);
        Assertions.assertEquals(0, cosTheta2);
        // 180 deg --- acos(-1) = pi
        final double cosTheta3 = Vector2.dot2(u, w);
        Assertions.assertEquals(-1, cosTheta3);
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
        final Vector2 u1 = new Vector2(1,5);
        final Vector2 v = new Vector2(4,0);
        final double t1 = Vector2.projection(u1, v);
        Assertions.assertEquals(0.25, t1);

        final Vector2 u2 = new Vector2(2,5);
        final double t2 = Vector2.projection(u2, v);
        Assertions.assertEquals(0.5, t2);
    }
}
