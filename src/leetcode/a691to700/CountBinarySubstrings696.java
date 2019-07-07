package leetcode.a691to700;

/**
 * @Description : 计数二进制子串
 * <p>
 * 给定一个字符串 s，计算具有相同
 * 数量0和1的非空(连续)子字符串的数量，
 * 并且这些子字符串中的所有0和所有1都是
 * 组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 例1：
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，
 * “1100”，“10”，“0011” 和 “01”。
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）
 * 没有组合在一起。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/6 22:19
 * @Product_Name : leetcode
 */
public class CountBinarySubstrings696 {

    public static void main(String[] args) {
//        String s = "00110011";
//        String s = "10101";
        String s = "0001100011000001011111100000001";
//        String s = "01111";


        System.out.println(countBinarySubstrings1(s));
    }

    //寻找子串
    // 条件1：子串中0和1的数量相等
    // 条件2：子串不允许0和1交叉出现

    //找到 0 和 1的交叉位置，然后向两边循环
    public static int countBinarySubstrings(String s) {
        int start = 0;
        int end = 0;
        int count = 0;
        if (s.length() == 1) {
            return count;
        }
        char ch = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != ch) {
                start = i - 1;
                end = i;
                while (true) {
                    //如果不相等
                    if (s.charAt(start) != s.charAt(end)) {
                        count++;
                        start--;
                        end++;
                        if (start < 0 || end == s.length() || ch == s.charAt(end)) {
                            ch = s.charAt(end - 1);
                            i = end - 1;
                            break;
                        }
                    } else {//相等,赋值跳出循环
                        ch = s.charAt(end - 1);
                        i = end;
                        break;
                    }
                }
            }
        }
        return count;
    }

    //因为不允许交叉,所以可以统计每个字符每次出现的次数
    //例如 ”00110011“, 字符每次出现的次数为
    //      2 2 2 2
    // 所以每次比较相邻的两个数字，取小的
    public static int countBinarySubstrings1(String s) {
        if (s.length() == 0 ){
            return 0;
        }
        int count = 1; //统计每个字符出现的次数
        char ch = s.charAt(0);  //哨兵
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                count++;
            } else {
                sb.append(count);
                count = 1;
                if (i == s.length()-1){
                    sb.append(count);
                }
                ch = s.charAt(i);
            }
        }
        if (count > 1){
            sb.append(count);
        }
        if (sb.length() == 1){
            return 0;
        }
        //获取count中的第一个字符出现的次数
        char num = sb.charAt(0);
        int sum = 0;
        for (int i = 1; i < sb.length(); i++) {
            int min = (Math.min(num, sb.charAt(i)) - '0');
            sum += min;
            num = sb.charAt(i);
        }
        return sum;
    }
}
