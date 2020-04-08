import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: YANG
 * Date: 2020/4/1
 */
public class message {
    private String message;
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void writeMessage() {
        FileWriter FileW = null;
        try {
            FileW = new FileWriter("message",true);
            Calendar cal=Calendar.getInstance();
            String time = cal.getTime().toString();
            FileW.write("-------------------------"+"\n");
            FileW.write(time+"\n");
            FileW.write(""+message+"\r\n");
            FileW.write("-------------------------"+"\n");
            FileW.flush();
            FileW.close();
        }catch(IOException e) {
            e.printStackTrace();

        }
    }
    public void writeMessagenull() {
        FileWriter FileW = null;
        try {
            FileW = new FileWriter("message");
            FileW.write("");
            FileW.flush();
            FileW.close();
        }catch(IOException e) {
            e.printStackTrace();

        }
    }
}


