import javax.swing.*;
import javax.swing.text.TextAction;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: YANG
 * Date: 2020/3/26
 */
class MenuTnput{
    // 命令行菜单显示
    void InputNumber(ArrayList<Person> Personlist1){
        boolean flag = true;
        Search Search = new Search();
        Scanner TextInput = new Scanner(System.in);
        // 初始化
        Search.graghTest(Personlist1);
        Search.BuildCount(Personlist1);
        while(flag) {
            System.out.print("0:EXIT        \t"+"1:search name      \t"+"2:search student\t"+"3:search teacher\t\n"
                    +"4:AllGragh\t"+"\n8:INPUTSOMETHING\t"+"9：ShowAllListCount");
            String number = TextInput.next();
            if (number.equals("1")) {
                System.out.print("input name:\n");
                String InputName = TextInput.next();
                Search.SearchName(Personlist1,InputName);
            }else if (number.equals("2")) {
                System.out.println("student message:");
                Search.SearchStudent(Personlist1);
            }else if (number.equals("3")) {
                System.out.println("teacher message:");
                Search.SearchTeacher(Personlist1);
            }else if (number.equals("4")){
                Search.ShowAllGragh();
            }else if(number.equals("8")){
                System.out.print("INPUTSOMETHING:");
                String InputWord = TextInput.next();
                Search.Search(Personlist1,InputWord);
            } else if(number.equals("9")){
                System.out.print("ShowAllListCount：\n");
                Search.ShowCount();
            }else if (number.equals("0")){
                flag = false;
            }else {
                System.out.println("不合法的输入");
            }

        }

    }

    // 生成图表
    public void initializeGragh(ArrayList<Person> Personlist1){
        Search Search = new Search();
        Search.graghTest(Personlist1);
        Search.BuildCount(Personlist1);
        Search.BuildGragh();
    }

    public void SwingMenu(){
        EventQueue.invokeLater(()->{
            Frame Frame = new Frame();
            Frame.setTitle("疫情上报系统");
            Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Frame.setVisible(true);
        });
    }
}

class Frame extends JFrame{
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screensize = kit.getScreenSize();
    private int width = screensize.width;
    private int height = screensize.height;
    // 界面绘制
    public Frame(){

        // set width height
        setSize(width/2,height/2);
        setLocationByPlatform(true);
        // set icon
        Image img = new ImageIcon("img//Disease.png").getImage();
        setIconImage(img);
        AddMenu();



    }
    public void AddMenu(){
        // Mainmenu
        JMenuBar MainMenu = new JMenuBar();
        // menu1
        JMenu Menu1 = new JMenu("菜单1");
        Action SearchEngine = new TextAction("Search一下") {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        Action SearchStudent = new TextAction("查询") {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        Menu1.add(SearchEngine);
        Menu1.add(SearchStudent);
        // menu2
        JMenu Menu2 = new JMenu("菜单2");
        Action CollegeGragh = new TextAction("CollegeGragh") {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };



        // MainMenu ADD
        MainMenu.add(Menu1);
        MainMenu.add(Menu2);
        add(MainMenu,BorderLayout.NORTH);
    }

}