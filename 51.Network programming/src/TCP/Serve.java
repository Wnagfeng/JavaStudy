package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Serve {
    public static void main(String[] args) throws IOException {
        // 1.创建服务端
        ServerSocket serverSocket = new ServerSocket(8888);
        // 2.等待客户端连接
        System.out.println("服务器启动，等待客户端连接...");
        //accept具备阻塞性，只有客户端连接上才会返回
        Socket socket = serverSocket.accept();
        // 3.把原始的字节输入流转成高效的字节输出流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 4.读取客户端发送的消息
        String message = br.readLine();
        System.out.println("客户端：" + message);
        // 5.回复消息给客户端
        String response = "服务器回复：" + message;
        socket.getOutputStream().write(response.getBytes());
        // 6.关闭资源
        br.close();
        socket.close();
        serverSocket.close();


    }
}
