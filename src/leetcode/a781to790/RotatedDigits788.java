package leetcode.a781to790;

/**
 * @Description : 旋转数字
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地
 * 被旋转 180 度后，我们仍可以得到一个有效的，且
 * 和 X 不同的数。要求每位数字都要被旋转。
 * <p>
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 
 * 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们
 * 自己；2 和 5 可以互相旋转成对方；6 和 9 同理，除
 * 了这些以外其他的数字旋转以后都不再是有效的数字。
 * <p>
 * 例1：
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/7 13:02
 * @Product_Name : leetcode
 */
public class RotatedDigits788 {
    public static void main(String[] args) {
        int N = 500;
        System.out.println("\n共有："+rotatedDigits(N)+"个");
    }

    //0.1.8旋转后是它自己
    //2和5.6和9 是相互转化
    //3.4.7则是无效
    //1到N中有多少个X数十好数
    //满足好数的条件：
    // 1、不存在 3.4.7这种数字。
    // 2、不能全部0.1.8这样的数字
    // 3、
    public static int rotatedDigits(int N) {
        //统计多少好数
        int count = 0;
//        int[] nums = new int[N];
//        int index = 0;

        for (int i = 1; i <= N; i++) {
            String str = String.valueOf(i);

            int k = 0;  //下标
            int num = 0;    //统计每个数字0.1.8的总个数
            while (k < str.length()){
                if (str.charAt(k) == '3' || str.charAt(k) == '4' || str.charAt(k) == '7'){
                    break;
                }else if (str.charAt(k) == '0' || str.charAt(k) == '1' || str.charAt(k) == '8'){
                    num++;
                    k++;
                    if (k == str.length()){  //已经到了末尾
                        //说明不都是0.1.8,则是有效数字
                        if (num != str.length()){
//                            nums[index++] = i;
                            count++;
                        }
                    }
                }else {
                    k++;
                    if (k == str.length()){
//                        nums[index++] = i ;
                        count++;
                    }
                }
            }

        }
//        System.out.println("好数字有:");
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i]+",");
//        }


        return count;
    }

    //第二种方法：将使用 N % 10 和 N / 10 来确定每一个数字
    //           的位数是否是想要的位数

}
