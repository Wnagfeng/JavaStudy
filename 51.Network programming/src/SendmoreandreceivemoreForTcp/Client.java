package SendmoreandreceivemoreForTcp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    // 1. 创建客户端Socket
    public static void main(String[] args) throws IOException {
        // 创建Socket连接到指定的主机和端口
        Socket socket = new Socket("localhost", 8888);

        // 使用Scanner从键盘接收输入
        Scanner scanner = new Scanner(System.in);

        // 创建BufferedWriter，用于向服务端发送数据
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String message;  // 用于存储用户输入的信息

        System.out.println("请输入要发送给服务器的消息，输入 'exit' 以退出：");

        try {
            // 循环读取用户输入
            while (true) {
                message = scanner.nextLine(); // 从键盘读取输入

                if ("exit".equalsIgnoreCase(message)) {
                    socket.close(); // 关闭Socket
                    // 如果输入为 "exit"，则退出循环
                    break;
                }

                writer.write(message);
                writer.newLine(); // 换行
                writer.flush(); // 刷新缓冲区
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭输出流，表示不再发送数据
            try {

                writer.close(); // 关闭BufferedWriter
                socket.close(); // 关闭Socket
                scanner.close(); // 关闭Scanner
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("客户端已退出.");
    }
}
