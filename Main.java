import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

public class Main {
    public static void main(String[] args) {

        Frame frame = new Frame("jaikin");
        Canvas canvas = new Canvas();
        Root root = new Root();

        canvas.setBackground(Color.BLACK);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.add(canvas);
        frame.setSize(root.width, root.height);
        frame.setVisible(true);
        canvas.requestFocusInWindow();

        canvas.createBufferStrategy(2);
        BufferStrategy bs = canvas.getBufferStrategy();

        Input.handleInput(root, canvas);

        while (true) {

            Graphics g = bs.getDrawGraphics();

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

            Render.renderPoints(root, g);
            Chaikin.chaikinStep(root);
            Render.renderLines(root, g);


            g.dispose();
            bs.show();

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}