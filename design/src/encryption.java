import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 * User: YANG
 */
public class encryption {
    byte[] enSimple(String Message){
        byte[] M_array = Message.getBytes();
        for (int i = 0; i < M_array.length; i++) {
            byte b = (byte) ((M_array[i]-Byte.MAX_VALUE+20) % Byte.MAX_VALUE);
            //System.out.print(b);
            M_array[i] = b;

        }
        return M_array;
    }
    char[] deSimple(byte[] M_array){
        char[] M_char = new char[M_array.length];

        for (int i = 0; i < M_array.length; i++) {
            M_char[i] = (char) ((M_array[i]-20+Byte.MAX_VALUE)% Byte.MAX_VALUE);

        }
        return M_char;
    }
    public static String toBinary(String str){
        //把字符串转成字符数组
        char[] strChar=str.toCharArray();

        String result="";
        for(int i=0;i<strChar.length;i++){
            //toBinaryString(int i)返回变量的二进制表示的字符串
            //toHexString(int i) 八进制
            //toOctalString(int i) 十六进制
            result +=Integer.toBinaryString(strChar[i])+ " ";
            System.out.println(Integer.toBinaryString(strChar[i]));
        }

        return result;
    }
    public static String toString(String binary) {
        String[] tempStr=binary.split(" ");
        char[] tempChar=new char[tempStr.length];
        for(int i=0;i<tempStr.length;i++) {
            tempChar[i]=BinstrToChar(tempStr[i]);
        }
        return String.valueOf(tempChar);
    }
    public static char BinstrToChar(String binStr){
        int[] temp=BinstrToIntArray(binStr);
        int sum=0;
        for(int i=0; i<temp.length;i++){
            sum +=temp[temp.length-1-i]<<i;
        }
        return (char)sum;
    }
    public static int[] BinstrToIntArray(String binStr) {
        char[] temp=binStr.toCharArray();
        int[] result=new int[temp.length];
        for(int i=0;i<temp.length;i++) {
            result[i]=temp[i]-48;
        }
        return result;
    }

    public static void main(String[] args) {

        String str = "◔‸◔？(ง •̀_•́)ง";
        String binary = toBinary(str);
        System.out.println(binary);
        System.out.println(toString(binary));


        /*
        encryption a = new encryption();
        String hello= "`1234567890-=~!@#$%^&*()_+QWERRTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm,./;'[]{}:<>?\"\'";
        String aaaa = "◔ ‸◔？";

        String xmlUTF8 = "";
        try {
            xmlUTF8 = URLEncoder.encode(aaaa, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.print(xmlUTF8);

        byte[] M = a.enSimple(hello);
        //System.out.print("\n"+"加密信息ASCII码值：");
        for (byte i:M) {
            //System.out.print(i);
        }
        System.out.println();
        char[] M_char = new char[M.length];
        for (int i = 0; i < M.length; i++) {
            M_char[i] = (char) M[i];
        }
        System.out.print("加密信息：");
        for (char i:M_char) {
            System.out.print(i);
        }
        System.out.print("\n"+"解密信息：");

        char[] DM = a.deSimple(M);
        for (char i:DM) {
            System.out.print(i);
        }
         */
    }

}

class enCrypt_And_deCryptUtil {

    /***
     * MD5加密
     * @param str 需要加密的参数
     * @return
     * @throws Exception
     */
    public  String encrypt_MD5(String str) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());
        return new BigInteger(1,md.digest()).toString(16);
    }

    /***
     * Base64加密
     * @param str 需要加密的参数
     * @return
     * @throws Exception
     */
    public String encrypt_Base64(String str) throws Exception {
        String result = Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
        return result;
    }

    /***
     * Base64解密
     * @param str 需要解密的参数
     * @return
     * @throws Exception
     */
    public String decrypt_Base64(String str) throws Exception {
        byte[] asBytes = Base64.getDecoder().decode(str);
        String result = new String(asBytes,"UTF-8");
        return result;
    }

}
