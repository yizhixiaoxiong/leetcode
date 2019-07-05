package leetcode.a541to550;

/**
 * @Description :反转字符串 II
 * <p>
 * 给定一个字符串和一个整数 k，你需要对从字符串开头
 * 算起的每个 2k 个字符的前k个字符进行反转。如果剩余少
 * 于 k 个字符，则将剩余的所有全部反转。如果有小于 2k
 * 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余
 * 的字符保持原样。
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * <p>
 * 给定的k和字符串长度在[1,10000]之间
 *
 * </p>
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/4 20:24
 * @Product_Name : leetcode
 */
public class ReverseStr541 {
    public static void main(String[] args) {
//        String str = "abcdefg";
//        int k = 2;
        String str = "abcdefghigk";
        int k = 4;
        System.out.println(reverseStr1(str, k));
    }

    //1.反转每2k 个字符中的前k个
    //2.如果剩余小于k,反转剩余的全部
    //3.如果剩余的大于k小于2k,则反转前k个,其余不变

    public static String reverseStr(String s, int k) {

        int len = s.length();
        //取得是含有多少个2k
        int n = len / (2 * k);
        //剩余的字符
        int m = len % (2 * k);
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            //反转前k个字符,其余不变
            if ((m < (2 * k)) && m >= k) {
                sb.append(reversal(s.substring(0, k)));
                sb.append(s.substring(k, s.length()));
            } else if (m < k) {  //剩余小于k个
                sb.append(reversal(s.substring(0, s.length())));
            }
            return sb.toString();
        }

        // n为2k的倍数.
        // n=0,长度小于2k,再看m
        // n=1,长度大于等于2k,0~k
        // n=2,长度大于等于4k,0~k,2k~3k
        // n=3,长度大于等于6k,0~k,2k~3k,4k-5k
        // n=4,长度大于等于8k,0~k,2k~3k,4k-5k,6k~7k

        for (int i = 1; i <= n; i++) {
            //追加反转的
            sb.append(reversal(s.substring((i - 1) * 2 * k, (i - 1) * 2 * k + k)));
            //追加不反转的
            sb.append(s.substring((i - 1) * 2 * k + k, (i - 1) * 2 * k + 2 * k));
        }
        if (m < k) {//有余数但小于k 全部反转
            sb.append(reversal(s.substring((n - 1) * 2 * k + 2 * k, s.length())));
        } else {  //大于等于k 小于2k 前k个
            //追加反转
            sb.append(reversal(s.substring((n - 1) * 2 * k + 2 * k, (n - 1) * 2 * k + 2 * k + k)));
            //追加不反转的
            sb.append(s.substring((n - 1) * 2 * k + 2 * k + k, s.length()));
        }
        return sb.toString();
    }

    //反转字符串
    private static String reversal(String str) {
        char tmp = ' ';
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length() / 2; i++) {
            tmp = chars[i];
            chars[i] = chars[str.length() - i - 1];
            chars[str.length() - i - 1] = tmp;
        }

        return new String(chars);
    }


    //循环找到应该反转的区间，周期为2*k
    public static String reverseStr1(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i = i + 2 * k) {
            //i 以每个 2*k 的周期循环
            // i + k - 1 小于s.length,说明剩余的大于 k，将前k个反转
            if ((i + k - 1) < s.length()) {
                reverse(chars, i, i + k - 1);
            } else {
                //剩余的都小于k，全部反转
                reverse(chars, i, s.length() - 1);
            }
        }

        return String.valueOf(chars);
    }


    private static void reverse(char[] chars,
                                int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }


}
