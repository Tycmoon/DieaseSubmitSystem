import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by IntelliJ IDEA.
 * User: YANG
 *
 * 说明：功能类
 * 目前有插入功能
 */
public class SthFunction {
    // 插入信息函数
    public void Insert_Message(String College,String month,String day,String Name,String ID,String Place,String Suitation) {
        String str = College+"&"
                +month+"月&"
                +day+"日&"
                +Name+"&"
                +ID+"&"
                +Place+"&"
                +Suitation;
        FileWriter FileW = null;
        try {
            FileW = new FileWriter("Text.txt",true);
            FileW.write(str+"\r\n");
            FileW.flush();
            FileW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String hour,minute;
    public void setHour(String hour) {
        this.hour = hour;
    }
    public void setMinute(String minute) {
        this.minute = minute;
    }
    public String getHour() {
        return hour;
    }

    public String getMinute() {
        return minute;
    }

    Timer timer = new Timer();
    String h_local,m_local;

    public void TimeConfirm(){
        TimerTask timeTask=new TimerTask(){
            @Override
            public void run() {
                Calendar cal=Calendar.getInstance();
                h_local = cal.get(Calendar.HOUR_OF_DAY)+"";
                m_local = cal.get(Calendar.MINUTE)+"";
                System.out.println("h:"+h_local+"m"+m_local);
                System.out.println("h1:"+hour+"m1"+minute);
                //h_local = "10";
                //m_local = "0";
                if (h_local.equals(hour) && m_local.equals(minute)){
                    JFrame f=new JFrame("提醒");    //创建窗体对象并赋标题参数
                    f.setSize(300,200);    //设置窗体大小
                    f.setBackground(Color.WHITE);    //设置背景颜色
                    f.setLocationByPlatform(true);
                    f.setVisible(true);    //显示窗体

                    JLabel JLabel = new JLabel("该填报信息了");
                    JPanel P = new JPanel();
                    P.add(JLabel);
                    f.add(P);
                }
            }
        };
        timer.schedule(timeTask,  1,30*1000);
    }
}
