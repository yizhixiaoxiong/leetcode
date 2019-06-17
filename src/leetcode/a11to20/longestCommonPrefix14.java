package leetcode.a11to20;

/**
 * @Description : 最长公共前缀
 *      编写一个函数来查找字符串数组中的最长公共前缀。
 *      如果不存在公共前缀，返回空字符串 ""。
 *
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/15 14:39
 * @Product_Name : leetcode
 */
public class longestCommonPrefix14 {

    public static void main(String[] args) {
        String[] strs = {"dog", "racecar", "car"};
//        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"aaaa","aa","aaaaa"};
        System.out.println(longestCommonPrefix2(strs));
    }

    //思路，拿出第一个字符串和第二个字符串比较获取公共字符
    // 然后在和第三个字符比较，获取公共字符
    //最后的结果为字符前缀
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

}
