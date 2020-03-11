package ca.gc.dfo.spine.vectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Point2Tests {
    @Test
    void testConstructors()
    {
        Point2 p = new Point2(1,2);
        Assertions.assertEquals(1, p.x);
        Assertions.assertEquals(2, p.y);
    }
    @Test
    void testAdd()
    {
        Point2 p = new Point2(1,2);
        Vector2 v = new Vector2(3,4);
        Point2 p3 = Point2.add(p, v);
        Assertions.assertEquals(4, p3.x);
        Assertions.assertEquals(6, p3.y);
    }
    @Test
    void testDistance()
    {
        double x1 = 5;
        double x2 = x1 + 3;
        double y1 = 7;
        double y2 = y1 + 4;

        // Pythagoras
        // dx = 3, dy = 4
        // dx^2 + dy^2 = c^2
        // c = 5
        Point2 p1 = new Point2(x1, y1);
        Point2 p2 = new Point2(x2, y2);
        double d = Point2.distance(p1, p2);
        Assertions.assertEquals(5, d);
    }
}
