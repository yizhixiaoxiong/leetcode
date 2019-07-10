package leetcode.a891to900;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description : 特殊等价字符串组
 * 你将得到一个字符串数组 A。
 * <p>
 * 示例 1：
 * 输入：["abc","acb","bac","bca","cab","cba"]
 * 输出：3
 * 解释：3 组 ["abc","cba"]，["acb","bca"]，["bac","cab"]
 *
 * <p>
 * 1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * 所有 A[i] 都具有相同的长度。
 * 所有 A[i] 都只由小写字母组成。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/7 23:33
 * @Product_Name : leetcode
 */
public class NumSpecialEquivGroups893 {

    public static void main(String[] args) {
        String[] A = {"abc", "acb", "bac", "bca", "cab", "cba"};
        System.out.println(numSpecialEquivGroups(A));
    }

    //两个条件：
    //1.特殊字符必须是具有相同的元素，而且每个元素个数相同
    //2.相互移动的字符是下表为偶数或者下标为奇数之间，奇偶之间不能相互移动
    public static int numSpecialEquivGroups(String[] A) {
        //每个字符串的长度都是相同的
        //两个字符串分成奇偶，判断奇数和偶数的字符以及相同字符的数量是否相等
        //如："abcd" 、 "acbd" 、"adcb"统计奇偶分别是
        //1."abcd"： 偶数字符： a(1) c(1)  奇数字符：b(1),d(1)
        //2."acbd":  偶数字符： a(1) b(1)  奇数字符：c(1),d(1)
        //3."abcd"： 偶数字符： a(1) c(1)  奇数字符：b(1),d(1)
        //所以1和3是一组

        //使用set是为了排重
        Set<String> set = new HashSet<>();
        //数组长度为52
        //前26个统计偶数位字符出现的次数。
        //后26个字符统计奇数位字符出现的次数
        //下标为 每个字符串中字符 - 'a' 之后的位置
        //值为出现的次数
        for (String s : A) {
            int[] count = new int[52];
            //将字符串分成
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a' + 26 * (i % 2)]++;  //奇数和偶数分开
            }
            //每个count是一个单独的字符串,如果相等。则是同一组
            set.add(Arrays.toString(count));
        }
        return set.size();
    }
}
