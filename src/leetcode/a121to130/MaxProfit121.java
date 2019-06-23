package leetcode.a121to130;

/**
 * @Description :
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/20 10:05
 * @Product_Name : leetcode
 */
public class MaxProfit121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit4(prices);
        System.out.println(maxProfit);
    }

    //动态规划
    //设定一个数组,记录第i天的最大利润
    // 第i天的最大利润为 ： 第i-1 天的最大利润 ; 或者 第i天的卖价 - i之前的最小的买价
    public static int maxProfit(int[] prices) {

        if (prices.length <= 1) return 0;
        int n = prices.length;
        //设定一个数组，dp[] 下表表示第i个天，值为第i天的最大利润
        int maxProfit = 0;
        //最小金甲
        int min_jinjia = prices[0];
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min_jinjia);
            if (min_jinjia > prices[i]) {
                min_jinjia = prices[i];
            }
        }
        return dp[n - 1];
    }
    //不用额外数组
    public static int maxProfit2(int[] prices) {
        if (prices.length <= 1) return 0;
        int n = prices.length;
        int min_jinjia = prices[0];
        int maxProfit = 0;

        //最大利润为 最大的卖价 - 最小的买价
        for (int i = 1; i < n; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min_jinjia);
            if (min_jinjia > prices[i]){
                min_jinjia  = prices[i];
            }
        }
        return maxProfit;
    }

    //暴力法，双重循环
    public static int maxProfit3(int[] prices) {
        int n = prices.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (max < prices[j] - prices[i]) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }


    //测试方法 总结
    public static int maxProfit4(int[] prices){
        int n = prices.length;

        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1 ,-prices[i]);
        }

        return dp_i_0;
    }
}
