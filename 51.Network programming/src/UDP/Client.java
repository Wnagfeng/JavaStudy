package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        // 1. 创建客户端对象【随机客户端端口号】
        DatagramSocket client = new DatagramSocket();

        // 2. 创建 Scanner 对象以接收用户输入
        Scanner scanner = new Scanner(System.in);

        String message;
        System.out.println("请输入消息（输入 'exit' 结束）：");

        while (true) {
            message = scanner.nextLine();  // 接收用户输入的消息

            // 如果用户输入 "exit"，则退出循环
            if ("exit".equalsIgnoreCase(message)) {
                break;
            }

            // 3. 封装包，使用 UTF-8 编码
            DatagramPacket packet = new DatagramPacket(
                    message.getBytes(StandardCharsets.UTF_8), // 指定编码
                    message.length(),
                    InetAddress.getLocalHost(),
                    10010
            );

            // 4. 发送数据
            client.send(packet);
            System.out.println("已发送: " + message);
        }

        // 5. 关闭客户端和 Scanner
        client.close();
        scanner.close();
        System.out.println("客户端已关闭。");
    }
}
