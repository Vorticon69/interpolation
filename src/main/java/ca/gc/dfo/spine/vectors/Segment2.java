package ca.gc.dfo.spine.vectors;

public class Segment2 {
    public Point2 a, b;

    public Segment2(Point2 _a, Point2 _b) { a = _a; b = _b; }

    public static Point2 getPoint2At(Segment2 s, double t) { return Point2.add(s.a, Vector2.mult(new Vector2(s), t)); }
    public static double length(Segment2 s) { return Point2.distance(s.a, s.b); }
    public static double projection(Point2 p, Segment2 s) {
        final Vector2 u = new Vector2(s.a, p);
        final Vector2 v = new Vector2(s.a, s.b);
        return Vector2.projection(u, v);
    }
}
