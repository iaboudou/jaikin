import java.util.List;
import java.util.ArrayList;

public class Root {
    public  List<Point> originalPoints;
    public  List<Point> points;
    public List<Point> prevPolyline;
    public List<Point> nextPolyline;
    public  boolean isEnterPressed;
    public boolean showEmptyMessage;
    public  Long lastTimePointsUpdated;
    public  int animationJaikinStep;
    public int width;
    public int height;

    public Root() {
        originalPoints = new ArrayList<>();
        points = new ArrayList<>();
        prevPolyline = new ArrayList<>();
        nextPolyline = new ArrayList<>();
        isEnterPressed = false;
        showEmptyMessage = false;
        lastTimePointsUpdated = System.currentTimeMillis();
        animationJaikinStep = 0;
        width = 800;
        height = 800;
    }
}