package leetcode.a61to70;

/**
 * @Description :
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/18 21:59
 * @Product_Name : leetcode
 */
public class PlusOne66 {
    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 9, 9, 9,};
        int[] result = plusOne(nums);
        System.out.print("输出数组为：[ ");
        for (int num : result) {
            System.out.print(num);
        }
        System.out.println(" ]");
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            int num = digits[i] + 1;
            if (num < 10) {
                digits[i] = num;
                break;
            } else if (num == 10) {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
//            int[] nums = new int[n + 1];
//            nums[0] = 1;
//            for (int i = 0; i < n; i++) {
//                nums[i + 1] = digits[i];
//            }
//            return nums;

            //这里取个巧,因为数据格式是 10000 除了首位都是0，则就将数组初始化并赋值首位即可
            digits = new int[n+ 1 ];
            digits[0] = 1;
            return digits;
        }
        return digits;
    }

}
