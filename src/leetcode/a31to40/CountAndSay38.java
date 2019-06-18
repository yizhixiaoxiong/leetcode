package leetcode.a31to40;

/**
 * @Description : 报数序列一个整数序列
 * 难度：简单
 * 如 整数     序列
 * 1       1
 * 2       11
 * 3       21
 * 4       1211
 * 5       111221
 * 6       312211
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/18 14:14
 * @Product_Name : leetcode
 */
public class CountAndSay38 {

    public static void main(String[] args) {
        int n = 2;
        String s = countAndSay(n);
        System.out.println(s);
    }

    //观察序列可知,只要相邻的数字相同，统计一共n个相同的数字x,则表示nx
    //一般来说，如果要计算n的报数序列，就需要知道n-1的报数序列
    //第一想法：使用递归
    public static String countAndSay(int n) {
        if (n == 1) return String.valueOf(n);
        String result = countAndSay(n - 1);

        StringBuffer sb = new StringBuffer();
        char[] chars = result.toCharArray();
        int m = chars.length;
        //使用双指针来循环比较字符串
        int k = 0;      //慢指针
        //计算有几个相同的数据,
        int p = 0;
        //i为快指针
        for (int i = 1; i < m +1; i++) {
            //当快指针指向为空的时候，说明已经到了结尾。用快指针的下标-慢指针的下标，
            // 就是统计相同的元素个数，将统计数 p 和 相同的值存入sb 跳出循环
            if (i == m ){
                p = i- k;
                sb.append(p);
                sb.append(Integer.parseInt(String.valueOf(chars[k])));
                break;
            }
            //如果快指针指向的数据不等于慢指针，则统计有几个相同的数据
            if (chars[i] != chars[k]) {
                //相同数据连在一起的个数
                p = i - k;
                //将统计数放入sb并将相同数据的值放入sb
                sb.append(p);
                sb.append(Integer.parseInt(String.valueOf(chars[k])));
                //使慢指针指向快指针指向的位置,重新匹配
                k = i;
            }
        }
        //返回sb
        return sb.toString();
    }

}
