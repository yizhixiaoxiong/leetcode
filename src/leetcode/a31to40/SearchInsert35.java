package leetcode.a31to40;

/**
 * @Description : 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 *                如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 *              你可以假设数组中无重复元素。
 *
 *              难度：简单
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/17 22:52
 * @Product_Name : leetcode
 */
public class SearchInsert35 {
    public static void main(String[] args) {
        //用例1；
//        int[] nums = {1, 3, 5, 6};
//        int target = 5;
        //用例2：
//        int[] nums = {1,3,5,6};
//        int target = 2;
        //用例3：
//        int[] nums = {1,3,5,6};
//        int target = 7;
        //用例4：
        int[] nums = {1,3,5,6};
        int target = 0;

        System.out.println(searchInsert(nums, target));

    }


    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
}
