package Arrays.Easy;

/**
 * @Description :  两数之和 II - 输入有序数组
 * <p>
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/16 18:28
 * @Product_Name : leetcode
 */
public class TwoSum167 {

    public static void main(String[] args) {
        int[] numbers = {-1,0};
        int target = -1;
        int[] ints = twoSum1(numbers, target);
        System.out.print("[");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ",");
        }
        System.out.print("]");
    }

    //十相加值等于目标值
    //由于肯定有唯一的答案
    //从第一个双重循环,暴力解决
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                } else if (numbers[i] + numbers[j] > target) {
                    break;
                }
            }
        }
        return result;
    }

    //前-后指针
    //从前和后同时遍历
    //两个值相加 m 如果大于 target ,说明和最小的相加大于target,需要index2--
    //两个值相加 m 如果小于 target ,说明和最大的相加小于target,需要index1--
    //如果相加等于m记录index1和index2的值
    public static int[] twoSum1(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        int[] result = new int[2];

        while (index1 < index2) {
            int m = numbers[index1] + numbers[index2];

            if (m > target) {
                index2--;
            } else if (m < target) {
                index1++;
            }else{
                result[0] = index1+1;
                result[1] = index2+1;
                break;
            }
        }
        return result;
    }

}
