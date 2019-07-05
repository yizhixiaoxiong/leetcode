package leetcode.a511to520;

/**
 * @Description : 最长特殊序列 Ⅰ
 *
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/4 11:20
 * @Product_Name : leetcode
 */
public class FindLUSlength521 {
    //最长特殊子序列是某个字符串独有的最长子序列
    //而且任何字符串本身也是子序列
    //所以:
    //1. 当两个字符串长度一样的时候,如果这两个字符串不相等
    //     则 最长特殊序列的长度为两个字符串本身。如果相等，return -1;

    //2. 当两个字符串不相等的时候,最长特殊序列为长的字符串
    public int findLUSlength(String a, String b) {

        if (a.length() == b.length()){
            if (!a.equals(b)) {
                return a.length();
            }
        }

        if (a.length() != b.length()){
            return Math.max(a.length(), b.length());
        }
        return -1;
    }

    //简化版
    public int findLUSlength1(String a, String b) {
        if (!a.equals(b)) {
            return Math.max(a.length(), b.length());
        }
        return -1;
    }
}
