package study_file1;

import javax.crypto.Mac;

import java.util.Random;

import static javafx.scene.input.KeyCode.M;

public class example1 {
    public static void main(String[] args) {

        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(rand.nextInt(5));
        }

    }
}
