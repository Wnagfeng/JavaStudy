package TCP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    // 1.创建客户端Socket
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        // 2.向服务端发送数据
        try {
            //Socket 用的是字节流比较的低级，我们需要把他转换为BufferWriter
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("Hello, Server!");
            writer.newLine();//换行
            writer.flush();//刷新缓冲区
            socket.shutdownOutput(); //关闭输出流，不再向服务端发送数据 让后续代码可以继续执行

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4.关闭Socket
            try {
                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
