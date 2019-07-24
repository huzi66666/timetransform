package cool;

/**
 * Created by weijun on 2016/6/14.
 */
import javax.swing.*;
import java.awt.*;

public class JLableHelloWord {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // 创建窗体框架JFrame
        JFrame freame=new JFrame("HelloWord 窗体示例程序！");
        //设置窗体框架关闭时操作
        // freame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建并添加标签组件
        JLabel label=new JLabel("HelloWord Label");
        freame.getContentPane().add(label, BorderLayout.CENTER);
        //自动选择合适大小
        freame.pack();
        freame.setVisible(true);
    }
}