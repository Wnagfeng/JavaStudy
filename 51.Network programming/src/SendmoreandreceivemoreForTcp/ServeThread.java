package SendmoreandreceivemoreForTcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

            while (true) {
                message = br.readLine(); // 读取消息

                if (message == null) { // 判断是否为null，如果socket关闭
                    break;
                }

                System.out.println("客户端：" + message);
            }
        } catch (IOException e) {
            System.out.println("发生异常: " + e.getMessage());
        } finally {
            System.out.println("客户端断开连接：" + socket.getInetAddress());
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                System.out.println("关闭套接字失败: " + e.getMessage());
            }
        }
    }
}
