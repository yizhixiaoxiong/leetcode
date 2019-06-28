package leetcode.a81to90;

/**
 * @Description : 合并两个有序数组
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/26 7:31
 * @Product_Name : leetcode
 */
public class Merge88 {

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {4,5,6};

        int m = 3;
        int n = 3;

        merge(num1, m, num2, n);

        for (int i = 0; i < num1.length; i++) {
            System.out.println(num1[i]);
        }
    }

    //因为num1和num2有序，可将num1和num2从后往前比大小,将最大的放入最后的位置
    //也就是 n + m - 1 的位置
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if ( m == 0 ){
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if ( n == 0 ){
            return;
        }

        int k = m; //num1 的指针
        int idx = n; // num2的指针
        int last = m + n - 1;
        while ( last >= 0 ) {
            if (nums1[k - 1] >= nums2[idx - 1]) {    //如果num1的最大值大于等于num2的最大值，则将num1的值放入num1的最后
                nums1[last--] = nums1[k-1];
                k--;
                if (k ==0 ){
                    for (int i = idx-1; i >= 0 ; i--) { //将num2剩余的部分复制到num1
                        nums1[last--] = nums2 [i];
                    }
                }
            }else{
                nums1[last--] = nums2[idx - 1];
                idx--;
                if (idx == 0){
                    for (int i = k-1; i >= 0; i--) {
                        nums1[last--] = nums1[i];
                    }
                }
            }
        }

    }

}
