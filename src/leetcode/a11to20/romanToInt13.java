package leetcode.a11to20;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 罗马字符转换
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/15 7:56
 * @Product_Name : leetcode
 */
public class romanToInt13 {
    public static void main(String[] args) {
        String s = "MMMCMXCIX";
        System.out.println(romanToInt(s));
//        String I = "1";
//        System.out.println(Integer.parseInt(I));

    }

    public static int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        int result = 0;
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (  i < n - 1 && map.get(chars[i]) < map.get(chars[i+1])) {
                result = result + (map.get(chars[i+1]) - map.get(chars[i]));
                i = i + 1;
            } else {
                result += map.get(chars[i]);
            }
        }
        return result;

    }
}
