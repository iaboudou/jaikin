import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame("jaikin");
        Canvas canvas = new Canvas();
        Root root = new Root();

        canvas.setBackground(Color.BLACK);

        frame.add(canvas);
        frame.setSize(root.width, root.height);
        frame.setVisible(true);

        Input.handleInput(root, canvas);

        while (true) {

            Render.render(root, canvas);
            // Chaikin.chaikinStep(root);

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}