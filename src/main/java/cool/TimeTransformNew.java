package cool;

/**
 * Created by weijun on 2016/6/14.
 */

import util.TimeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//实现接口ActionListener
public class TimeTransformNew implements ActionListener {

    JFrame jf;
    JPanel jpanel,jpaneltop,jpanelmiddle;
    JButton jb1, jb2, jb3;
    JTextArea jta,jtaoutput;
    JScrollPane jscrollPane,jscrollPaneoutput;
    JTextField jTextFiled;
    JLabel label;

    public TimeTransformNew() {

        jf = new JFrame("Cool时间转换工具V2");
        Container contentPane = jf.getContentPane();
        contentPane.setLayout(new BorderLayout(5,10));


        //textfield
        jpaneltop = new JPanel();
        label=new JLabel("请输入时区");
        jTextFiled = new JTextField("0",10);//默认是0时区
        jpaneltop.add(label);
        jpaneltop.add(jTextFiled);



        //左边输入
        Long now=System.currentTimeMillis();
        String strTime=TimeUtil.getTargetStringTime(now, 0);

        jta = new JTextArea(strTime+"\n",10, 15);
        jta.setTabSize(4);
        jta.setFont(new Font("标楷体", Font.BOLD, 14));
        jta.setLineWrap(true);// 激活自动换行功能
        jta.setWrapStyleWord(true);// 激活断行不断字功能
        //jta.setBackground(Color.pink);
        jscrollPane = new JScrollPane(jta);

        //右边输出
        jtaoutput = new JTextArea(10, 5);
        jtaoutput.setTabSize(4);
        jtaoutput.setFont(new Font("标楷体", Font.BOLD, 14));
        jtaoutput.setLineWrap(true);// 激活自动换行功能
        jtaoutput.setWrapStyleWord(true);// 激活断行不断字功能
        //jta.setBackground(Color.pink);
        jscrollPaneoutput = new JScrollPane(jtaoutput);

        jpanelmiddle = new JPanel();
        jpanelmiddle.setLayout(new GridLayout(1, 2, 5, 6));
        jpanelmiddle.add(jscrollPane);
        jpanelmiddle.add(jscrollPaneoutput);

        //底部按钮
        jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(1, 3,5,6));
        jb1 = new JButton("时间转换");
        jb1.addActionListener(this);
        //jb2 = new JButton("生成时间缀S=>L");
        //jb2.addActionListener(this);
        jb2 = new JButton("当前时间");
        jb2.addActionListener(this);

        jb3 = new JButton("清空");
        jb3.addActionListener(this);

        jpanel.add(jb1);
        jpanel.add(jb2);
        jpanel.add(jb3);

        contentPane.add(jpaneltop, BorderLayout.NORTH);
        contentPane.add(jpanel, BorderLayout.SOUTH);
        contentPane.add(jpanelmiddle, BorderLayout.CENTER);
        //contentPane.add(jscrollPaneoutput, BorderLayout.WEST);

        jf.setSize(600, 400);
        jf.setLocation(400, 200);
        jf.setVisible(true);

        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // 覆盖接口ActionListener的方法actionPerformed
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            String[] lineString = jta.getText().trim().split("\n");
            String timeZone=jTextFiled.getText().trim();//时区 支持城市时区或-x 到  x 时区
            if("".equals(timeZone) || null==timeZone)timeZone="0";//默认是0时区
            //int zone=Integer.parseInt(s);
            jtaoutput.setText("");//清空原因内容
            for(String line:lineString){
                if(null == line || "".equals(line)){jtaoutput.append("\n") ;continue;}
                try{
                    //System.out.println(line);
                    String strTime=TimeUtil.getTargetStringTime(Long.parseLong(line),timeZone);
                    jtaoutput.append(line+"="+timeZone+"="+strTime+"\n");
                }catch(Exception exception){
                    Long lTime=TimeUtil.getTargetLongTime(line,timeZone);
                    jtaoutput.append(line+"="+timeZone+"="+lTime+"\n");
                }
            }

            //transformLongToString();
            System.out.println("格式化时间成功");

        } else if (e.getSource() == jb2) {
            //transformStringToLong();
            //System.out.println("生成时间缀成功");
            initNowTime();
            System.out.println("初始化当前时间成功");
        } else if (e.getSource() == jb3) {
            cleanText();
            System.out.println("清空内容成功");
        }
    }


    /*public void transformLongToString(){
        String[] lineString = jta.getText().split("\n");
        String s=jTextFiled.getText();
        if("".equals(s) || null==s)s="0";//默认是0时区
        int zone=Integer.parseInt(s);
        jtaoutput.setText("");//清空原因内容
        for(String line:lineString){
            //System.out.println(line);
            String strTime=TimeUtil.getTargetStringTime(Long.parseLong(line),zone);
            jtaoutput.append(line+"=="+zone+"=="+strTime+"\n");
        }
    }

    public void transformStringToLong(){
        String[] lineString = jta.getText().split("\n");
        String s=jTextFiled.getText();
        if("".equals(s) || null==s)s="0";//默认是0时区
        int zone=Integer.parseInt(s);
        jtaoutput.setText("");//清空原因内容
        for(String line:lineString){
            //System.out.println(line);
            Long lTime=TimeUtil.getTargetLongTime(line, zone);
            jtaoutput.append(line+"=="+zone+"=="+lTime+"\n");
        }
    }*/

    public void initNowTime(){
        //设置默认值 String strTime=TimeUtil.getTargetStringTime(Long.parseLong(line),zone);
        //jta.append(line+"=="+zone+"=="+strTime+"\n");
        Long now=System.currentTimeMillis();
        String strTime=TimeUtil.getTargetStringTime(now, 0);
        jta.append(strTime+"\n");
    }

    public void cleanText(){
        jta.setText("");
        jtaoutput.setText("");
    }

    public static void main(String[] args) {
        new TimeTransformNew();
    }
}