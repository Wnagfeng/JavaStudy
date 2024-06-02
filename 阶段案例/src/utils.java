import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class utils {
    public static void main(String[] args) {
//        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
//        Random random = new Random();
//        for (int i = 0; i < array.length; i++) {
//            int index = random.nextInt(array.length);
//            int temp = array[i];
//            array[i] = array[index];
//            array[index] = temp;
//        }
//        int[][] result = new int[4][4];
//        for (int i = 0; i < array.length; i++) {
//            result[i / 4][i % 4] = array[i];
//        }
//        for (int i = 0; i < result.length; i++) {
//            for (int j = 0; j < result[i].length; j++) {
//                System.out.print(result[i][j] + " ");
//            }
//            System.out.println();
//        }


//        演示事件监听
//        JButton button = new JButton("Click me!");
//        使用匿名内部类对象
//        为啥需要重写ActionListener接口的actionPerformed方法？

//        因为ActionListener接口中只有一个方法，而我们需要在这个方法中做一些处理，比如按钮点击事件。
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent e) {
//                System.out.println("Button clicked!");
//            }}
//        );
//        JFrame frame = new JFrame();
//        frame.add(button);
//        frame.pack();
//        frame.setVisible(true);
//      定义一个二维数组
        int [][] array={{1},{2},{3},{4}};
        array[1][0]=0;
    }
}
