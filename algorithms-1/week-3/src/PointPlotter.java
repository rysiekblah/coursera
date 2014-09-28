import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*************************************************************************
 *  Compilation:  javac PointPlotter.java
 *  Execution:    java PointPlotter input.txt
 *  Dependencies: Point.java, In.java, StdDraw.java
 *
 *  Takes the name of a file as a command-line argument.
 *  Reads in an integer N followed by N pairs of points (x, y)
 *  with coordinates between 0 and 32,767, and plots them using
 *  standard drawing.
 *
 *************************************************************************/

public class PointPlotter {
    public static void main(String[] args) {

        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
//        StdDraw.setXscale(0, 20);
//        StdDraw.setYscale(0, 20);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01);  // make the points a bit larger

        List<Point> points = new ArrayList<Point>();

        // read in the input
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            points.add(p);
            //System.out.println(p.toString());
            p.draw();
        }

        Collections.sort(points);
        for (Point point : points) {
            System.out.println(point.toString());
        }


        bruteForce(points);


        // display to screen all at once
        StdDraw.show(0);

        // reset the pen radius
        StdDraw.setPenRadius();
    }



    private static void bruteForce(List<Point> points) {
        double slope;
        StdDraw.setPenRadius(0.001);
        for (int i = 0; i < points.size()-1; i++) {
            for (int k = 0; k < points.size(); k++) {
                slope = points.get(i).slopeTo(points.get(k));
                if(slope == Double.NEGATIVE_INFINITY) continue;
                int index = 0;
                Point smallest = points.get(i);
                Point lergest = points.get(k);
                for (int j = 0; j < points.size(); j++) {
                    double sl2 = points.get(k).slopeTo(points.get(j));
                    if (slope == sl2) {
                        index++;
                        if (smallest.compareTo(points.get(j)) > 0) {
                            smallest = points.get(j);
                        } else if (lergest.compareTo(points.get(j)) < 0) {
                            lergest = points.get(j);
                        }
                    }
                }
                if (index > 2) {
                    smallest.drawTo(lergest);
                }
            }
        }
    }
}
