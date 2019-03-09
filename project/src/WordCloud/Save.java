package WordCloud;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Save {
    public static int saveJpg(TextBoard tb) {
        JFrame f = new JFrame();
        f.setSize(400, 300);
        f.setLocation(580, 240);
        f.setLayout(null);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(false);

        int option = JOptionPane.showConfirmDialog(f, "您想要保存吗？");
        if (JOptionPane.OK_OPTION == option)
        {
            long t = System.currentTimeMillis();
            Date date = new Date(t);
            DateFormat df = new SimpleDateFormat("MMddhhmmss");
            String fileName = df.format(date);

            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = chooser.showOpenDialog(new JPanel());
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                String  Path =chooser.getSelectedFile().getPath() ;
                System.out.println ( "你选择的目录是：" + Path );
                File w2 = new File(Path+"/word_cloud_"+fileName+".jpg");

                BufferedImage myImage = null;
                try {

                    Image image = tb.createImage(tb.getWidth(),tb.getHeight());
                    myImage = new Robot().createScreenCapture(new java.awt.Rectangle (tb.getX(),tb.getY(),tb.getWidth(),tb.getHeight()));
                    //myImage = (BufferedImage)image;
                    tb.paint(myImage.getGraphics());
                    ImageIO.write(myImage, "jpg",w2);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (AWTException e){
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(f, "保存成功");
            }
            return 0;
        } else if (JOptionPane.CANCEL_OPTION == option){
            return 1;
        } else
            return 0;
    }
}