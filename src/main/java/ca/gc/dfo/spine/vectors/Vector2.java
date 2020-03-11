package ca.gc.dfo.spine.vectors;

import ca.gc.dfo.spine.tools.Utils;

public class Vector2 {
    public double x, y;

    public Vector2(double _x, double _y) { x = _x; y = _y; }
    public Vector2(Point2 p1, Point2 p2) { this(p2.x - p1.x,p2.y - p1.y); }
    public Vector2(Segment2 s) { this(s.a, s.b); }

    public static double angle(Vector2 u, Vector2 v)
    {
        final double num = Vector2.dot2(u, v);
        final double denom = Vector2.length(u) * Vector2.length(v);
        return Math.acos(num / denom);
    }
    public static double dot2(Vector2 u, Vector2 v) { return Utils.Maths.dot2(u.x, u.y, v.x, v.y); }
    public static double length(Vector2 v) {
        final double l2 = lengthSquared(v);
        if(Utils.Maths.closeToZero(l2)) return 0.0;
        if(Utils.Maths.closeTo(l2,1)) return 1.0;
        return Math.sqrt(lengthSquared(v));
    }
    public static double lengthSquared(Vector2 v) { return dot2(v, v); }
    public static Vector2 mult(Vector2 v, double scalar) { return new Vector2(v.x*scalar,v.y*scalar); }
    public static double projection(Vector2 u, Vector2 v) { return dot2(u, v)/dot2(v, v); }
}
