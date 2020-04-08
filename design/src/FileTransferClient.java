import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
/**
 * 文件传输Client端<br>
 * 功能说明：
 *
 * Created by IntelliJ IDEA.
 * User: YANG
 * Date: 2020/3/22
 */

public class FileTransferClient extends Socket {
    private static  String SERVER_IP; // 服务端IP
    private static final int SERVER_PORT = 9002; // 服务端端口
    private Socket client;
    private FileInputStream fis;
    private DataOutputStream dos;
    private File file;
    private String Filepath = "D:\\course\\信息安全设计\\design\\img\\bg.png";
    private OutputStream outm;
    private PrintWriter print;
    public void setFilepath(String filepath) {
        Filepath = filepath;
    }

    /**
     * 构造函数<br/>
     * 与服务器建立连接
     * @throws Exception
     */
    public FileTransferClient(String SERVER_IP) throws Exception {
        super(SERVER_IP, SERVER_PORT);
        this.client = this;
        System.out.println("Cliect[port:" + client.getLocalPort() + "] 成功连接服务端");
    }
    /**
     * 向服务端传输文件
     * @throws Exception
     */
    public void sendFile() throws Exception {
        try {
            file = new File(Filepath);
            if(file.exists()) {
                fis = new FileInputStream(file);
                dos = new DataOutputStream(client.getOutputStream());

                outm = client.getOutputStream();
                print = new PrintWriter(outm);
                print.print("file\n");
                print.flush();


                // 文件名和长度
                dos.writeUTF(file.getName());
                dos.flush();
                dos.writeUTF(file.getName());
                dos.flush();
                dos.writeLong(file.length());
                dos.flush();
                // 开始传输文件
                System.out.println("======== 开始传输文件 ========");
/*
                JFrame f=new JFrame("传输中");
                f.setSize(300,200);
                f.setLocationByPlatform(true);
                f.setVisible(true);

                JLabel show = new JLabel("aa");
                f.add(show);

 */
                byte[] bytes = new byte[1024];
                int length = 0;
                long progress = 0;
                while((length = fis.read(bytes, 0, bytes.length)) != -1) {
                    dos.write(bytes, 0, length);
                    dos.flush();
                    progress += length;
                    System.out.print("| " + (100*progress/file.length()) + "% |");
                   // show.setText("| " + (100*progress/file.length()) + "% |");
                }
               // f.setVisible(false);
                System.out.println();
                System.out.println("======== 文件传输成功 ========");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null)
                fis.close();
            if(dos != null)
                dos.close();
            print.close();
            outm.close();
            client.close();
        }
    }
    /**
     * 入口
     * @param args
     *
     *
     */

         public static void main(String[] args) {
              try {
                 FileTransferClient client = new FileTransferClient("192.168.1.2"); // 启动客户端连接
                 client.sendFile(); // 传输文件
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }

}
