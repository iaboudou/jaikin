import java.awt.*;
import java.util.List;
import java.util.ArrayList;


public class Render {
    public static void render(Root root, Canvas canvas) {

        Graphics g = canvas.getGraphics();
        g.setColor(Color.WHITE);

        List<Point> op = new ArrayList<>(root.originalPoints);

        for (Point p : op) {
            g.drawOval((int)p.x, (int)p.y, 4, 4);
        }
    }
}