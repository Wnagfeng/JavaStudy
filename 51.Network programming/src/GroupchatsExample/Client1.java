package GroupchatsExample;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    // 1. 创建客户端Socket
    public static void main(String[] args) throws IOException {
        // 创建Socket连接到指定的主机和端口
        Socket socket = new Socket("localhost", 8888);

        // 使用Scanner从键盘接收输入
        Scanner scanner = new Scanner(System.in);

        // 创建 BufferedWriter，用于向服务端发送数据
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        // 创建 BufferedReader，用于读取服务端的回复
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String message;  // 用于存储用户输入的信息

        // 启动一个线程负责读取服务端的消息
        new Thread(() -> {
            try {
                String serverMessage;
                while ((serverMessage = reader.readLine()) != null) {
                    System.out.println("服务器回复: " + serverMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("请输入要发送给服务器的消息，输入 'exit' 以退出：");

        try {
            // 循环读取用户输入
            while (true) {
                message = scanner.nextLine(); // 从键盘读取输入

                if ("exit".equalsIgnoreCase(message)) {
                    break; // 如果输入为 "exit"，则退出循环
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
                writer.close(); // 关闭 BufferedWriter
                socket.close(); // 关闭 Socket
                reader.close(); // 关闭 BufferedReader
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("客户端已退出.");
    }
}
