import java.io.FileWriter;
import java.io.IOException;

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

}
