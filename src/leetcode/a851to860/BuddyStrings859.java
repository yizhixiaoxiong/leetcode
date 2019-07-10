package leetcode.a851to860;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description :亲密字符串
 * <p>
 * 给定两个由小写字母构成的字符串 A 和 B ，
 * 只要我们可以通过交换 A 中的两个字母得到与 B 相等的结
 * 果，就返回 true ；否则返回 false 。
 * <p>
 * 例1：
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * <p>
 * 示例 2：
 * <p>
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * <p>
 * 示例 3:
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * <p>
 * 示例 4：
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/7 20:18
 * @Product_Name : leetcode
 */
public class BuddyStrings859 {

    public static void main(String[] args) {
        String A = "aaaaaaabc";
        String B = "aaaaaaacb";
//        String A = "avbcahcaeajacsa";
//        String B = "avbcahcaeajacse";
//        String A = "aba";
//        String B = "aba";
        System.out.println(buddyStrings(A, B));
    }

    //修改A 可得到B
    //条件:   1. 如果A和B的长度不等，则是false
    //        2. 如果A和B 开始就相等，则false
    //双指针吗,前指针和后指针
    //      1.如果只有一个不同，则A交换不会得到B,返回false
    //      2.如果遇见了两个不同，则交换是否等于B，如果不等于及返回false
    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() <2  || B.length() < 2) {
            return false;
        }
        int start = -1;  //前面指针
        int end = -1;    //后面指针
        char tmp = ' ';
        if (A.equals(B)) { //如果全是一个字符符合，如果有两个以上相同字符的符合
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < A.length(); i++) {
                if (set.contains(A.charAt(i))) {
                    return true;
                } else {
                    set.add(A.charAt(i));
                }
            }
            return false;
        } else {
            for (int i = 0; i < A.length(); i++) {
                //随意寻找start和end
                //从两头分别往中间寻找不相等的字符下标
                //找到一个，就继续从两边往中间寻找下标
                //直到找到两个不同的字符下标
                //如果start和end相等，则表示只有一个不相等的字符
                if (A.charAt(i) != B.charAt(i)) {
                    if (start == -1) {
                        start = i;
                    } else if (end == -1) {
                        end = i;
                    }
                }
                if (A.charAt(A.length() - 1 - i) != B.charAt(A.length() - 1 - i)) {
                    if (end == -1) {
                        end = A.length() - 1 - i;
                    } else if (start == -1) {
                        start = A.length() - 1 - i;
                    }
                }
                if (start == end){
                    return false;
                }

                if (start!=-1 && end != -1){
                    break;
                }
//                if (start == -1){
//                    if (A.charAt(i) != B.charAt(i)) {
//                        start = i;
//                    }
//                }
//                if (end == -1){
//                    if (A.charAt(A.length() - 1 - i) != B.charAt(A.length() - 1 - i)) {
//                        end = A.length() - 1 - i;
//                    }
//                }
//                if (start == end) {
//                    return false;
//                }
            }
            //存在两个不相等的
            //交换两个不相等的字符用拼凑的新字符串比较B看是否相等
            char[] chars = A.toCharArray();
            tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            A = String.valueOf(chars);
            if (!A.equals(B)) {
                return false;
            }

        }
        return true;
    }
}
