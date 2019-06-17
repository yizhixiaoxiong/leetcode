package leetcode.a21to30;

/**
 * @Description : 删除数组重复的数据，返回新数组的长度
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/17 20:43
 * @Product_Name : leetcode
 */
public class RemoveDuplicates26 {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        int[] nums = {};
//        int[] nums = {1};
        int[] nums = {1,1,1,1,1,1};

        System.out.println(removeDuplicates(nums));

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        //快排去最后一个数字
        int n = nums.length;
        int k = 0;
        for (int i = 1; i < n; i++) {
            if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
            }
        }
        return k+1;
    }
}

