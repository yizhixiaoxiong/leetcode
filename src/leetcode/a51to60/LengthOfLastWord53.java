package leetcode.a51to60;

/**
 * @Description : 最后一个单词的长度
 *                给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *                如果不存在最后一个单词，请返回 0 。
 *
 *                难度： 简单
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/18 21:32
 * @Product_Name : leetcode
 */
public class LengthOfLastWord53 {

    public static void main(String[] args) {
        String s = " hello world ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        if(s.equals("")) return 0;
        //查找最后一个' ' 所在的位置，然后计算最后一个空格到字符串结尾的长度
        //保证字符串两侧不是以 ' ' 开始或者结束
        s = s.trim();
        int i = s.lastIndexOf(" ");
        return s.length() - i - 1;
    }
}
