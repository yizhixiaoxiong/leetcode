package leetcode.a51to60;

/**
 * @Description : 动态规划开胃菜
 *             给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素）
 *             ，返回其最大和。
 *             如：
 *              输入: [-2,1,-3,4,-1,2,1,-5,4],
 *              输出: 6
 *              解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/18 19:05
 * @Product_Name : leetcode
 */
public class MaxSubArray53 {

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(a));
    }

    //原理: 1.以负数开头的数组序列不会是最大的子序列，
    //  同样的，以和为负数的子数列一定不会是和最大的子数列
    //  时间复杂度 ： 只遍历一次数组 复杂度为O(n).
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }

    //TODU
    //动态规划的算法: 计算每一层的状态
    public static int maxSubArray2(int[] nums) {
        int dp[] = new int[nums.length + 1];
        dp[0] = nums[0];
        //计算动态规划每一个阶段的状态
        //下标代表以第i个元素结尾A[i]的子数列
        //  有如下 情况；

        //  当有只有i一个元素的时候,数据A[i]最大
        //  当有多个元素的时候,最大子数组为 (dp[i-1]+num[i]).
        //  所以取 A[i] 和 dp[i-1] + nums 中的最大值: max(dp[i - 1] + nums[i] , nums[i])
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        //找出数组dp中的最大值
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > dp[k]) k = i;
        }
        return dp[k];
    }

}
