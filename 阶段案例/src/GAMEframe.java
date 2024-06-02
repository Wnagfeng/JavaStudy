import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GAMEframe extends JFrame implements KeyListener, ActionListener {
    int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
    int[][] result = new int[4][4];
    Random random = new Random();
    JButton Loginbutton = new JButton("登录");
    JButton registerbutton = new JButton("注册");
    int x = 0, y = 0; // 第0张图片的坐标

    int[][] wim = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 0 }
    };
    int score = 0;

    String path = "C:\\Users\\Joon\\Desktop\\JavaStudy\\Game\\image\\girl\\girl4\\";
    int rodmPathindex = 1;

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
        // Loginbutton.addActionListener(this);// 为什么只要传递this，就可以调用actionPerformed方法？
        // 因为ActionListener接口中定义了该方法
        // this.getContentPane().add(Loginbutton);

        registerbutton.setBounds(300, 500, 100, 50);
        // registerbutton.addActionListener(this);// 这里是this 是谁？
        // this.getContentPane().add(registerbutton);

        // 为页面添加事件
        this.addKeyListener(this);
    }

    // 创建menu函数
    private void createMenu() {
        // 创建菜单选项
        JMenuBar menuBar = new JMenuBar();
        JMenu Functionmenu = new JMenu("功能");// 功能模块
        JMenu Aboutmenu = new JMenu("关于我们");// 关于我们模块
        JMenu changeimg = new JMenu("更换图片");// 关于我们模块

        JMenuItem menuItem1 = new JMenuItem("重新游戏");
        JMenuItem menuItem2 = new JMenuItem("重新登录");
        JMenuItem menuItem3 = new JMenuItem("关闭游戏");
        JMenuItem menuItem4 = new JMenuItem("公众号");

        JMenuItem menuItem6 = new JMenuItem("美女🚀");
        JMenuItem menuItem7 = new JMenuItem("动物🐕");
        JMenuItem menuItem8 = new JMenuItem("运动😵");

        Functionmenu.add(menuItem1);
        Functionmenu.add(menuItem2);
        Functionmenu.add(menuItem3);
        Functionmenu.add(changeimg);

        Aboutmenu.add(menuItem4);
        changeimg.add(menuItem6);
        changeimg.add(menuItem7);
        changeimg.add(menuItem8);

        menuItem6.addActionListener(this);
        menuItem7.addActionListener(this);
        menuItem8.addActionListener(this);

        menuItem1.addActionListener(this);// 重新游戏事件
        menuItem2.addActionListener(this);// 重新登录事件
        menuItem3.addActionListener(this);//// 关闭游戏事件
        menuItem4.addActionListener(this);// 公众号事件

        menuBar.add(Functionmenu);
        menuBar.add(Aboutmenu);
        // 当前界面对象添加菜单栏
        this.setJMenuBar(menuBar);
    }

    // 初始化图片
    private void initImage() {
        this.getContentPane().removeAll();
        if (victory()) {
            JLabel wimLabel = new JLabel(new ImageIcon("C:\\Users\\Joon\\Desktop\\JavaStudy\\Game\\image\\win.png"));
            wimLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(wimLabel);
        }
        JLabel scoreLabel = new JLabel("计数：" + score);
        scoreLabel.setBounds(10, 10, 100, 20);
        this.getContentPane().add(scoreLabel);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // 获取图片序号
                int number = result[i][j];
                JLabel label = new JLabel(new ImageIcon(
                        path + number + ".jpg"));
                label.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                // 添加边框
                label.setBorder(BorderFactory.createLineBorder(Color.black));
                this.getContentPane().add(label);
            }
        }
        // 创建背景图片
        JLabel background = new JLabel(new ImageIcon(
                "C:\\Users\\Joon\\Desktop\\JavaStudy\\Game\\image\\background.png"));
        background.setBounds(40, 40, 500, 560);
        this.getContentPane().add(background);

        this.getContentPane().repaint();
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
            if (array[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            result[i / 4][i % 4] = array[i];
        }
    }

    public boolean victory() {
        for (int i = 0; i < result.length; i++) {
            for (int i1 = 0; i1 < result.length; i1++) {
                if (result[i][i1] != wim[i][i1]) {
                    return false;
                }

            }
        }
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 判断用户是否按下A不松开
        if (e.getKeyCode() == KeyEvent.VK_A) {
            this.getContentPane().removeAll();
            JLabel background = new JLabel(new ImageIcon(path + "all.jpg"));
            background.setBounds(80, 134, 420, 420);
            this.getContentPane().add(background);

            JLabel background1 = new JLabel(new ImageIcon(
                    "C:\\Users\\Joon\\Desktop\\JavaStudy\\Game\\image\\background.png"));
            background1.setBounds(40, 40, 500, 560);
            this.getContentPane().add(background1);

            this.getContentPane().repaint();

            System.out.println("按下A");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (victory()) {
            return;
        }
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            if (y < 3) {
                result[x][y] = result[x][y + 1];
                result[x][y + 1] = 0;
                y++;
                initImage();
                System.out.println("left");
                score++;
            }
        } else if (keyCode == KeyEvent.VK_UP) {
            if (x < 3) {
                result[x][y] = result[x + 1][y];
                result[x + 1][y] = 0;
                x++;
                initImage();
                score++;
                System.out.println("up");

            }
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            if (y > 0) {
                result[x][y] = result[x][y - 1];
                result[x][y - 1] = 0;
                y--;
                initImage();
                score++;
                System.out.println("right");
            }
        } else if (keyCode == KeyEvent.VK_DOWN) {
            if (x > 0) {
                result[x][y] = result[x - 1][y];
                result[x - 1][y] = 0;
                x--;
                initImage();
                score++;
                System.out.println("down");
            }
        } else if (keyCode == KeyEvent.VK_A) {
            // 判断用户是否按下A松开
            System.out.println("松开A");
            initImage();
        } else if (keyCode == KeyEvent.VK_W) {
            // 实现一键通关

            result = new int[][] {
                    { 1, 2, 3, 4 },
                    { 5, 6, 7, 8 },
                    { 9, 10, 11, 12 },
                    { 13, 14, 15, 0 }
            };

            initImage();

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // JOptionPane 中心显示：在 actionPerformed 方法中，将 JOptionPane.showConfirmDialog
        // 的第一个参数设置为 this，使其在窗口中心显示。
        String command = e.getActionCommand();
        if (command.equals("重新游戏")) {
            int result = JOptionPane.showConfirmDialog(this, "是否确认重新开始游戏？", "重新开始游戏", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                score = 0;
                initdata();
                initImage();

            }
        } else if (command.equals("重新登录")) {
            // 实现重新登录的逻辑
            this.dispose();
            new Loginframe();

            // 关闭当前页面 new登录页面
        } else if (command.equals("关闭游戏")) {
            int result = JOptionPane.showConfirmDialog(this, "是否确认关闭游戏？", "关闭游戏", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (command.equals("公众号")) {
            // 显示公众号相关信息
            JOptionPane.showMessageDialog(this, "公众号功能尚未实现");
        } else if (command.equals("美女🚀")) {
            // 美女有十八组
//            随机生成1-18的数字
            rodmPathindex = random.nextInt(13) + 1;
            System.out.println(rodmPathindex);
            path = "C:\\Users\\Joon\\Desktop\\JavaStudy\\Game\\image\\girl\\girl" + rodmPathindex + "\\";
            initImage();
            System.out.println("更换图片美女");

        } else if (command.equals("动物🐕")) {
            rodmPathindex = random.nextInt(8) + 1;
            path = "C:\\Users\\Joon\\Desktop\\JavaStudy\\Game\\image\\animal\\animal" + rodmPathindex + "\\";
            initImage();
            // 动物有八组
            System.out.println("更换图片动物");

        } else if (command.equals("运动😵")) {
            // 运动有十组
            rodmPathindex = random.nextInt(10) + 1;
            path = "C:\\Users\\Joon\\Desktop\\JavaStudy\\Game\\image\\sport\\sport" + rodmPathindex + "\\";
            initImage();
            System.out.println("更换图片运动");

        }
    }
}
