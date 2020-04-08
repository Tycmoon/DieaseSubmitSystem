import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;


public class test{
    public static void main(String[] args) {
        String str = "abc";
        enCrypt_And_deCryptUtil m = new enCrypt_And_deCryptUtil();

        try{
            System.out.println("str:"+str);
            String a = m.encrypt_Base64(str);
            System.out.println("a:"+a);
            String b = m.decrypt_Base64(a);
            System.out.println("b:"+b);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}


/**
 * MD5加密，Base64的加密和解密
 * @author knot
 *
 */
class enCrypt_And_deCryptUtil1 {

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
