package leetcode.a21to30;

/**
 * @Description : leetcode27 题 删除数组中和给定值相等的数据，然后重组数组。
 * <p>
 * 难度：简单
 *                 要求：不能使用额外数组
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/17 21:42
 * @Product_Name : leetcode
 */
public class RemoveElement27 {

    public static void main(String[] args) {
//        int[] nums = {3, 2, 2, 3};
//        int[] nums = {0,1,2,2,3,0,4,2};
        int[] nums = {1};

//        int val = 3;
//        int val = 2;

        int val = 1;

        int n = removeElement(nums, val);

        System.out.println("剩余数组个数为：" + n);

        System.out.print("剩余数组的值为：");
        for (int i = 0; i < n; i++) {
            System.out.print( nums[i] + ",");
        }

    }

    public static int removeElement(int[] nums, int val) {

        if (nums.length == 0) return 0;
        int n = nums.length;
        int k = 0;              //慢指针

        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;

    }
}
