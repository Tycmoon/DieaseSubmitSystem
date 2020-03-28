import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: YANG
 */
class Frame extends JFrame {
    private Toolkit kit = Toolkit.getDefaultToolkit();
    private Dimension screensize = kit.getScreenSize();
    private int width = screensize.width;
    private int height = screensize.height;

    private ArrayList<Person> P ;
    public void setP(ArrayList<Person> P) {
        this.P = P;
    }

    // 界面绘制
    public Frame(){
        // set width height
        setSize(width*2/3,height*2/3);
        setLocationByPlatform(true);
        // set icon
        Image img = new ImageIcon("img//Disease.png").getImage();
        setIconImage(img);
        // 菜单栏
        AddMenu();
        // 搜索框
        SearchEngine();
        // 时间提醒
    }

    /*
     *
     * 菜单界面
     *
     */
    JMenuItem SearchEngine,CollegeGragh,TimeMGragh,IDGragh,TimeDGragh,situationGragh,PlaceGraph,TIMESet,InsertMessage;

    public void AddMenu(){
        // Mainmenu
        JMenuBar MainMenu = new JMenuBar();
        // menu1
        JMenu Menu1 = new JMenu("搜索菜单");
        SearchEngine = new JMenuItem("SearchEngine");
        SearchEngine.addActionListener(new SearchEngineShow());
        Menu1.add(SearchEngine);


        // menu2
        JMenu Menu2 = new JMenu("Graph");
        CollegeGragh = new JMenuItem("CollegeGragh");
        TimeMGragh = new JMenuItem("TimeMGragh");
        IDGragh = new JMenuItem("IDGragh");
        situationGragh = new JMenuItem("situationGragh");
        TimeDGragh = new JMenuItem("TimeDGragh");
        PlaceGraph = new JMenuItem("PlaceGraph");
        // add action
        CollegeGragh.addActionListener(new CollegeAction());
        TimeMGragh.addActionListener(new TimeMGraghAction());
        IDGragh.addActionListener(new IDGraghAction());
        situationGragh.addActionListener(new situationGraghAction());
        TimeDGragh.addActionListener(new TimeDGraghAction());
        PlaceGraph.addActionListener(new PlaceGraghAction());

        Menu2.add(CollegeGragh);
        Menu2.add(TimeMGragh);
        Menu2.add(IDGragh);
        Menu2.add(situationGragh);
        Menu2.add(TimeDGragh);
        Menu2.add(PlaceGraph);

        // menu3
        JMenu Menu3 = new JMenu("提醒");
        TIMESet = new JMenuItem("设置");
        TIMESet.addActionListener(new TimeSet());
        Menu3.add(TIMESet);

        // menu4
        JMenu Menu4 = new JMenu("填报");
        InsertMessage = new JMenuItem("信息填报");
        InsertMessage.addActionListener(new InsertMessage());
        Menu4.add(InsertMessage);

        // MainMenu ADD
        MainMenu.add(Menu1);
        MainMenu.add(Menu2);
        MainMenu.add(Menu3);
        MainMenu.add(Menu4);
        add(MainMenu,BorderLayout.NORTH);
    }


    /*
    *
    * 搜索界面
    *
    */
    JPanel SearchEngineJpanel;
    TextField textfield;
    JTextArea textArea;
    public void SearchEngine(){

        SearchEngineJpanel = new JPanel();
        SearchEngineJpanel.setLayout(null);
        JPanel Npanel = new JPanel();
        Npanel.setBounds(1,20,width*2/3,height/14);
        JPanel Spanel = new JPanel();
        Spanel.setBounds(width/12,100,width/2,height/2);
        // 搜索框
        textfield = new TextField("输入一点什么吧",20);
        Npanel.add(textfield);

        // 搜索按钮
        JButton button = new JButton("搜索一下");
        button.addActionListener(new SearchAction());
        Npanel.add(button);
        // 显示框
        textArea = new JTextArea(18,70);
        JScrollPane scrollPane = new JScrollPane(textArea);
        Spanel.add(scrollPane);

        SearchEngineJpanel.add(Npanel,BorderLayout.NORTH);
        SearchEngineJpanel.add(Spanel,BorderLayout.SOUTH);
        add(SearchEngineJpanel);
        SearchEngineJpanel.setVisible(false);
    }
    /*
     *
     * 插入信息相关
     *
     */
    JPanel InsertJpanel;
    JComboBox<String> College,month,Day,ID,Place,Suitation;
    TextField name;



    /*
     *
     * 查询 action
     *
     */
    private class SearchAction implements ActionListener {
        public void actionPerformed(ActionEvent event){
            textArea.setText("");
            String Word = textfield.getText();
            for (int i = 0; i < P.size(); i++) {
                String str = P.get(i).toString();
                if (str.contains(Word))
                    textArea.append(P.get(i).toString());
            }
        }

    }
    /*
     *
     * 菜单界面action
     *
     */
    private class SearchEngineShow implements ActionListener {
        public void actionPerformed(ActionEvent event){
            // 显示当前jpanel
            SearchEngineJpanel.setVisible(true);

        }
    }
    private class CollegeAction implements ActionListener {
        public void actionPerformed(ActionEvent event){
            // 隐藏当前jpanel
            // SearchEngineJpanel.setVisible(false);
            // 显示graph
            try {
                //ImageIcon college = new ImageIcon("chart:\\college.jpg");
                //JLabel label = new JLabel(college);
                JFrame f=new JFrame("窗口标题");    //创建窗体对象并赋标题参数
                f.setSize(1200,900);    //设置窗体大小
                f.setBackground(Color.WHITE);    //设置背景颜色
                f.setLocation(10,10);    //设置窗体显示位置
                f.setVisible(true);    //显示窗体

                JPanel p1 = new JPanel();
                p1.add(new JLabel(new ImageIcon("chart\\college1.png")));
                p1.setBounds(0,0,1000,800);
                f.add(p1);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    private class TimeMGraghAction implements ActionListener {
        public void actionPerformed(ActionEvent event){
            try {
                //ImageIcon college = new ImageIcon("chart:\\college.jpg");
                //JLabel label = new JLabel(college);
                JFrame f=new JFrame("窗口标题");    //创建窗体对象并赋标题参数
                f.setSize(1200,900);    //设置窗体大小
                f.setBackground(Color.WHITE);    //设置背景颜色
                f.setLocation(10,10);    //设置窗体显示位置
                f.setVisible(true);    //显示窗体

                JPanel p1 = new JPanel();
                p1.add(new JLabel(new ImageIcon("chart\\TimeM1.png")));
                p1.setBounds(0,0,1000,800);
                f.add(p1);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    private class IDGraghAction implements ActionListener {
        public void actionPerformed(ActionEvent event){

            try {
                //ImageIcon college = new ImageIcon("chart:\\college.jpg");
                //JLabel label = new JLabel(college);
                JFrame f=new JFrame("窗口标题");    //创建窗体对象并赋标题参数
                f.setSize(1200,900);    //设置窗体大小
                f.setBackground(Color.WHITE);    //设置背景颜色
                f.setLocation(10,10);    //设置窗体显示位置
                f.setVisible(true);    //显示窗体

                JPanel p1 = new JPanel();
                p1.add(new JLabel(new ImageIcon("chart\\ID1.png")));
                p1.setBounds(0,0,1000,800);
                f.add(p1);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    private class situationGraghAction implements ActionListener {
        public void actionPerformed(ActionEvent event){
            try {
                //ImageIcon college = new ImageIcon("chart:\\college.jpg");
                //JLabel label = new JLabel(college);
                JFrame f=new JFrame("窗口标题");    //创建窗体对象并赋标题参数
                f.setSize(1200,900);    //设置窗体大小
                f.setBackground(Color.WHITE);    //设置背景颜色
                f.setLocation(10,10);    //设置窗体显示位置
                f.setVisible(true);    //显示窗体

                JPanel p1 = new JPanel();
                p1.add(new JLabel(new ImageIcon("chart\\situation1.png")));
                p1.setBounds(0,0,1000,800);
                f.add(p1);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    private class TimeDGraghAction implements ActionListener {
        public void actionPerformed(ActionEvent event){
            try {
                //ImageIcon college = new ImageIcon("chart:\\college.jpg");
                //JLabel label = new JLabel(college);
                JFrame f=new JFrame("窗口标题");    //创建窗体对象并赋标题参数
                f.setSize(1200,900);    //设置窗体大小
                f.setBackground(Color.WHITE);    //设置背景颜色
                f.setLocation(10,10);    //设置窗体显示位置
                f.setVisible(true);    //显示窗体

                JPanel p1 = new JPanel();
                p1.add(new JLabel(new ImageIcon("chart\\TimeD1.png")));
                p1.setBounds(0,0,1000,800);
                f.add(p1);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    private class PlaceGraghAction implements ActionListener {
        public void actionPerformed(ActionEvent event){
            try {
                //ImageIcon college = new ImageIcon("chart:\\college.jpg");
                //JLabel label = new JLabel(college);
                JFrame f=new JFrame("窗口标题");    //创建窗体对象并赋标题参数
                f.setSize(1200,900);    //设置窗体大小
                f.setBackground(Color.WHITE);    //设置背景颜色
                f.setLocation(10,10);    //设置窗体显示位置
                f.setVisible(true);    //显示窗体

                JPanel p1 = new JPanel();
                p1.add(new JLabel(new ImageIcon("chart\\place1.png")));
                p1.setBounds(0,0,1000,800);
                f.add(p1);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    JComboBox<String> time1,time2;
    private class TimeSet implements ActionListener {
        public void actionPerformed(ActionEvent event){
            JFrame f=new JFrame("设置时间");    //创建窗体对象并赋标题参数
            f.setSize(500,300);    //设置窗体大小
            f.setBackground(Color.WHITE);    //设置背景颜色
            f.setLocationByPlatform(true);
            f.setVisible(true);    //显示窗体
            String[] hour = new String[24];
            String[] minute = new String[60];
            for (int i = 0; i < 24; i++) {
                String str = ""+i;
                hour[i] = str;
            }
            for (int i = 0; i < 60; i++) {
                String str = ""+i;
                minute[i] = str;
            }
            time1 = new JComboBox<String>(hour);
            time2 = new JComboBox<String>(minute);
            JPanel timeJP = new JPanel();
            JLabel label1 = new JLabel("小时");
            JLabel label2 = new JLabel("分钟");
            JButton button = new JButton("确定");
             button.addActionListener(new submitTime());
            timeJP.add(time1);
            timeJP.add(label1);
            timeJP.add(time2);
            timeJP.add(label2);
            timeJP.add(button);
            f.add(timeJP);
        }
    }
    JLabel label7;
    // 打开填报界面
    private class InsertMessage implements ActionListener {
        public void actionPerformed(ActionEvent event){
            JFrame f=new JFrame("疫情填报");    //创建窗体对象并赋标题参数
            f.setSize(800,300);    //设置窗体大小
            f.setBackground(Color.WHITE);    //设置背景颜色
            f.setLocation(10,10);    //设置窗体显示位置
            f.setVisible(true);    //显示窗体


            String[] CollegeArray = new String[] { "文学院", "历史文化学院", "教育学院", "心理学院", "马克思主义学院",
                    "哲学学院", "社会发展与公共管理学院","法学院 ", "经济学院", "商学院", "外国语学院 ", "音乐学院",
                    "舞蹈学院", "美术学院", "体育学院", "数学与统计学院", "计算机科学与工程学院", "物理与电子工程学院",
                    "化学化工学院", "生命科学学院", "地理与环境科学学院", "教育技术学院", "传媒学院", "旅游学院",
                    "国际文化交流学院", "敦煌学院" };

            String[] MonthArray = new String[] { "1", "2" ,"3","4", "5", "6", "6", "7", "8", "9", "10", "11","12"};
            String[] DayArray = new String[31];
            for (int i = 0; i < 31; i++) {
                String str = ""+(i+1);
                DayArray[i] = str;
            }

            String[] IDArray = new String[] { "学生", "老师" };

            String[] PlaceArray = new String[] { "西安", "北京", "天津", "石家庄", "太原", "沈阳", "长春", "哈尔滨", "上海",
                    "南京", "杭州", "合肥", "福州", "南昌", "济南", "郑州", "武汉", "兰州" };

            String[] SuitationArray = new String[] { "感染", "疑似", "无情况" };

            College = new JComboBox<String>(CollegeArray);
            month = new JComboBox<String>(MonthArray);
            Day = new JComboBox<String>(DayArray);
            name = new TextField("",20);
            ID = new JComboBox<String>(IDArray);
            Place = new JComboBox<String>(PlaceArray);
            Suitation = new JComboBox<String>(SuitationArray);

            JLabel label1 = new JLabel("学院：");
            JLabel labelmonth = new JLabel("月份：");
            JLabel label2 = new JLabel("日期：");
            JLabel label3 = new JLabel("姓名：  ");
            JLabel label4 = new JLabel("职业：");
            JLabel label5 = new JLabel("所在地：");
            JLabel label6 = new JLabel("感染情况：");
            label7 = new JLabel();


            JButton button = new JButton("填报");
            button.addActionListener(new MessageSubmit());

            InsertJpanel = new JPanel();
            InsertJpanel.setLayout(new GridLayout(8, 2));
            InsertJpanel.add(label1);
            InsertJpanel.add(College);
            InsertJpanel.add(labelmonth);
            InsertJpanel.add(month);
            InsertJpanel.add(label2);
            InsertJpanel.add(Day);
            InsertJpanel.add(label3);
            InsertJpanel.add(name);
            InsertJpanel.add(label4);
            InsertJpanel.add(ID);
            InsertJpanel.add(label5);
            InsertJpanel.add(Place);
            InsertJpanel.add(label6);
            InsertJpanel.add(Suitation);

            InsertJpanel.add(button);
            InsertJpanel.add(label7);

            f.add(InsertJpanel);
        }
    }
    // 填报信息按钮action
    private class MessageSubmit implements ActionListener {
        public void actionPerformed(ActionEvent event){
            SthFunction function = new SthFunction();

            String t1 =  College.getSelectedItem().toString();
            String t2 =  month.getSelectedItem().toString();
            String t3 =  Day.getSelectedItem().toString();
            String t4 =  name.getText();
            String t5 =  ID.getSelectedItem().toString();
            String t6 =  Place.getSelectedItem().toString();
            String t7 =  Suitation.getSelectedItem().toString();

            function.Insert_Message(t1,t2,t3,t4,t5,t6,t7);
            label7.setText("填报完成啦");
        }
    }
    // 确认时间按钮action
    SthFunction function = new SthFunction();;
    private class submitTime implements ActionListener {
        public void actionPerformed(ActionEvent event){
            function.setHour(time1.getSelectedItem().toString());
            function.setMinute(time2.getSelectedItem().toString());
            function.TimeConfirm();
        }
    }
}


