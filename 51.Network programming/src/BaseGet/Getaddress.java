package BaseGet;

import java.net.UnknownHostException;

public class Getaddress {
    public static void main(String[] args) throws UnknownHostException {

        // getLocalHost() 用于获取本地主机名
        String hostname = java.net.InetAddress.getLocalHost().getHostName();
        System.out.println("Your hostname is: " + hostname);
        // getHostAddress() 用于获取本地IP地址
        String ipAddress = java.net.InetAddress.getLocalHost().getHostAddress();
        System.out.println("Your IP address is: " + ipAddress);
        // getByName() 用于根据主机名获取IP地址
        String ipAddress2 = java.net.InetAddress.getByName("www.baidu.com").getHostAddress();
        System.out.println("The IP address of www.baidu.com is: " + ipAddress2);
    }
}
