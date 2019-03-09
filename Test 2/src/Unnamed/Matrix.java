package Unnamed;

public class Matrix {

    private double[][] Value;

    /**
     * The constructor
     * @param value
     */
    public Matrix(double[][] value) {
        if (value == null) {
            try{
                throw new Exception();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        this.Value = Supplement(value);
    }

    /**
     * This method is aimed to add the matrix to the current matrix object.
     * return an additional matrix.
     * @param value2
     * @return
     */
    public Matrix add(Matrix value2) {
        if (Value.length != value2.Value.length || Value[0].length != value2.Value[0].length){
            try{
                throw new Exception();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        double[][] addition = new double[Value.length][Value[0].length];
        for (int i = 0; i < Value.length; i++)
        {
            for (int j = 0; j < Value[0].length; j++){
                addition[i][j] = Value[i][j] + value2.Value[i][j];
            }
        }
        return new Matrix(addition);
    }

    /**
     * This method is aimed to calculation the multiplication of the matrices.
     * The matrix who use the method as an object is the first matrix, the order cannot be reversed.
     * @param value2
     * @return
     */
    public Matrix Multiple(Matrix value2) {
        if ( value2.Value.length != Value[0].length )  // to make sure the 2 matrix can be multiple.
        {
            try{
                throw new Exception();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        double[][] multiplication = new double[Value.length][value2.Value[0].length];
        for (int i = 0; i < Value.length; i++)                // Stand for the ith Row
        {
            for (int j = 0; j < value2.Value[0].length; j++)       //   Stand for the jth Column
            {
                for (int k = 0; k < Value[0].length; k++) {
                    multiplication[i][j] += Value[i][k] + value2.Value[k][j];
                }
            }
        }
        return new Matrix(multiplication);
    }

   
    public void Output(){
        for (int i = 0; i < Value.length; i++) {
            for (int j = 0; j < Value[0].length; j++) {
                System.out.print(Value[i][j]);
                System.out.print("\t");
                System.out.print("\t");
            }
            System.out.println();
        }
    }
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * The method is aimed to complete the matrix, to fill some 0 at the end of the shorter row.
     * to make sure that every matrix object can be a matrix, make sure it can be used in other method.
     * @param value
     * @return
     */
    private double[][] Supplement(double[][] value){
        int longest = 0;
        for (int i = 0; i < value.length; i++) {
            if(value[i].length > longest)
                longest = value[i].length;
        }

        double ComplicatedValue[][] = new double[value.length][longest];

        for (int i = 0; i < value.length; i++)
        {
            for (int j = 0; j < longest; j++)
            {
                if (j < value[i].length)
                    ComplicatedValue[i][j] = value[i][j];
                else
                    ComplicatedValue[i][j] = 0;
            }
        }
        return ComplicatedValue;
    }
}

class Main{
    public static void main(String[] args) {
        double[][] a = {
                {1,3,5,},
                {3,53,2,54},
                {3,4,2,5,2,5,2,3},
        };
        double[][] b = {
                {2.34,45.34,2,5},
                {3,5,2,34,2},
                {3,5,2,3,4,2,.45,3.43},
        };


        Matrix a1 = new Matrix(a);
        Matrix b1 = new Matrix(b);

        Matrix c1 = a1.add(b1);
        System.out.println("a1 = " + a1);
        System.out.println("b1 = " + b1);
        System.out.println(a1.add(b1).toString());
        System.out.println("c1 = " + c1);
        c1.Output();

    }
}