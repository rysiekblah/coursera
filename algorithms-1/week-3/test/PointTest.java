import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tomek on 9/28/14.
 */
public class PointTest {
    @Test
    public void test() {
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(26000, 15000));
        points.add(new Point(24000, 30000));
        points.add(new Point(15000, 1000));
        points.add(new Point(12000, 3000));
        points.add(new Point(2000, 7000));
        points.add(new Point(1000, 13000));
        points.add(new Point(18000, 23000));
        points.add(new Point(22000, 9000));
        points.add(new Point(4000, 15000));
        points.add(new Point(6000, 16000));
        points.add(new Point(22000, 17000));
        points.add(new Point(9000, 26000));
        points.add(new Point(19000, 24000));
        points.add(new Point(24000, 30000));

        Collections.sort(points);

    }



}
