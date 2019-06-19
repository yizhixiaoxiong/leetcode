package leetcode.a61to70;

/**
 * @Description :
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/19 14:34
 * @Product_Name : leetcode
 */
public class ClimbStairs70 {

    public static void main(String[] args) {
        int n = 44;
        int types = climbStairs2(n);
        System.out.println(types);
    }
    // 1.1 回溯算法
    public static int climbStairs(int n) {
        //一共有多少种方法
        int types = 0;
        //已爬过的阶梯数量
        int size = 0;
        types = types(size, n, types);
        return types;
    }

    public static int types(int size, int n, int types) {
        if (size == n) { //已经爬到了顶
            return ++types;
        }else if(size > n ){
            return types;
        }
        types = types(size + 1, n, types);
        types = types(size + 2, n, types);
        return types;
    }

    // 1.2 动态规划
    // 查找最优子问题
    // 当走到位置为i的时候,只会从两个位置走到i，i-1 和 i-2。
    // 所以 状态方程为 f(i) = f(i-1) + f(i-2)
    public static int climbStairs2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        //数组dp下标表示 走到第i个位置，存储的值是存在的走法
        int[] dp = new int[n+1];
        //当n为1时候,有1种走法
        dp[1] = 1;
        //当n为2的时候,有两种走法: 1+1 和 2
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

}
