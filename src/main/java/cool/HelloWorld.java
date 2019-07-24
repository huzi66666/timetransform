package cool;

/**
 * Created by weijun on 2016/6/14.
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class HelloWorld  extends JTabbedPane
{
    private static final long serialVersionUID = 1L;
    static final int WIDTH=600;
    static final int HEIGHT=400;
    public HelloWorld()
    {
        JFrame f=new JFrame("测试窗口");
        JPanel p=new JPanel();
        f.setContentPane(p);
        f.setVisible(true);
        f.setSize(WIDTH, HEIGHT);
        p.setLayout(new BorderLayout());

        //中间布局begin
        JPanel panel1 = new JPanel ();
        panel1.setLayout(new BorderLayout());
        JLabel JL1 = new JLabel("panel1");
        panel1.add(JL1);
        addTab("panel1", panel1);

       /* JPanel topPanel = new JPanel();
        f.setContentPane(topPanel);
        f.setVisible(true);
        f.setSize(WIDTH, HEIGHT);
        String[] columnName = { "姓名", "性别", "单位", "参加项目", "备注" };
        String[][] rowData = { { "张三", "男", "计算机系", "100 米 ,200 米", "" },
                { "李四", "男", "化学系", "100 米，铅球", "" },
        };
        // 创建表格
        JTable table = new JTable(new DefaultTableModel(rowData, columnName));
        // 创建包含表格的滚动窗格
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // 定义 topPanel 的布局为 BoxLayout，BoxLayout 为垂直排列
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        // 先加入一个不可见的 Strut，从而使 topPanel 对顶部留出一定的空间
        topPanel.add(Box.createVerticalStrut(10));
        // 加入包含表格的滚动窗格
        topPanel.add(scrollPane);
        // 再加入一个不可见的 Strut，从而使 topPanel 和 middlePanel 之间留出一定的空间
        topPanel.add(Box.createVerticalStrut(10));

        addTab("topPanel", topPanel);*/
        //中间布局end

        setEnabledAt(0, true);
        setTitleAt(0,"时间转换");
        setPreferredSize (new Dimension(500, 200));
        setTabPlacement (JTabbedPane.TOP);
        setTabLayoutPolicy (JTabbedPane.SCROLL_TAB_LAYOUT);
        p.add("Center",this);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new HelloWorld();
    }
}