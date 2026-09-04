import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame("jaikin");
        Canvas canvas = new Canvas();
        Root root = new Root();

        canvas.setBackground(Color.BLACK);

        frame.add(canvas);
        frame.setSize(800, 700);
        frame.setVisible(true);

        while (true) {
            Input.handleInput(root, canvas);
            Render.render(root, canvas);
            Chaikin.chaikinStep(root);

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}