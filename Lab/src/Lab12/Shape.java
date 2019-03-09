package Lab12;

public class Shape {
    private int dimension;

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return dimension+"";
    }

    public static void main(String[] args) {
        Shape sp = new Shape();
        sp.setDimension(5);
        System.out.println(sp.getDimension());
    }


}
