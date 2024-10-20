import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownLoader {
  String SAVE_PATH="";//保存路径
  Number THREAD_NUM=0;//线程数量
  // 下载url的文件路径
  String DOWNLOAD_FILE_PATH="C:\\Users\\Joon\\Desktop\\eshop-mall-master\\eshop-backend-java\\Multi-threaded downloader comprehensive exercises";
  // 配置文件的路径
  String CONFIG_FILE_PATH="C:\\Users\\Joon\\Desktop\\eshop-mall-master\\eshop-backend-java\\Multi-threaded downloader comprehensive exercises";

  // 任务一：通过URLConnection完成单个文件的下载和保存工作
  /**
   * 下载单个文件
   * @param url 下载文件的URL地址
   * @param targetPath 保存文件的路径
   */
  public void DownloadFile(String url, String targetPath) {
    InputStream is = null; //输入流
    OutputStream os = null; //输出流
    try {
      //判断targetPath是否存在，不存在则创建
      File targetFile = new File(targetPath);
      if (!targetFile.exists()) {
        targetFile.mkdirs();
      }
      String fileName = url.substring(url.lastIndexOf("/") + 1); //获取文件名
      File TargetFile = new File(targetPath + "/" + fileName); //创建保存文件对象
      if (!TargetFile.exists()) {
        TargetFile.createNewFile(); //创建文件
      }
      URL urlObj = new URL(url); //创建URL对象
      URLConnection urlConnection = urlObj.openConnection(); //获取URLConnection对象
      is = urlConnection.getInputStream(); //获取输入流
      os = new FileOutputStream(TargetFile); //创建输出流
      byte[] buffer = new byte[1024]; //创建缓冲区
      int len = 0; //读取长度
      while ((len = is.read(buffer)) != -1) {
        os.write(buffer, 0, len); //写入输出流
      }
      System.out.println("文件" + fileName + "下载成功！");
    } catch (Exception e) {
      e.printStackTrace(); //打印异常信息
    } finally {
      try {
        if (is != null) {
          is.close(); //关闭输入流
        }
        if (os != null) {
          os.close(); //关闭输出流
        }
      } catch (IOException e) {
        e.printStackTrace(); //打印异常信息
      }
    }
  }

  // 任务二：通过Properties类实现配置文件的读取
  /**
   *  读取配置文件
   * @param ConfigFilePath 配置文件路径
   * */
  public void start(String ConfigFilePath) {
    //读取config.properties配置文件
    Properties properties = new Properties();
    // 创建配置文件文件对象
    File propFile = new File(ConfigFilePath + "\\\\\\\\config.properties\\");
    try {
      properties.load(Files.newInputStream(propFile.toPath()));
      String threadNum = properties.getProperty("THREAD_NUM");
      String path = properties.getProperty("TARGET_DIR");
      this.SAVE_PATH = path;
      this.THREAD_NUM = Integer.parseInt(threadNum);
      //downLoader.DownloadFile(url, path);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("读取配置文件出错！");
      System.exit(1); //退出程序
    }
  }

  // 任务三：通过downloader.txt读取需要下载的文件url，并且批量执行下载任务
  /**
   *  读取downloader.txt文件
   * @param downloadFilePath downloader.txt文件路径
   * @param targetPath 下载存储的目录
   * */
  public void multiDownloadFromeFile(String targetPath, String downloadFilePath) {
    // 读取downloader.txt文件
    List<String> urls = new ArrayList<>();// 存储下载链接
    BufferedReader reader = null; // 读取文件
    ExecutorService executor = null; // 线程池
    try {
          reader =
        new BufferedReader(
          new FileReader(downloadFilePath + "\\downloader.txt")
        );
        String line = null;
        while ((line = reader.readLine()) != null) {
          urls.add(line);
        }
        //创建线程池
         executor = Executors.newFixedThreadPool((Integer) THREAD_NUM);
        DownLoader That = this;// 解决内部类访问局部变量的问题
        for (String url : urls){
          executor.execute(new Runnable() {
            @Override
            public void run() {
              That.DownloadFile(url, targetPath);
            }
          });
        }

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("读取downloader.txt文件出错！");
      System.exit(1); //退出程序
    } finally {
      if (reader != null) {
        try {
          reader.close();// 关闭文件流
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (executor != null){
        executor.shutdown(); // 关闭线程池
      }
    }
  }

  public static void main(String[] args) {
    DownLoader downLoader = new DownLoader();
    //任务一.读取配置文件
    downLoader.start(downLoader.CONFIG_FILE_PATH);
    //任务二.下载
    downLoader.multiDownloadFromeFile(downLoader.SAVE_PATH, downLoader.DOWNLOAD_FILE_PATH);
  }
}
