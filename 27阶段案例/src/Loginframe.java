import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Loginframe extends JFrame implements MouseListener {
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();

    JButton login = new JButton();
    JButton register = new JButton();

    public Loginframe() {
        initUI();
        initImage();
        // createForm(); // 移除这行，确保不再创建额外的JPanel
    }

    private void initUI() {
        this.setTitle("登录");
        this.setSize(488, 430);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); // 设置布局为null，这样可以使用绝对定位
    }

    // 初始化图片函数
    private void initImage() {
        // 创建用户名图片提示
        JLabel usernameText = new JLabel(
                new ImageIcon("C:\\Users\\Joon\\Desktop\\JavaStudy\\Game\\image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);
        // 用户输入框
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);
        // 创建添加密码提示框
        JLabel passwordText = new JLabel(
                new ImageIcon("C:\\Users\\Joon\\Desktop\\JavaStudy\\Game\\image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);
        // 用户输入框
        password.setBounds(195, 195, 200, 30); // 这行代码没有问题
        this.getContentPane().add(password);

        //5.添加登录按钮
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("C:\\Users\\Joon\\Desktop\\JavaStudy\\Game\\image\\login\\登录按钮.png"));
        //去除按钮的边框
        login.setBorderPainted(false);
        //去除按钮的背景
        login.setContentAreaFilled(false);
        //给登录按钮绑定鼠标事件
        login.addMouseListener(this);
        this.getContentPane().add(login);

        //6.添加注册按钮
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("C:\\Users\\Joon\\Desktop\\JavaStudy\\Game\\image\\login\\注册按钮.png"));
        //去除按钮的边框
        register.setBorderPainted(false);
        //去除按钮的背景
        register.setContentAreaFilled(false);
        //给注册按钮绑定鼠标事件
        register.addMouseListener(this);
        this.getContentPane().add(register);

        // 创建背景图片
        ImageIcon bg = new ImageIcon("C:\\Users\\Joon\\Desktop\\JavaStudy\\Game\\image\\login\\background.png");
        JLabel bglabel = new JLabel(bg);
        bglabel.setBounds(0, 0, 470, 390);
        this.getContentPane().add(bglabel);

    }

    public static void main(String[] args) {
        new Loginframe();
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == login) {
            // 登录按钮事件
            String usernameStr = username.getText();
            String passwordStr = password.getText();
            if (usernameStr.equals("admin") && passwordStr.equals("admin")) {
                // 登录成功
                JOptionPane.showMessageDialog(null, "登录成功！");
                this.dispose(); // 关闭当前窗口
                new GAMEframe();
            } else {
                JOptionPane.showMessageDialog(null, "用户名或密码错误！");
            }
        } else if (e.getSource() == register) {
            // 注册按钮事件
            JOptionPane.showMessageDialog(null, "注册成功！");
            this.dispose(); // 关闭当前窗口
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
