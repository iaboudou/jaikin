import java.awt.*;
import java.util.List;
import java.util.ArrayList;


public class Render {
    public static void renderPoints(Root root, Graphics g) {

        g.setColor(Color.WHITE);
        List<Point> op = new ArrayList<>(root.originalPoints);

        for (Point p : op) {
            g.drawOval((int)p.x - 2, (int)p.y - 2, 4, 4);
        }
    }

    public static void renderLines(Root root, Graphics g) {
        
        if (!root.isEnterPressed || root.points.size() < 2) {
            return;
        }
        List<Point> op = new ArrayList<>(root.points);

        op.add(root.originalPoints.get(root.originalPoints.size() - 1));
        op.add(0, root.originalPoints.get(0));

        g.setColor(Color.BLUE);

       for (int i = 0; i < op.size() - 1; i++) {
            Point p1 = op.get(i);
            Point p2 = op.get(i + 1);

            g.drawLine((int)p1.x, (int)p1.y, (int)p2.x, (int)p2.y);
        }

    }
}