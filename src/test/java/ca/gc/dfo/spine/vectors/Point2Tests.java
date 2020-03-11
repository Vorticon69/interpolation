package ca.gc.dfo.spine.vectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Point2Tests {
    @Test
    void testConstructors()
    {
        final Point2 p = new Point2(1,2);
        Assertions.assertEquals(1, p.x);
        Assertions.assertEquals(2, p.y);
    }
    @Test
    void testAdd()
    {
        final Point2 p = new Point2(1,2);
        final Vector2 v = new Vector2(3,4);
        final Point2 p3 = Point2.add(p, v);
        Assertions.assertEquals(4, p3.x);
        Assertions.assertEquals(6, p3.y);
    }
    @Test
    void testDistance()
    {
        final  double x1 = 5;
        final double x2 = x1 + 3;
        final double y1 = 7;
        final double y2 = y1 + 4;

        // Pythagoras
        // dx = 3, dy = 4
        // dx^2 + dy^2 = c^2
        // c = 5
        final Point2 p1 = new Point2(x1, y1);
        final Point2 p2 = new Point2(x2, y2);
        final double distance = Point2.distance(p1, p2);
        Assertions.assertEquals(5, distance);
    }
}
