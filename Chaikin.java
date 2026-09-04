import java.util.*;

public class Chaikin {
    public static List<Point> chaikin(List<Point> points) {
        return null;
    }

    public static void chaikinStep(Root root) {
         long now = System.currentTimeMillis();
        if (now - root.lastTimePointsUpdated < 500) {
            return;
        }
        root.lastTimePointsUpdated = now;

        if (root.animationJaikinStep >= 7) {
            root.animationJaikinStep = 0;
            root.points = new ArrayList<>(root.originalPoints);
            return;
        }

        if (root.points == null || root.points.isEmpty()) {
            root.points = new ArrayList<>(root.originalPoints);
        }

        root.points = chaikin(root.points);
        root.animationJaikinStep++;
    }
}