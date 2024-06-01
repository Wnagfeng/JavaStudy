import com.sun.org.apache.xml.internal.security.Init;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class GAMEframe extends JFrame  implements ActionListener {
    int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
    int[][] result = new int[4][4];
    Random random = new Random();
    JButton Loginbutton = new JButton("登录");
    JButton registerbutton = new JButton("注册");

    public GAMEframe() {
        // 初始化界面
        initUi();
        // 打乱数据
        initdata();
        // 创建菜单
        createMenu();
        // 初始化图片
        initImage();

    }

    // 创建界面函数
    private void initUi() {
        // 创建界面
        this.setTitle("GAME");
        this.setSize(600, 680);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        Loginbutton.setBounds(100, 500, 100, 50);
        Loginbutton.addActionListener(this);//为什么只要传递this，就可以调用actionPerformed方法？ 因为ActionListener接口中定义了该方法
        this.getContentPane().add(Loginbutton);

        registerbutton.setBounds(300, 500, 100, 50);
        registerbutton.addActionListener(this);//这里是this 是谁？
        this.getContentPane().add(registerbutton);





    }

    // 创建menu函数
    private void createMenu() {
        // 创建菜单选项
        JMenuBar menuBar = new JMenuBar();
        JMenu Functionmenu = new JMenu("功能");// 功能模块
        JMenu Aboutmenu = new JMenu("关于我们");// 关于我们模块

        JMenuItem menuItem1 = new JMenuItem("重新游戏");
        JMenuItem menuItem2 = new JMenuItem("重新登录");
        JMenuItem menuItem3 = new JMenuItem("关闭游戏");

        JMenuItem menuItem4 = new JMenuItem("公众号");

        Functionmenu.add(menuItem1);
        Functionmenu.add(menuItem2);
        Functionmenu.add(menuItem3);

        Aboutmenu.add(menuItem4);

        menuBar.add(Functionmenu);
        menuBar.add(Aboutmenu);
        // 当前界面对象添加菜单栏
        this.setJMenuBar(menuBar);
    }

    // 初始化图片
    private void initImage() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // 获取图片序号
                int number = result[i][j];
                JLabel label = new JLabel(new ImageIcon(
                        "C:\\Users\\Joon\\Desktop\\JavaStudy\\Game\\image\\girl\\girl1\\" + number + ".jpg"));
                label.setBounds(105 * j, 105 * i, 105, 105);
                this.getContentPane().add(label);

            }

        }

    }

    // 打乱数据方法
    private void initdata() {

        for (int i = 0; i < array.length; i++) {
            int index = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            result[i / 4][i % 4] = array[i];
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        这里是重写 actionPerformed 方法，当按钮被点击时，会调用该方法
      Object source = e.getSource();
      if (source == Loginbutton) {
          JOptionPane.showMessageDialog(null, "登录成功！");
      } else if (source == registerbutton) {
          JOptionPane.showMessageDialog(null, "注册成功！");
      }

    }
}
