package leetcode.a121to130;

/**
 * @Description : 回文串
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/1 9:09
 * @Product_Name : leetcode
 */
public class IsPalindrom125 {

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "race e car";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
    }

    //回文串,双指针
    public static boolean isPalindrome(String s) {
        if (s.equals(" ") || s.length() == 0 || s.length() == 1) {
            return true;
        }
        //将字符串的中字母全部转换成小写
        s = s.toLowerCase();

        char[] chars = s.toCharArray();
        int k = s.length() - 1;
        for (int i = 0; i < k; i++) {
            if (i == k) {
                break;
            }

            if ((chars[i] < '0' || chars[i] > 'z') || (chars[i] > '9' && chars[i] < 'a')) {
                continue;
            }

            if ((chars[k] < '0' || chars[k] > 'z') || (chars[k] > '9' && chars[k] < 'a')) {
                k--;
                i--;
                continue;
            }

            if (chars[i] != chars[k]) {
                return false;
            }
            k--;
        }
        return true;
    }
}
