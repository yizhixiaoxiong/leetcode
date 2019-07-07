package leetcode.a451to460;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由
 * 它的一个子串重复多次构成。给定的字符串只含有小写英文字母，
 * 并且长度不超过10000。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/3 11:46
 * @Product_Name : leetcode
 */
public class RepeatedSubstringPattern459 {

    public static void main(String[] args) {
//        String s = "abab";
//        String s = "aba";
//        String s = "abcabcabcabc";
        String s = "abcdeabcdedabcdeabcded";
//        String s = "abc";
//        String s = "aa";
        System.out.println(repeatedSubstringPattern1(s));
    }


    //查看主串是否有同一个子串构成
    //子串可以用hash表示
    //如果是偶数子串构成的,则整个串为偶数位
    //如果是奇数子串构成，则整个串可能是奇数

    //循环
    //找到和第一个字符相等的字符，找到下标index,然后比对从第一个字符到index
    //和index之后的子串长度比对，如果相等，找到下一个和子串长度相同的字符串匹配
    //如果遇到不匹配的，再找到下一个和第一个字符相同字符的index，重复比对
    public static boolean repeatedSubstringPattern(String s) {

        int n = s.length();
        int start = 0;
        int len = 0;    //子串长度
        char c = s.charAt(0);

        for (int i = 1; i < n; i++) {
            len = 0;
            //如果遇到和第一个字符相同的字符
            if (s.charAt(i) == c) {
                start = len;
                len = i;
                //子串
                String subStr = s.substring(start, len);

                while (i < n) {
                    if (i + len > n) {
                        return false;
                    }
                    String repeatStr = s.substring(i, i + len);
                    if (subStr.equals(repeatStr)) {
                        i = i + len;
                    } else {
                        i = len;
                        break;
                    }
                }
            }
        }
        //说明没有相同的公共子串
        if (len == 0) {
            return false;
        }
        return true;
    }

    //因为主串为子串重复构成，假如子串的长度为i，则len/i 则是一个整数
    public static boolean repeatedSubstringPattern1(String s) {
        int len = s.length();
        //将s从中间为起始点 i 为字串周期
        for (int i = len / 2; i >= 1; i--) {

            ///没有余数被i整除，这种情况i的长度可能就是子串的长度
            if (len % i == 0) {
                boolean pass = true;
                //获取子串
                String h = s.substring(0, i);

                for (int j = len / i; j > 1; j--) {
                    //如果子串们不相等
                    if (!h.equals(s.substring(i * (j - 1), i * j))) {
                        pass = false;
                        break;
                    }
                }
                if (pass) {
                    return true;
                }
            }
        }
        return false;
    }
}
