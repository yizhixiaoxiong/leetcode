package leetcode.a911to920;

/**
 * @Description :仅仅反转字母
 * * <p>
 * * 给定一个字符串 S，返回 “反转后的” 字符串，其中
 * * 不是字母的字符都保留在原地，而所有字母的位置发生反转
 * * <p>
 * * 提示：
 * * S.length <= 100
 * * 33 <= S[i].ASCIIcode <= 122
 * * S 中不包含 \ or "
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/8 12:45
 * @Product_Name : leetcode
 */
public class ReverseOnlyLetters917 {

    public static void main(String[] args) {
//        String  S = "a-bC-dEf-ghIj";
        String  S = "Test1ng-Leet=code-Q!";
        System.out.println(reverseOnlyLetters(S));

    }

    //不是字符不反转
    //字母范围在 65-90 97-122
    //考虑使用双指针
    //遇见不是字符的就跳过，遇见双方都是字符的，反转
    public  static String reverseOnlyLetters(String S) {
        int n = S.length();
        int end = n - 1;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (end <i){
                break;
            }
            //是字符
            if (chars[i] >= 65 && chars[i] <= 122 && (chars[i] <= 90 || chars[i] >= 97)) {
                while (end > i) {
                    if (chars[end] >= 65 && chars[end] <= 122 && (chars[end] <= 90 || chars[end] >= 97)) {
                        //交换
                        char tmp = chars[i];
                        chars[i] = chars[end];
                        chars[end] = tmp;
                        end--;
                        break;
                    }else{
                        end--;
                    }
                }
            }
        }
        return String.valueOf(chars);
    }
}
