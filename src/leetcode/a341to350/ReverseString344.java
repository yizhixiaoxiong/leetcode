package leetcode.a341to350;

/**
 * @Description : 字符串反转 使用 O(1) 的额外空间解决这一问题。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/1 11:09
 * @Product_Name : leetcode
 */
public class ReverseString344 {

    public static void main(String[] args) {
        char[] s =
                {'A', ' ', 'm', 'a', 'n', ',', ' ', 'a', ' ', 'p', 'l', 'a',
                        'n', ',', ' ', 'a', ' ', 'c', 'a', 'n', 'a', 'l', ':',
                        ' ', 'P', 'a', 'n', 'a', 'm', 'a'};
        reverseString(s);

        for (Character c : s) {
            System.out.print(c);
        }
    }

    public static void reverseString(char[] s) {
        if (s.length == 1) {
            return;
        }
        int n = s.length;
        int k = 0;
        //判断奇偶。
        //如果不判断奇偶，在偶数的条件下，取得的n/2是中位数后面的一个
        //导致两个问题：
        //      1. 多循环一次
        //      2. 多循环的一次会将已经交换过的正确元素再交换过来。
        if (n % 2 == 0) {
            k = n / 2 - 1;
        } else {
            k = n / 2;
        }
        char tmp = ' ';

        for (int i = 0; i <= k; i++) {
            tmp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = tmp;
        }
    }
}
