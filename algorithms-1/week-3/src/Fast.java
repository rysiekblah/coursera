/**
 * Created by tomek on 2/18/15.
 */
public class Fast {
    public static void main(String[] args) {
        if (args.length < 1) return;
        if (args.length < 1) return;
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            points[i] = p;
        }
        fast(points);
    }

    private static void fast(Point[] points) {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        for (int i = 0; i < points.length; i++) {
            points[i].draw();
            for (int j = i + 1; j < points.length; j++) {
                //StdOut.print(points[i] + " - " + points[j] + " : " + points[i].slopeTo(points[j]) + "\n");
            }
        }

    }
}
