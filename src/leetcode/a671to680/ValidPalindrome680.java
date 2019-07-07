package leetcode.a671to680;

/**
 * @Description :验证回文字符串 Ⅱ
 * <p>
 * 给定一个非空字符串 s，最多删除一个字符。
 * 判断是否能成为回文字符串。
 * <p>
 * 例1
 * 输入: "aba"
 * 输出: True
 * <p>
 * 例2
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/5 22:43
 * @Product_Name : leetcode
 */
public class ValidPalindrome680 {

    public static void main(String[] args) {
        String str = "abac";
        System.out.println( validPalindrome1(str));
    }

    //回溯算法
    public static boolean validPalindrome1(String s) {
        int len = s.length()-1;
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(len--)){
                //去掉前面的字符
                boolean result1 = valid(s.substring(i + 1, len+2));
                if (result1) {
                    return true;
                }else{
                    //去掉后面的字符
                    boolean result2 = valid(s.substring(i, len+1));
                    if (result2){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static boolean valid(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
