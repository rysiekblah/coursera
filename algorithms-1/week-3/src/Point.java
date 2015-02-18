/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
        @Override
        public int compare(Point point1, Point point2) {
            double slope1 = slopeTo(point1);
            double slope2 = slopeTo(point2);
            //System.out.println("   - sl1: " + slope1 + ", sl2:" + slope2);
            if (slopeTo(point1) < slopeTo(point2)) return -1;
            if (slopeTo(point1) == slopeTo(point2)) return 0;
            return 1;
        }
    };

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    // (y1 − y0) / (x1 − x0)
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
        //System.out.println(" -- p1: " + that.toString() + ", p0: " + toString());
        if (that.x == this.x && that.y == this.y) return Double.NEGATIVE_INFINITY;
        if (that.y - this.y == 0) return 0;
        if (that.x - this.x == 0) return Double.POSITIVE_INFINITY;
        //System.out.println(" ---- calc -- y: " + (that.y - this.y) + ", x: " + (that.x - this.x) + ", y/x: " + (double)(that.y - this.y) / (that.x - this.x));
        return (double) (that.y - this.y) / (that.x - this.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        //System.out.println("compare: " + toString() + " with " + that.toString());

        if (this.y < that.y) return -1;
        if (this.y > that.y) return 1;
        if (this.y == that.y && this.x < that.x) return -1;
        if (this.y == that.y && this.x == that.x) return 0;
        return 1;

//        if ((this.y < that.y || this.y == that.y) && this.x < that.x) return -1;
//        if(this.x == that.x && this.y == that.y) return 0;

    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}
