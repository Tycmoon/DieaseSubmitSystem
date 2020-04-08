import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by IntelliJ IDEA.
 * User: YANG
 */

public class Frame extends JFrame{

    public Frame(){

        // 初始化窗口
        initalizeFrame();
        // 初始化menu
        initalizeMenu();
        // 初始化聊天界面
        initalizeChat();

        Timer timer = new Timer();
        TimerTask timeTask=new TimerTask() {

            @Override
            public void run()
            {
                // TODO Auto-generated method stub
                try {
                    Textshow.setText("");
                    String fileName ="message";
                    FileReader fileReader = new FileReader(fileName);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String temp = null;
                    while ((temp = bufferedReader.readLine()) != null) {
                        Textshow.append(temp+"\n");
                    }
                    fileReader.close();
                    bufferedReader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

        };timer.schedule(timeTask, 0,500);
    }

   /**
    * initalize
    */
    private Toolkit kit = Toolkit.getDefaultToolkit();
    private Dimension screensize = kit.getScreenSize();
    private int width = screensize.width;
    private int height = screensize.height;
    // 初始化界面
    public void initalizeFrame(){
        // set width height positon
        setSize(width/2+17,height/2);
        setLocationByPlatform(true);
        // set icon
        Image img = new ImageIcon("img//wode.png").getImage();
        setIconImage(img);
        // set windows UI
        try {
            String lookAndFeel ="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // set fix
        setResizable(false);

        //


    }
    // 初始化菜单
    JMenuItem ChooseFile,CollegeGragh,TimeMGragh,TIMESet,InsertMessage;
    public void initalizeMenu(){
        // Mainmenu
        JMenuBar MainMenu = new JMenuBar();
        // menu1
        JMenu Menu1 = new JMenu("menu");
        ChooseFile = new JMenuItem("传送文件");
        ChooseFile.addActionListener(new ChooseFileAction());
        Menu1.add(ChooseFile);


        // menu2
        JMenu Menu2 = new JMenu("Graph");
        CollegeGragh = new JMenuItem("CollegeGragh");
        TimeMGragh = new JMenuItem("TimeMGragh");

        // add action
        /*
        CollegeGragh.addActionListener(new CollegeAction());
        TimeMGragh.addActionListener(new TimeMGraghAction());

         */
        Menu2.add(CollegeGragh);
        Menu2.add(TimeMGragh);


        // menu3
        JMenu Menu3 = new JMenu("菜单");
        TIMESet = new JMenuItem("1");
        // TIMESet.addActionListener(new TimeSet());
        Menu3.add(TIMESet);

        // menu4
        JMenu Menu4 = new JMenu("菜单");
        InsertMessage = new JMenuItem("2");
        // InsertMessage.addActionListener(new InsertMessage());
        Menu4.add(InsertMessage);

        // MainMenu ADD
        MainMenu.add(Menu1);
        //MainMenu.add(Menu2);
        //MainMenu.add(Menu3);
        //MainMenu.add(Menu4);
        add(MainMenu,BorderLayout.NORTH);
    }
    // 聊天界面相关
    JScrollPane TextShowRoll,TextInitRoll;
    JTextArea Textshow,TextInit,TextIP;
    JPanel Chatpanel;


    /**
     *
     * chat
     */
    public void initalizeChat(){
        Chatpanel= new JPanel();
        Chatpanel.setLayout(null);
        JPanel PanelN = new JPanel();
        JPanel PanelS = new JPanel();
        //PanelN.setBackground(Color.white);
        //PanelS.setBackground(Color.white);

        PanelN.setBounds(0,0,width/2,height/4);
        PanelS.setBounds(0,height/4,width/2,height/4);

        Textshow = new JTextArea(10,91);
        Textshow.setLineWrap(true);

        TextIP = new JTextArea(1,15);


        // Mainmenu
        JMenuBar MainMenu1 = new JMenuBar();
        // menu1
        JMenu Menu1 = new JMenu("(");

        // menu2
        JMenu Menu2 = new JMenu("Φ");

        //
        JMenu Menu3 = new JMenu("ω");
        JMenu Menu4 = new JMenu("Φ");
        JMenu Menu5 = new JMenu(")");



        String[] express = new String[]{"◔‸◔？","(ง•̀_•́)ง","(눈_눈)","_(:з」∠)_","(￣ε￣)","_(?ω?｣∠)_","<(｀^′)>","(ノ=Д=)ノ┻━┻","( T﹏T )"};
        String[] express2 = new String[]{"(-ω- )","(+ω+)","(*ω* )","( ^ω^) ","( ;ω;) ","(『ω′)","(≧ω≦)"," (/ω?＼)","(ΦωΦ)"};
        String[] express3 = new String[]{"(∩•̀ω•́)⊃-*⋆","(◞‸◟ )","( ´･･)ﾉ(._.`)","( ´•︵•` )","(>v<)","ฅ(̳•◡•̳)ฅ","(o´Д`o)ノ"," (๑•ᴗ•๑)♡","( =‵▽′)ノ'卍卍卍卍卍卍 Σ(゜д゜；)"};
        for (int i = 0; i < express.length; i++) {
            JMenuItem item= new JMenuItem(express[i]);
            JMenuItem item2= new JMenuItem(express2[i]);
            JMenuItem item3= new JMenuItem(express3[i]);
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TextInit.append(item.getText());
                }
            });
            Menu1.add(item);
            item2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TextInit.append(item2.getText());
                }
            });
            Menu2.add(item2);
            item3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TextInit.append(item3.getText());
                }
            });
            Menu3.add(item3);
        }




        MainMenu1.add(Menu1);
        MainMenu1.add(Menu2);
        MainMenu1.add(Menu3);
        MainMenu1.add(Menu4);
        MainMenu1.add(Menu5);


        // 创建 工具栏按钮
        JToolBar toolBar = new JToolBar("测试工具栏");
        ImageIcon icon1 = new ImageIcon(  "img//wode.png");
        Image img = icon1.getImage();
        Image newimg = img.getScaledInstance(32,32,java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newimg);

        JButton previousBtn = new JButton(icon);
        JButton pauseBtn = new JButton(icon);
        JButton nextBtn = new JButton(new ImageIcon("img//1.png"));
        toolBar.add(previousBtn);
        toolBar.add(pauseBtn);
        toolBar.add(nextBtn);






        TextInit = new JTextArea(5 ,91);
        TextInit.setLineWrap(true);


        TextShowRoll = new JScrollPane(Textshow);
        TextShowRoll.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        TextInitRoll = new JScrollPane(TextInit);
        TextInitRoll.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        JButton button = new JButton("发送");
        button.addActionListener(new sendAction());
        JLabel iplaber = new JLabel("目的IP:");

        PanelN.add(TextShowRoll);

        PanelS.add(MainMenu1);
        //PanelS.add(toolBar);
        PanelS.add(iplaber);
        PanelS.add(TextIP);
        PanelS.add(TextInitRoll);
        PanelS.add(button);

        Chatpanel.add(PanelN);
        Chatpanel.add(PanelS);
        add(Chatpanel);
    }

   /**
    * ACtion
    */
    private class ChooseFileAction implements ActionListener {
        public void actionPerformed(ActionEvent event){

            EventQueue.invokeLater(()->{
                JFrame f=new JFrame("setting");    //创建窗体对象并赋标题参数
                f.setSize(width/2,height/2);    //设置窗体大小
                f.setBackground(Color.WHITE);    //设置背景颜色
                f.setLocationByPlatform(true);  //设置窗体显示位置
                f.setVisible(true);    //显示窗体

                JPanel FileJpanel = new JPanel();
                JLabel LaberIP = new JLabel("目的IP");
                JTextField textFileIP = new JTextField(TextIP.getText(),15);
                JLabel LaberFile = new JLabel("文件路径");
                JTextField textFileUrl = new JTextField(30);
                JButton choosebutton = new JButton("选择");
                choosebutton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame f=new JFrame("选择文件窗口");
                        f.setVisible(false);
                        // 创建一个默认的文件选取器
                        JFileChooser cho = new JFileChooser();
                        // 设置默认显示的文件夹为当前文件夹
                        cho.setCurrentDirectory(new File("."));
                        // 打开文件选择框（线程将被阻塞, 直到选择框被关闭）
                        int result = cho.showOpenDialog(f);
                        if (result == cho.APPROVE_OPTION) {
                            // 如果点击了"确定", 则获取选择的文件路径
                            File file = cho.getSelectedFile();
                            //System.out.print(file.getAbsolutePath());
                            textFileUrl.setText(file.getAbsolutePath());
                        }
                    }
                });



                JPanel  Jpanel2 = new JPanel();
                JLabel finish = new JLabel();
                JButton SendButton = new JButton("确认");
                SendButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            FileTransferClient client = new FileTransferClient(textFileIP.getText());
                            client.setFilepath(textFileUrl.getText());
                            client.sendFile();
                            textFileIP.setText(null);
                            textFileUrl.setText(null);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                });



                Jpanel2.add(SendButton);

                FileJpanel.add(LaberIP);
                FileJpanel.add(textFileIP);
                FileJpanel.add(LaberFile);
                FileJpanel.add(textFileUrl);
                FileJpanel.add(choosebutton);
                FileJpanel.add(Jpanel2);
                f.add(FileJpanel);
            });


        }
    }

    // 发送消息
    private class sendAction implements ActionListener {
        public void actionPerformed(ActionEvent event){
            if (!TextIP.getText().equals("")){
                FileWriter FileW = null;
                try {
                    MessageTransferClient Client = new MessageTransferClient(TextIP.getText());
                    Client.setMessage(TextInit.getText());
                    Client.sendMessage();
                    // Textshow.append(TextInit.getText()+"\n");
                    FileW = new FileWriter("message",true);
                    FileW.write(TextInit.getText()+"\r\n");
                    TextInit.setText("");
                    FileW.flush();
                    FileW.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }





}

