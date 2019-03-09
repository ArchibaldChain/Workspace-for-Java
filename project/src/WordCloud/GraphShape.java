package WordCloud;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GraphShape {
    private String path;

    ArrayList<Points> list = new ArrayList<Points>();

    private void setShape(String shape){
        if(shape.equals("Star")){
            path = "Image/Star.jpg";
        } else if (shape.equals("Heart")){
            path = "Image/Heart.jpg";
        } else if (shape.equals("ZhiCheng")){
            path = "Image/ZhiCheng.jpg";
        }
    }

    public Points[] getPoints() {
        return list.toArray(new Points[list.size()]);
    }

    public GraphShape(String shape)/*throws IOException*/ {
        setShape(shape);

        File filepath = new File(path);
        BufferedImage image = null;
        try {
            image = ImageIO.read(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage Img = null;
        Img = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        int x, y;
        int rgb;
        int panduan = 0;
        boolean token = false;
        for (y = 0; y < image.getHeight() - 1; y++) {
            for (x = 0; x < image.getWidth() - 1; x++) {
                if (x == 0 || y == 0 || x == image.getWidth() || y == image.getHeight()) continue;
                rgb = image.getRGB(x, y);
                if (image.getRGB(x, y) != -1 /*&& (image.getRGB(x - 1, y) == -1 ||
                        image.getRGB(x + 1, y) == -1 || image.getRGB(x - 1, y + 1) == -1 ||
                        image.getRGB(x + 1, y + 1) == -1 || image.getRGB(x + 1, y - 1) == -1 ||
                        image.getRGB(x - 1, y - 1) == -1)*/) {

                    Img.setRGB(x, y, rgb);
                    list.add(new Points(x, y));
                    System.out.println("*");
                }
            }
        }

        for (x = 0; x < image.getWidth() - 1; x++) {
            for (y = 0; y < image.getHeight() - 1; y++) {
                if (x == 0 || y == 0 || x == image.getWidth() || y == image.getHeight()) continue;
                rgb = image.getRGB(x, y);
                if (image.getRGB(x, y) != -1 /*&& (image.getRGB(x, y + 1) == -1 ||
                        image.getRGB(x, y - 1) == -1 || image.getRGB(x - 1, y + 1) == -1 ||
                        image.getRGB(x + 1, y + 1) == -1 || image.getRGB(x + 1, y - 1) == -1 ||
                        image.getRGB(x - 1, y - 1) == -1)*/) {
                    Img.setRGB(x, y, rgb);
                    list.add(new Points(x, y));
                }
            }
        }
    }
}