
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomek on 9/28/14.
 */
public class Brute {

    public static void main(String[] args) {
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
        brute(points);
    }

    private static void bruteForce(Point[] points) {
        double slope;
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (int i = 0; i < points.length-1; i++) {
            for (int k = 0; k < points.length; k++) {
                slope = points[i].slopeTo(points[k]);
                if (slope == Double.NEGATIVE_INFINITY) continue;
                int index = 0;
                List<Point> connected = new ArrayList<>();
                Point smallest = points[i];
                Point largest = points[k];
                connected.add(largest);
                //StdOut.print(" -- S: " + smallest.toString() + ", L: " + largest.toString() + "\n");
                for (int j = 0; j < points.length; j++) {
                    double sl2 = points[k].slopeTo(points[j]);
                    if (slope == sl2) {
                        index++;
                        if (smallest.compareTo(points[j]) > 0) {
                            smallest = points[j];
                        } else if (largest.compareTo(points[j]) < 0) {
                            largest = points[j];
                        }
                        connected.add(points[j]);
                    }
                }
                if (index > 2) {

                    for (Point point : connected) {
                        StdOut.print(point);
                        //StdOut.print(" --> ");
                    }
                    StdOut.print("\n");
                    smallest.drawTo(largest);
                }
            }
        }
    }

    private static void brute(Point[] points) {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        Quick.sort(points);
        for (int i = 0; i < points.length; i++) {
            points[i].draw();
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        double ij = points[i].slopeTo(points[j]);
                        double jk = points[j].slopeTo(points[k]);
                        double kl = points[k].slopeTo(points[l]);
                        double li = points[l].slopeTo(points[i]);
                        if (ij == jk && jk == kl && kl == li && li == ij) {
                            StdOut.print(points[i] + " -> " + points[j] + " -> " + points[k] + " -> " + points[l] + "\n");
                            points[i].drawTo(points[l]);
                        }
                    }
                }
            }
        }
    }

}