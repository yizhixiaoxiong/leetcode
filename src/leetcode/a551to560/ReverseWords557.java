package leetcode.a551to560;

/**
 * @Description : 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字
 * 符顺序，同时仍保留空格和单词的初始顺序
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * <p>
 * 注意：在字符串中，每个单词由单个空格分隔，
 * 并且字符串中不会有任何额外的空格。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/5 13:22
 * @Product_Name : leetcode
 */
public class ReverseWords557 {


    public static void main(String[] args) {
        String s = "Let's";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            char[] chars = str[i].toCharArray();
            reverse(chars, 0, chars.length - 1);
            sb.append(chars);
            if (i + 1 <= str.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static void reverse(char[] chars,
                                int start, int emd) {
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }
}
