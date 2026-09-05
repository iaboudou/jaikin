import java.awt.*;

public class Input {
    public static void handleInput(Root root, Canvas canvas) {
        canvas.addMouseListener(new MouseHandler(root));
        canvas.addKeyListener(new ButtonHandler(root));
    }
}

// handle mouse events
class MouseHandler extends java.awt.event.MouseAdapter {
    private Root root;
    public MouseHandler(Root root) {
        this.root = root;
    }

    @Override
    public void mousePressed( java.awt.event.MouseEvent e) {

        if (root.isEnterPressed) {
            return;
        } 
        
        if (e.getButton() == 1) {
            int x = e.getX();
            int y = e.getY();

            Point p = new Point(x, y);

            if (root.points == null) {
                root.points = new java.util.ArrayList<>();
            }
            root.points.add(p);
            root.originalPoints.add(p);
            root.showEmptyMessage = false;
        }
    }
}

// hendler of keys event
class  ButtonHandler extends java.awt.event.KeyAdapter {
    private Root root;
    public ButtonHandler(Root root) {
        this.root = root;
    }

    @Override
    public void keyPressed( java.awt.event.KeyEvent e) {

        switch (e.getKeyCode()) {
            // escape
            case 27 :
                System.exit(0);

            // enter
            case 10 :
                if (root.points.isEmpty()) {
                    root.showEmptyMessage = true;
                    break;
                }
                root.isEnterPressed = true;
                root.lastTimePointsUpdated = System.currentTimeMillis();
                break;
        }
    }
}