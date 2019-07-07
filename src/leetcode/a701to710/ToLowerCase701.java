package leetcode.a701to710;

/**
 * @Description : 转换成小写字母
 * 实现函数 ToLowerCase()，该函数接收一个字
 * 符串参数 str，并将该字符串中的大写字母转换
 * 成小写字母，之后返回新的字符串。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/7 0:00
 * @Product_Name : leetcode
 */
public class ToLowerCase701 {

    public static void main(String[] args) {
//        String str = "Hello";
//        String str = "LOVELY";
        String str = "here";
        System.out.println(toLowerCase(str));
    }
    //小写字符 范围在 97到122之间
    //大写字符在 65 到 90 之间
    //所以判断字符是否在65到90之间，如果在，则+32.使他等于小写字符
    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //是大写字符
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return String.valueOf(chars);
    }
}
