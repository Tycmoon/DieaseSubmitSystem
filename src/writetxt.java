import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class writetxt {
    public static void main(String[] args){

        String[] CollegeArray = new String[]{"文学院" ,
                "历史文化学院" ,
                "教育学院" ,
                "心理学院" ,
                "马克思主义学院" ,
                "哲学学院" ,
                "社会发展与公共管理学院" ,
                "法学院 " ,
                "经济学院" ,
                "商学院" ,
                "外国语学院 " ,
                "音乐学院" ,
                "舞蹈学院" ,
                "美术学院" ,
                "体育学院" ,
                "数学与统计学院" ,
                "计算机科学与工程学院" ,
                "物理与电子工程学院" ,
                "化学化工学院" ,
                "生命科学学院" ,
                "地理与环境科学学院" ,
                "教育技术学院" ,
                "传媒学院" ,
                "旅游学院" ,
                "国际文化交流学院" ,
                "敦煌学院"};
        String Name = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";

        String[] P_ID = new String[]{"学生","老师"};
        String[] Place = new String[]{"西安","北京","天津","石家庄","太原","沈阳","长春","哈尔滨","上海","南京","杭州","合肥","福州","南昌","济南","郑州","武汉","兰州"};
        String[] Suitation = new String[]{"感染","疑似","无情况"};



        FileWriter FileW = null;
        try {
            FileW = new FileWriter("Text.txt");
            Random NewRandom = new Random();
            for (int i = 0; i < 1000; i++) {
                int RandomNumber = NewRandom.nextInt(1000);
                int RandomNumber2 = NewRandom.nextInt(10000);
                int RandomNumber3 = NewRandom.nextInt(22222);
                int a = RandomNumber%(Name.length()-3);
                int b = RandomNumber2%(Name.length()-3);
                int c = RandomNumber3%(Name.length()-3);
                String str = CollegeArray[RandomNumber%CollegeArray.length]+"&"
                        +(1+RandomNumber%12)+"&"
                        +(1+RandomNumber2%31)+"&"
                        +Name.substring(a,a+1)+Name.substring(b,b+1)+Name.substring(c,c+1)+"&"
                        +P_ID[RandomNumber%2]+"&"
                        +Place[RandomNumber2%Place.length]+ "&"
                        +Suitation[RandomNumber%Suitation.length];

                FileW.write(str+"\r\n");
            }


            FileW.flush();
            FileW.close();
        }catch(IOException e) {
            e.printStackTrace();

        }

    }
}
