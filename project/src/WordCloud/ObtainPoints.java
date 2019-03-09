package WordCloud;

public class ObtainPoints {
    private Points[] points;


    public ObtainPoints(String shape) {
        GraphShape graphShape = new GraphShape(shape);
        points = graphShape.getPoints();
    }

    public Points[] getPoints() {
        return points;
    }
}