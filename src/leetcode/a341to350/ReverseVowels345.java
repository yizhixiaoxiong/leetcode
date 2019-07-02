package leetcode.a341to350;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 反转字符串中的元音字母
 * <p>
 * 元音字母 : a e i o u
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/1 11:45
 * @Product_Name : leetcode
 */
public class ReverseVowels345 {

    public static void main(String[] args) {
//        String s = "hello";
//        String s = "leetcode";
        String s = "aA";
//        String s = "race car";
        System.out.println(reverseVowels1(s));
    }


    //双指针
    public static String reverseVowels(String s) {

        if (s.equals(" ") || s.length() == 0 || s.length() == 1) {
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();

        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        map.put('A', 0);
        map.put('E', 0);
        map.put('I', 0);
        map.put('O', 0);
        map.put('U', 0);
        char[] chars = s.toCharArray();
        char tmp = ' ';
        int k = s.length() - 1;
        for (int i = 0; i < k; i++) {
            if (map.containsKey(chars[i])) {
                tmp = chars[i];
                for (int j = k; j >= i; j--) {
                    if (map.containsKey(chars[j])) {
                        //如果元音字符不相等，则交换
                        if (tmp != chars[j]) {
                            chars[i] = chars[j];
                            chars[j] = tmp;
                            k = j;
                            k--;
                            break;
                        } else if (tmp == chars[j]) {
                            k = j;
                            k--;
                            break;
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }


    //使用while 的双指针
    public static String reverseVowels1(String s) {
        char[] chars = s.toCharArray();
        int low = 0;
        int high = s.length() - 1;
        char tmp = ' ';
        while (low <= high) {

            while (low <= high && !isValid(chars[low])) {
                low++;
            }
            while (low <= high && !isValid(chars[high])) {
                high--;
            }

            if (low <= high){
                tmp = chars[low];
                chars[low] = chars[high];
                chars[high] = tmp;
                low++;
                high--;
            }
        }
        return new String(chars);
    }

    public static boolean isValid(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
