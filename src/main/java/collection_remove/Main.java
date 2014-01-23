package collection_remove;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: Daniel
 */
public class Main {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<Point>();

        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 1);
        Point point3 = new Point(3, 0);
        Point point4 = new Point(0, 0);
        Point point5 = new Point(1, 3);

        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
        points.add(point5);

        points.remove(point1);

        for (Point point : points) {
            System.out.println(point);
        }
    }
}
