package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class Serve {
    public static void main(String[] args) throws Exception {
        // 1. 创建服务端对象注册端口
        DatagramSocket server = new DatagramSocket(10010);
        // 2. 创建字节数组，用于接收客户端发送的数据
        byte[] buffer = new byte[1024];

        // 3. 循环接收客户端发送的数据
        while (true) {
            // 4. 接收客户端发送的数据
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            server.receive(packet);

            // 5. 获取客户端发送的数据，指定编码为 UTF-8
            String message = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8);

            // 6. 打印客户端发送的数据
            System.out.println("客户端：" + message);

            // 7. 发送数据给客户端
            String response = "服务器收到消息：" + message;
            byte[] data = response.getBytes(StandardCharsets.UTF_8); // 指定编码为 UTF-8
            DatagramPacket responsePacket = new DatagramPacket(data, data.length, packet.getAddress(), packet.getPort());
            server.send(responsePacket);
        }
    }
}
