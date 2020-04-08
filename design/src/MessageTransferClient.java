import java.io.*;
import java.net.Socket;
/**
 * 信息传输Client端<br>
 * Created by IntelliJ IDEA.
 * User: YANG
 */
public class MessageTransferClient extends Socket{
    // private static String SERVER_IP = "192.168.1.2"; // 服务端IP
    private static String SERVER_IP;
    private static final int SERVER_PORT = 9002; // 服务端端口
    private Socket client;
    private OutputStream outm;
    private PrintWriter print;
    private String message;

    public void setMessage(String message){
        this.message = message;
    }

    /**
     * 构造函数<br/>
     * 与服务器建立连接
     * @throws Exception
     */
    public MessageTransferClient(String SERVER_IP) throws Exception {
        super(SERVER_IP, SERVER_PORT);
        this.client = this;
        System.out.println("Cliect[port:" + client.getLocalPort() + "] 成功连接服务端");
    }
    /**
     * 向服务端发送信息
     * @throws Exception
     */
    public void sendMessage() throws Exception {

        try {
            //String[] sendS = new String[2];
            //sendS[0] = "zxc";
            //sendS[1] = client.getInetAddress().getHostAddress()+":"+message;
            outm = client.getOutputStream();
            print = new PrintWriter(outm);
            print.print("message\n");
            print.flush();
            print.print(message);
            print.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(outm != null)
                outm.close();
            if(print != null)
                print.close();
            client.close();
        }

    }



    /**
     * 入口
     * @param args
     *
     *     public static void main(String[] args) {
     *         try {
     *             MessageTransferClient Client = new MessageTransferClient("192.168.1.2");
     *
     *             Client.sendMessage();
     *         } catch (Exception e) {
     *             e.printStackTrace();
     *         }
     *     }
     */


}

