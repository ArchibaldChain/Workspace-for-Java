package Unnamed;

import static java.lang.Math.sqrt;

class Point
{
    private int x, y;
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p)
    {
        return sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }

}

public class ConstructedMethod
{

	public static void main(String[] args) {
		Point p = new Point(3, 4);
		Point origin = new Point(0,0);
		System.out.print(p.distance(origin));
	}
}
