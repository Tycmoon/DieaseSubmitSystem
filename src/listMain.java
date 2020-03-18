import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


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
        NewMenuInput.InputNumber(Personlist1);

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

class Search{
    void SearchName(ArrayList<Person> a,String name){
        for (int i = 0; i < a.size(); i++) {
            if(name.equals(a.get(i).getName()))
                System.out.print(a.get(i));
        }
    }
    void SearchStudent(ArrayList<Person> a){
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getID().equals("学生")){
                System.out.print(a.get(i));
            }
        }
    }
    void SearchTeacher(ArrayList<Person> a){
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getID().equals("老师")){
                System.out.print(a.get(i));
            }
        }
    }
    void Search(ArrayList<Person> a,String Word){
        for (int i = 0; i < a.size(); i++) {
            String str = a.get(i).toString();
            if (str.contains(Word))
                System.out.print(a.get(i));
        }
    }
    void BuildPlaceGragh(ArrayList<Person> a){
        String[] GraphList = new String[100];
        int index = 0;
        for (Person i:a) {
            if (!Arrays.asList(GraphList).contains(i.getPlace())){
                GraphList[index] = i.getPlace();
                index++;
            }
        }
        for (int i = 1; i < GraphList.length; i++) {
            int placecount = 0;
            if (GraphList[i]!=null){
                System.out.print(GraphList[i]+"\t");
                for (int j = 0; j < a.size(); j++) {
                    if (a.get(j).getPlace().equals(GraphList[i])){
                        placecount++;
                    }
                }
                System.out.print(placecount+"\t");
                for (int j = 0; j < placecount*300/a.size(); j++) {
                    System.out.print("▆");
                }
                System.out.print("\n");
            }else {
                break;
            }

        }
    }
    void BuildCollegeGragh(ArrayList<Person> a){
        String[] GraphList = new String[100];
        int index = 0;
        for (Person i:a) {
            if (!Arrays.asList(GraphList).contains(i.getCollege())){
                GraphList[index] = i.getCollege();
                index++;
            }
        }
        for (int i = 1; i < GraphList.length; i++) {
            int CollegeCount = 0;
            if (GraphList[i]!=null){
                if (GraphList[i].length()>4)
                System.out.print(GraphList[i].substring(0,4)+"\t");
                else System.out.print(GraphList[i]+"\t");
                for (int j = 0; j < a.size(); j++) {
                    if (a.get(j).getCollege().equals(GraphList[i])){
                        CollegeCount++;
                    }
                }
                System.out.print(CollegeCount+"\t");
                for (int j = 0; j < CollegeCount*300/a.size(); j++) {
                    System.out.print("▆");
                }
                System.out.print("\n");
            }else {
                break;
            }

        }
    }
    void BuildTimeGragh(ArrayList<Person> a){
        String[] GraphList = new String[100];
        int index = 0;
        for (Person i:a) {
            if (!Arrays.asList(GraphList).contains(i.getTimeM())){
                GraphList[index] = i.getTimeM();
                index++;
            }
        }
        for (int i = 1; i < GraphList.length; i++) {
            int TimeCount = 0;
            if (GraphList[i]!=null){
                System.out.print(GraphList[i]+"\t");
                for (int j = 0; j < a.size(); j++) {
                    if (a.get(j).getTimeM().equals(GraphList[i])){
                        TimeCount++;
                    }
                }
                System.out.print(TimeCount+"\t");
                for (int j = 0; j < TimeCount*200/a.size(); j++) {
                    System.out.print("▆");
                }
                System.out.print("\n");
            }else {
                break;
            }

        }
    }
    void TimegraghDay(ArrayList<Person> a){
        String[] GraphList = new String[100];
        int index = 0;
        for (Person i:a) {
            if (!Arrays.asList(GraphList).contains(i.getTimeD())){
                GraphList[index] = i.getTimeD();
                index++;
            }
        }
        for (int i = 1; i < GraphList.length; i++) {
            int TimeCount = 0;
            if (GraphList[i]!=null){
                System.out.print(GraphList[i]+"\t");
                for (int j = 0; j < a.size(); j++) {
                    if (a.get(j).getTimeD().equals(GraphList[i])){
                        TimeCount++;
                    }
                }
                System.out.print(TimeCount+"\t");
                for (int j = 0; j < TimeCount*500/a.size(); j++) {
                    System.out.print("▆");
                }
                System.out.print("\n");
            }else {
                break;
            }

        }
    }
    // 信息中各个字段
    static String[][] GraphList = new String[6][100];
    // 读取字段值填入数组中
    void graghTest(ArrayList<Person> a){
        int[] index = new int[]{0,0,0,0,0,0,0};
        for (Person i:a) {
            if (!Arrays.asList(GraphList[0]).contains(i.getCollege()))GraphList[0][index[0]++] = i.getCollege();
            if (!Arrays.asList(GraphList[1]).contains(i.getPlace()))GraphList[1][index[1]++] = i.getPlace();
            if (!Arrays.asList(GraphList[2]).contains(i.getID()))GraphList[2][index[2]++] = i.getID();
            if (!Arrays.asList(GraphList[3]).contains(i.getTimeD()))GraphList[3][index[3]++] = i.getTimeD();
            if (!Arrays.asList(GraphList[4]).contains(i.getTimeM()))GraphList[4][index[4]++] = i.getTimeM();
            if (!Arrays.asList(GraphList[5]).contains(i.getSituation1()))GraphList[5][index[5]++] = i.getSituation1();
        }
        /*
         *
         * 查看录入字段
        for (int i = 0; i < GraphList.length; i++) {
            for (int j = 0; j < GraphList[i].length; j++) {
                if (GraphList[i][j] != null)
                System.out.print(GraphList[i][j]+" ");
            }
            System.out.print("\n");
        }
        */
    }
    // 信息中字段计数的值
    static int[][] ListCount = new int[6][100];
    void BuildCount(ArrayList<Person> a){
        // 遍历计数
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < GraphList[i].length; j++) {

                if (GraphList[i][j]!=null)
                    for (int k = 0; k < a.size(); k++) {
                        if (a.get(k).getCollege().equals(GraphList[i][j]) && i==0) ListCount[i][j]++;
                        if (a.get(k).getPlace().equals(GraphList[i][j]) && i==1) ListCount[i][j]++;
                        if (a.get(k).getID().equals(GraphList[i][j]) && i==2) ListCount[i][j]++;
                        if (a.get(k).getTimeD().equals(GraphList[i][j]) && i==3) ListCount[i][j]++;
                        if (a.get(k).getTimeM().equals(GraphList[i][j]) && i==4) ListCount[i][j]++;
                        if (a.get(k).getSituation1().equals(GraphList[i][j]) && i==5) ListCount[i][j]++;
                    }
            }
        }
    }
    void ShowCount(){
        for (int i = 0; i < GraphList.length; i++) {
            for (int j = 0; j < GraphList[i].length; j++) {
                if (GraphList[i][j]!=null){
                    System.out.print(GraphList[i][j]+":"+ListCount[i][j]+"\n");
                }
            }
        }
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
class MenuTnput{
    void InputNumber(ArrayList<Person> Personlist1){
        boolean flag = true;
        Search Search = new Search();
        Scanner TextInput = new Scanner(System.in);
        while(flag) {
            System.out.print("0:EXIT        \t"+"1:search name      \t"+"2:search student\t"+"3:search teacher\t\n"
                    +"4:Placegraph \t"+"5:timegraph(month)\t"+"6:CollegeGragh   \t" +"7:Timegargh(day)\t"
                    +"\n8:INPUTSOMETHING\t"+"9：ShowAllListCount");
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
                System.out.println("PalceGraph");
                Search.BuildPlaceGragh(Personlist1);
            }else if (number.equals("5")){
                System.out.println("TimeGraph(mongth)");
                Search.BuildTimeGragh(Personlist1);
            }else if (number.equals("6")){
                System.out.println("CollegeGraph");
                Search.BuildCollegeGragh(Personlist1);
            } else if(number.equals("7")){
                System.out.println("TimeGraph(Day)");
                Search.TimegraghDay(Personlist1);
            } else if(number.equals("8")){
                System.out.print("INPUTSOMETHING:");
                String InputWord = TextInput.next();
                Search.Search(Personlist1,InputWord);
            } else if(number.equals("9")){
                System.out.print("ShowAllListCount：\n");
                Search.graghTest(Personlist1);
                Search.BuildCount(Personlist1);
                Search.ShowCount();
            }else if (number.equals("0")){
                flag = false;
            }else {
                System.out.println("不合法的输入");
            }

        }

    }
}