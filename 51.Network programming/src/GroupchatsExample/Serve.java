package GroupchatsExample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Serve {
    // 定义一个socketList，用来存放所有客户端的socket
    public static ArrayList<Socket> socketList = new ArrayList<Socket>();

    public static void main(String[] args) throws IOException {


        // 1.创建服务端
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器启动，等待客户端连接...");

        // 创建一个线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3, // 核心线程数
                20, // 最大线程数
                60, // 空闲线程存活时间
                TimeUnit.SECONDS, // 空闲时间单位
                new LinkedBlockingQueue<Runnable>() // 工作队列
        );

        // 2.等待客户端连接
        while (true) {
            // accept 具备阻塞性，只有客户端连接上才会返回
            Socket socket = serverSocket.accept();
            socketList.add(socket);//将客户端socket加入到socketList中
            // 使用线程池来处理客户端连接
            pool.execute(new ServeThread(socket));
        }
    }
}
