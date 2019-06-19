package leetcode.a61to70;

/**
 * @Description :
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/19 13:54
 * @Product_Name : leetcode
 */
public class MySqrt69 {

    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {

        long n = (long) x;
        for (int i = 1; i <= 50000; i++) {
            if ((long)i * i < n) {
                continue;
            } else if ((long)i * i == n) {
                return i;
            } else if ((long)i * i > n) {
                return i - 1;
            }
        }
        return 0;
    }
}
