import java.io.*;
import java.math.RoundingMode;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;

public class MessageTransferServer extends ServerSocket{
    // message
    private static final int SERVER_PORT = 9001; // 服务端端口
    private OutputStream outm;
    private PrintWriter print;
    public MessageTransferServer() throws IOException {
        super(SERVER_PORT);
    }


    // file
    private static DecimalFormat df = null;
    static {
        // 设置数字格式，保留一位有效小数
        df = new DecimalFormat("#0.0");
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setMinimumFractionDigits(1);
        df.setMaximumFractionDigits(1);
    }



    /**
     * 使用线程处理每个客户端传输的文件
     * @throws Exception
     */
    public void load1() throws Exception {
        while (true) {
            // server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
            Socket socket = this.accept();
            /**
             * 我们的服务端处理客户端的连接请求是同步进行的， 每次接收到来自客户端的连接请求后，
             * 都要先跟当前的客户端通信完之后才能再处理下一个连接请求。 这在并发比较多的情况下会严重影响程序的性能，
             * 为此，我们可以把它改为如下这种异步处理与客户端通信的方式
             */
            // 每接收到一个Socket就建立一个新的线程来处理它
            new Thread(new Task_message(socket)).start();
        }
    }

    /**
     * 处理客户端传输过来的信息线程类
     */
    class Task_message implements Runnable {
        private Socket socket;
        //message
        private InputStream InputStream;
        private InputStreamReader InputStreamReader;
        private BufferedReader BufferedReader;
        private String str,temp;

        // file
        private DataInputStream dis;
        private FileOutputStream fos;


        public Task_message(Socket socket) {
            this.socket = socket;
        }



        @Override
        public void run() {

            try {
                InputStream =socket.getInputStream();//得到一个输入流
                InputStreamReader = new InputStreamReader(InputStream);
                BufferedReader = new BufferedReader(InputStreamReader);
                str = "";
                temp = null;
                String list=BufferedReader.readLine();

                System.out.println("list:"+list);
                // message
                if (list.equals("message")){
                    while ((temp=BufferedReader.readLine())!=null){
                        str+=temp;
                        //System.out.println(str +"       ip:"+socket.getInetAddress().getHostAddress());

                    }
                    message message = new message();
                    message.setMessage(socket.getInetAddress().getHostAddress()+":"+str);
                    message.writeMessage();
                }

                // file
                if (list.equals("file")){
                    dis = new DataInputStream(InputStream);
                    String fileName = dis.readUTF();
                    System.out.print(fileName);
                    long fileLength = dis.readLong();
                    // 文件名和长度
                    File directory = new File("FTCache");
                    if(!directory.exists()) {
                        directory.mkdir();
                    }
                    File file = new File(directory.getAbsolutePath() + File.separatorChar + fileName);
                    fos = new FileOutputStream(file);
                    // 开始接收文件

                    byte[] bytes = new byte[1024];
                    int length = 0;

                    while((length = dis.read(bytes, 0, bytes.length)) != -1) {

                        fos.write(bytes, 0, length);

                        fos.flush();
                    }
                    System.out.println("======== 文件接收成功 [File Name：" + fileName + "] [Size：" + getFormatFileSize(fileLength) + "] ========");

                }


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(BufferedReader != null)
                        BufferedReader.close();
                    if(InputStreamReader != null)
                        InputStreamReader.close();;
                    if(InputStream != null)
                        InputStream.close();
                    socket.close();
                } catch (Exception e) {}
            }


        }
    }


    /**
     * 格式化文件大小
     * @param length
     * @return
     */
    private String getFormatFileSize(long length) {

        double size = ((double) length) / (1 << 30);

        if(size >= 1) {
            return df.format(size) + "GB";
        }
        size = ((double) length) / (1 << 20);

        if(size >= 1) {

            return df.format(size) + "MB";

        }
        size = ((double) length) / (1 << 10);
        if(size >= 1) {
            return df.format(size) + "KB";
        }
        return length + "B";
    }

    public static void main(String[] args) {
        try {
            MessageTransferServer server = new MessageTransferServer();
            server.load1();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
