
import java.util.List;

/**
 * Created by tomek on 9/28/14.
 */
public class Brute {

    public static void main(String[] args) {
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

    }

    private static void bruteForce(Point[] points) {
        double slope;
        //StdDraw.setPenRadius(0.001);
        for (int i = 0; i < points.length-1; i++) {
            for (int k = 0; k < points.length; k++) {
                slope = points[i].slopeTo(points[k]);
                if(slope == Double.NEGATIVE_INFINITY) continue;
                int index = 0;
                List<Integer> l = new ArrayList<>();
                List<Point> connected = new ArrayList<>();
                Point smallest = points[i];
                Point largest = points[k];
                for (int j = 0; j < points.length; j++) {
                    double sl2 = points[k].slopeTo(points[j]);
                    if (slope == sl2) {
                        index++;
                        if (smallest.compareTo(points[j]) > 0) {
                            smallest = points[j];
                        } else if (largest.compareTo(points[j]) < 0) {
                            largest = points[j];
                        }
                    }
                }
                if (index > 2) {
                    //smallest.drawTo(largest);

                }
            }
        }
    }

}