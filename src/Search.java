import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: YANG
 *
 * 说明：查询类
 */
class Search{
    void SearchName(ArrayList<Person> a, String name){
        long startTime =  System.currentTimeMillis();
        for (int i = 0; i < a.size(); i++) {
            if(name.equals(a.get(i).getName())){
                System.out.print(a.get(i));
                break;
            }
        }
        long endTime =  System.currentTimeMillis();
        System.out.print("运行时间："+(endTime-startTime)+"\n");


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


    // 信息中各个字段
    public static String[][] GraphList = new String[6][100];
    // 信息总数
    static int PERSON_LIST_SIZE;
    // 读取字段值填入数组中
    void graghTest(ArrayList<Person> a){
        PERSON_LIST_SIZE = a.size();
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
    public static int[][] ListCount = new int[6][100];
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

    void ShowAllGragh(){
        System.out.print("输入数字0 1 2 3 4 5 ");
        Scanner Input = new Scanner(System.in);
        int index = Input.nextInt();
        if (index<7 && index>=0){
            for (int i = 0; i < GraphList[index].length; i++) {
                if (GraphList[index][i]!=null){
                    int value = 100;
                    if (index == 5 || index == 2)value = 10;
                    for (int j = 0; j < ListCount[index][i]*value/PERSON_LIST_SIZE; j++) {
                        System.out.print("▆");
                    }
                    System.out.print(GraphList[index][i]+":"+ListCount[index][i]+"\n");
                }
            }
        }else {
            System.out.print("不合法的输入");
        }
    }
    void BuildGragh(){
        // 生成图表
        ProduceChart Pc = new ProduceChart();
        Pc.ProduceChartC(GraphList,ListCount);
        Pc.ProduceChartC2(GraphList,ListCount);
    }

}
