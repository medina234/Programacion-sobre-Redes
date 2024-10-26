public class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public Point add(Point aPoint) {
        return new Point(this.x + aPoint.getX(), this.y + aPoint.getY());
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
