package cn.ac.GUI;


import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import test.*;
//C:\Program Files\Java\jdk1.8.0_151\src.zip!\java\awt\event\ActionListener.java

public class MainForm extends JFrame{
    private JTextField textField1;
    private JPanel panel1;
    private JButton actionButton;
    private JButton brwoseButton;
    private String shape = "Ellipse";

    public static void GUI(){
        MainForm frame = new MainForm();
        frame.launchFrame();
    }

    public static void main(String[] args) {
        MainForm frame = new MainForm();
        frame.launchFrame();
    }

    public void launchFrame(){
        this.setTitle("中文词云");
        this.setVisible(true);
        this.setContentPane(new MainForm().panel1);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(550, 500);
        this.setLocation(680, 320);
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //构造方法
    public MainForm(){
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_actionButton_actionPerformed(e);
            }
        });

        brwoseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                do_browseAction_actionPerformed(e);
            }
        });



        System.out.println("*******Function Normally*******");
    }



    protected void do_actionButton_actionPerformed(ActionEvent arg){
        JTextField txtField = this.textField1;
        String path = txtField.getText();
        System.out.println("读入文本"+path);

        Start.start(path, shape);
        /**
         * 可在此处开始整个程序，拿到txtPath.textField1里的String
         */
    }

    protected void do_browseAction_actionPerformed(ActionEvent arg){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
        String txt;

        chooser.setPreferredSize(new Dimension(630,520));
        chooser.setFileFilter(filter);//打开选择器面板

        int returnVal = chooser.showOpenDialog(new JPanel());
        //保存文件从这里入手，输出的是文件名
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            txt = (chooser.getCurrentDirectory()+ "/"+chooser.getSelectedFile().getName()).
                    replace("\\","/");
            // 将\变成/
            System.out.println("You are going open: "+txt);
            JTextField txtField = this.textField1;
            txtField.setText(txt);
        }
    }
}