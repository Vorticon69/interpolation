package ca.gc.dfo.spine.vectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Segment2Tests {
    @Test
    void testConstructors()
    {
        final Point2 p1 = new Point2(1,3);
        final Point2 p2 = new Point2(4,2);
        final Segment2 s = new Segment2(p1, p2);
        Assertions.assertEquals(p1.x, s.a.x);
        Assertions.assertEquals(p1.y, s.a.y);
        Assertions.assertEquals(p2.x, s.b.x);
        Assertions.assertEquals(p2.y, s.b.y);
    }
    @Test
    void testGetPoint2At()
    {
        final Point2 p1 = new Point2(1,3);
        final Point2 p2 = new Point2(4,2);
        final Segment2 s = new Segment2(p1, p2);
        final Point2 p3 = Segment2.getPoint2At(s,0.5);
        Assertions.assertEquals(2.5, p3.x);
        Assertions.assertEquals(2.5, p3.y);
        final Point2 p4 = Segment2.getPoint2At(s,-0.5);
        Assertions.assertEquals(-0.5, p4.x);
        Assertions.assertEquals(3.5, p4.y);
    }
    @Test
    void testLength()
    {
        final Point2 p1 = new Point2(1,3);
        final Point2 p2 = new Point2(p1.x + 3, p1.y - 4);
        final Segment2 s = new Segment2(p1, p2);
        final double l = Segment2.length(s);
        Assertions.assertEquals(5, l);
    }
    @Test
    void testProjection()
    {
        final Point2 p1 = new Point2(1,1);
        final  Point2 p2 = new Point2(1,5);
        final Segment2 s = new Segment2(p1, p2);
        final Point2 p = new Point2(0,2);
        final double t = Segment2.projection(p, s);
        Assertions.assertEquals(0.25, t);
    }
}
