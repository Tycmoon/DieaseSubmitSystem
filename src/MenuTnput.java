import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: YANG
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

}