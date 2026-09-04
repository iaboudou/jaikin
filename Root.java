import java.util.List;
import java.util.ArrayList;

public class Root {
    public  List<Point> originalPoints;
    public  List<Point> points;
    public  boolean isEnterPressed;
    public  Long lastTimePointsUpdated;
    public  int animationJaikinStep;

    public Root() {
        originalPoints = new ArrayList<>();
        points = new ArrayList<>();
        isEnterPressed = false;
        lastTimePointsUpdated = System.currentTimeMillis();
        animationJaikinStep = 0;
    }
}