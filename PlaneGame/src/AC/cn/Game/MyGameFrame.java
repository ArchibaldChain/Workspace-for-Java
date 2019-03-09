package AC.cn.Game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**************
 * Plane Game Frame
 *
 */

public class MyGameFrame extends JFrame{


    /**
     * 初始化窗口
     */

    Image backGround = GameUtil.getImage("Images/starSky.jpg");


    @Override
    public void paint(Graphics g){
        Color c = g.getColor();//Save the original color
        Font f = g.getFont();

        g.drawImage(backGround,0,0,null);
        g.setColor(Color.white);
        g.drawLine(100, 100, 300, 300);
        g.drawRect(100,100,300,300);
        g.drawOval(100, 100, 300, 300);
        g.fillRect(100,100,40,40);
        g.setFont(new Font("宋体",Font.BOLD, 30));
        g.drawString("Who am I?",200,200);

        g.setColor(c);// reset the original color
        g.setFont(f);
    }

    public void launchFrame(){
        this.setTitle("PlaneGame");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(700, 320);
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();

    }


}