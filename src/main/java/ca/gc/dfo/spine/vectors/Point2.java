package ca.gc.dfo.spine.vectors;

public class Point2 {
    public double x, y;

    public Point2(final double _x, final double _y) { x = _x; y = _y; }

    public static Point2 add(final Point2 p, final Vector2 v) { return new Point2(p.x + v.x, p.y + v.y); }
    public static double distance(final Point2 p1, final Point2 p2) { return Vector2.length(new Vector2(p1, p2)); }
}
