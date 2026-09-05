# Chaikin Curve Visualizer

A small Java/AWT program that lets you draw a polygon and watch Chaikin's corner-cutting algorithm smooth it into a curve.

## Run it

Compile the source files into the `out` directory, then run `Main`:

```bash
javac -d out *.java
java -cp out Main
```

## Controls

- Left-click on the black canvas to place points.
- Add at least three points.
- Press **Enter** to start the smoothing animation.
- Press **Escape** to close the application.

## How it works

The input points form a closed polygon. On each Chaikin pass, every edge is replaced by two points:

```text
Q = 0.75 × P0 + 0.25 × P1
R = 0.25 × P0 + 0.75 × P1
```

Repeating this process rounds the polygon's corners. The animation performs seven passes, half a second apart, then leaves the final smoothed curve on screen. The original points remain visible in white; the generated curve is blue.
