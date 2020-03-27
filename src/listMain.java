import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author yangye
 * @version V1.0
 */
public class listMain {
    public static void main(String[] args){

        ArrayList<Person> Personlist1 = new ArrayList<>();
        MenuTnput NewMenuInput = new MenuTnput();
        ReadFile Read = new ReadFile();
        try {
            Read.ReadDatatxt(Personlist1);
        } catch (FileNotFoundException e){
            System.out.println("查找不到信息");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("信息读取有误");
            e.printStackTrace();
        }
        //NewMenuInput.initializeGragh(Personlist1);
        NewMenuInput.SwingMenu();



    }
}



class Person {
    private String college;
    private String timeM;
    private String timeD;
    private String name;
    private String ID;
    private String place;
    private String situation1;

    public void setCollege(String college) {
        this.college = college;
    }

    public void setTimeM(String timeM) {
        this.timeM = timeM;
    }

    public void setTimeD(String timeD) {
        this.timeD = timeD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setSituation1(String situation1) {
        this.situation1 = situation1;
    }

    public String getCollege() {
        return college;
    }

    public String getTimeM() {
        return timeM;
    }

    public String getTimeD() {
        return timeD;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getPlace() {
        return place;
    }

    public String getSituation1() {
        return situation1;
    }

    public String toString() {
        return  college +"\t"+ timeM +"\t"+ timeD +"\t"+ name +"\t"+ ID +"\t"+ place +"\t"+ situation1+"\n";

    }
}

class ReadFile{
    void ReadDatatxt(ArrayList<Person> a) throws IOException {
        String fileName ="Text.txt";
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String temp = null;
        while ((temp = bufferedReader.readLine()) != null) {
            Scanner linescanner = new Scanner(temp);
            linescanner.useDelimiter("&");
            String college = linescanner.next();
            String timeM = linescanner.next();
            String timeD = linescanner.next();
            String name = linescanner.next();
            String ID = linescanner.next();
            String place =linescanner.next();
            String situation1 = linescanner.next();
            Person Person = new Person();
            Person.setCollege(college);
            Person.setTimeM(timeM);
            Person.setTimeD(timeD);
            Person.setName(name);
            Person.setID(ID);
            Person.setPlace(place);
            Person.setSituation1(situation1);
            a.add(Person);
        }
    }
}
