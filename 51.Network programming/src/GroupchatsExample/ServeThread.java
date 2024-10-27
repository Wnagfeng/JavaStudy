package GroupchatsExample;

import java.io.*;
import java.net.Socket;

public class ServeThread implements Runnable {
    private Socket socket;

    public ServeThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("客户端连接：" + socket.getInetAddress());

        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String message;

            // 读取消息
            while ((message = br.readLine()) != null) {
                // 遍历socketList，将消息发送给所有客户端
                for (Socket client : Serve.socketList) {
                    // 跳过自己
                    if (client == socket) {
                        continue;
                    }
                    // 发送消息
                    try {
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                        bw.write(message);
                        bw.newLine(); // 换行
                        bw.flush();  // 刷新缓冲区
                    } catch (IOException e) {
                        System.out.println("发送消息失败给客户端：" + client.getInetAddress());
                        // 可以在这里选择关闭 client
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("与客户端连接失效：" + socket.getInetAddress());
        } finally {
            try {
                // 关闭socket
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                System.out.println("关闭 Socket 失败：" + e.getMessage());
            }
        }
    }
}
