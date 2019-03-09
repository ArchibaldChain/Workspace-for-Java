package study_file1;

public class Lab2_2
{
    public static void main(String[] args){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 9-i; j++){
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++){
                System.out.print(i-j +" ");
            }
            for (int j = 1; j <= i; j++){
                System.out.printf("%d ",j);
            }
            System.out.println("\n");
        }
        down();

    }

    private static void down(){ //low triangle
        for (int i = 1; i < 10; i++){
            for (int j = 0; j < i; j++){
                System.out.print("  ");
            }
            for (int j = 0; j <= 9-i; j++){
                System.out.print(9-j-i +" ");
            }
            for (int j = 1; j <= 9-i; j++){
                System.out.printf("%d ",j);
            }
            System.out.println("\n");
        }
    }
}

//Math.abs();