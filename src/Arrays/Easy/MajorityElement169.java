package Arrays.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 求众数
 * <p>
 * 给定一个大小为 n 的数组，找到其中的众数。
 * 众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/16 19:09
 * @Product_Name : leetcode
 */
public class MajorityElement169 {

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println( majorityElement(nums));


    }

    //数组非空，众数始终存在
    public static int majorityElement(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                Integer integer = map.get(nums[i]);
                if ((integer + 1) > n / 2) {
                    return nums[i];
                }
                map.put(nums[i], integer + 1);
            }
        }

        return -1;
    }
}
