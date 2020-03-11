package ca.gc.dfo.spine.vectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Segment2Tests {
    @Test
    void testConstructors()
    {
        Point2 p1 = new Point2(1,3);
        Point2 p2 = new Point2(4,2);
        Segment2 s = new Segment2(p1, p2);
        Assertions.assertEquals(p1.x, s.a.x);
        Assertions.assertEquals(p1.y, s.a.y);
        Assertions.assertEquals(p2.x, s.b.x);
        Assertions.assertEquals(p2.y, s.b.y);
    }
    @Test
    void testGetPoint2At()
    {
        Point2 p1 = new Point2(1,3);
        Point2 p2 = new Point2(4,2);
        Segment2 s = new Segment2(p1, p2);
        Point2 p = Segment2.getPoint2At(s,0.5);
        Assertions.assertEquals(2.5, p.x);
        Assertions.assertEquals(2.5, p.y);
        p = Segment2.getPoint2At(s,-0.5);
        Assertions.assertEquals(-0.5, p.x);
        Assertions.assertEquals(3.5, p.y);
    }
    @Test
    void testLength()
    {
        Point2 p1 = new Point2(1,3);
        Point2 p2 = new Point2(p1.x + 3, p1.y - 4);
        Segment2 s = new Segment2(p1, p2);
        double l = Segment2.length(s);
        Assertions.assertEquals(5, l);
    }
    @Test
    void testProjection()
    {
        Point2 p1 = new Point2(1,1);
        Point2 p2 = new Point2(1,5);
        Segment2 s = new Segment2(p1, p2);
        Point2 p = new Point2(0,2);
        double t = Segment2.projection(p, s);
        Assertions.assertEquals(0.25, t);
    }
}
