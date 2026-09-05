import java.util.*;

public class Chaikin {
    public static final long WINDOW_MS = 500;
    public static final int SMOOTHING_STEPS = 6;

    public static List<Point> chaikin(List<Point> points) {
        if (points == null) {
            return new ArrayList<>();
        }
        if (points.size() < 2) {
            return new ArrayList<>(points);
        }

        List<Point> result = new ArrayList<>();

        Point first = points.get(0);
        result.add(new Point(first.x, first.y));

        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);

            float x1 = p1.x + 0.25f * (p2.x - p1.x);
            float y1 = p1.y + 0.25f * (p2.y - p1.y);
            float x2 = p1.x + 0.75f * (p2.x - p1.x);
            float y2 = p1.y + 0.75f * (p2.y - p1.y);

            result.add(new Point(x1, y1));
            result.add(new Point(x2, y2));
        }

        Point last = points.get(points.size() - 1);
        result.add(new Point(last.x, last.y));

        return result;
    }

    public static void chaikinStep(Root root) {
        if (!root.isEnterPressed || root.originalPoints.size() <= 2) {
            return;
        }

        long now = System.currentTimeMillis();
        if (now - root.lastTimePointsUpdated < WINDOW_MS) {
            return;
        }
        root.lastTimePointsUpdated = now;

        if (root.animationJaikinStep >= SMOOTHING_STEPS) {
            root.animationJaikinStep = 0;
            root.prevPolyline = new ArrayList<>(root.points);
            root.points = new ArrayList<>(root.originalPoints);
            root.nextPolyline = new ArrayList<>(root.points);
            return;
        }

        if (root.points == null || root.points.isEmpty()) {
            root.points = new ArrayList<>(root.originalPoints);
        }

        root.prevPolyline = new ArrayList<>(root.points);
        root.points = chaikin(root.points);
        root.nextPolyline = new ArrayList<>(root.points);
        root.animationJaikinStep++;
    }
}