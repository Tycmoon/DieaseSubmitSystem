import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by IntelliJ IDEA.
 * User: YANG
 */
public class SystemMain {
    public static void main(String[] args){

        //
        message m = new message();
        m.writeMessagenull();
        // 窗口
        EventQueue.invokeLater(()->{
            Frame Frame = new Frame();
            Frame.setTitle("SendMessage");
            Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Frame.setVisible(true);
        });

        // 开启监听
        while (true){
            try {
                // 本机ip
                //System.out.print(InetAddress.getLocalHost());

                MessageTransferServer server = new MessageTransferServer();
                server.load1();
                System.out.println("1");
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }
}
