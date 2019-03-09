package cn.ac.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import test.Start;



public class GraphicalUserInterface {

    private String path;
    private String shape = "Ellipse";
	
//	private static final ThreadLocal<String> re = new ThreadLocal<>();
    public  void mainFrame() {
    	
    	PIC pic = new PIC();
    	
    	pic.finalPath("test");
    	//pic.finalb("test");
        JFrame f = new JFrame("选择你的词云轮廓");
        f.setSize(1200, 1080);
        f.setLocation(350, 0);
  
        f.setLayout(null);
  
        
        
        JPanel pLeft = new JPanel();
        pLeft.setBounds(50, 50, 300, 60);
  
        pLeft.setBackground(Color.WHITE);
  
        pLeft.setLayout(new FlowLayout());
  
        JButton b1 = new JButton("心形");
        JButton b2 = new JButton("五角星");
        JButton b3 = new JButton("椭圆");
        JButton b = new JButton("开始绘制词云");
        JButton bOpen = new JButton("浏览");
        pLeft.add(b1);
        pLeft.add(b2);
        pLeft.add(b3);

        JPanel pRight = new JPanel();
        JLabel lPic = new JLabel("");
         
        ImageIcon i = new ImageIcon("Image/Ellipse.jpg");
        lPic.setIcon(i);        
       
        pRight.add(lPic);
        pRight.add(b);
        pRight.setBackground(Color.WHITE);
        pRight.setBounds(10, 150,i.getIconWidth(), i.getIconHeight());
        pRight.add(bOpen);
        // 创建一个水平JSplitPane，左边是p1,右边是p2
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pLeft, pRight);
        // 设置分割条的位置
        sp.setDividerLocation(80);
  
        // 把sp当作ContentPane
        f.setContentPane(sp);
  

  
        f.setVisible(true);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon i = new ImageIcon("Image/Heart.jpg");
                lPic.setIcon(i);     
                System.out.println(i.getDescription());
//                re.set(i.getDescription());     
                pic.setPath(i.getDescription());
                doB1Action(e);
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon i = new ImageIcon("Image/Star.jpg");
                lPic.setIcon(i);     
                System.out.println(i.getDescription());
//                re.set(i.getDescription());     
                pic.setPath(i.getDescription());
                doB2Action(e);
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon i = new ImageIcon("Image/Ellipse.jpg");
                lPic.setIcon(i);     
                System.out.println(i.getDescription());
//                re.set(i.getDescription());     
                pic.setPath(i.getDescription());
                doB3Action(e);
            }
        });

        bOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doBOpenButton(e);
            }
        });

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doActionButtonAction(e);
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void doB1Action(ActionEvent arg){
        shape = "Heart";
    }

    private void doB2Action(ActionEvent arg){
        shape = "Star";
    }

    private void doB3Action(ActionEvent arg){
        shape = "Ellipse";
    }


    private void doBOpenButton(ActionEvent arg){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");

        chooser.setFileFilter(filter);//鎵撳紑閫夋嫨鍣ㄩ潰鏉�
        int returnVal = chooser.showOpenDialog(new JPanel());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            path = (chooser.getCurrentDirectory()+ "/"+chooser.getSelectedFile().getName()).
                    replace("\\","/");
            System.out.println("You are going open: "+path);
        }
    }

    private void doActionButtonAction(ActionEvent arg){
        if (path == null){
            WarningFrame warningFrame = new WarningFrame();
            warningFrame.setBackground(Color.BLACK);
        } else {
            Start.start(path, shape);
            System.out.println("接入词云");
        }
    }
}

class WarningFrame extends JFrame{
    private JLabel label;

    WarningFrame(){

        this.setTitle("Warning!");
        this.setVisible(true);
        this.setSize(400, 200);
        this.setLocation(800, 420);
        label = new JLabel("请选择文本文件" );
        label.setVisible(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("宋体",Font.PLAIN,30));
        this.add(label);
    }
}