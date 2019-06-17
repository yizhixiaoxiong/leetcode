package leetcode.a21to30;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 实现类似String indexOf()方法
 *                本例使用的是hash匹配字符串来实现
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/17 22:12
 * @Product_Name : leetcode
 */
public class StrStr28 {

    public static void main(String[] args) {
        String haystack = "abxaecaaf";
        String needle = "af";
        int i = strStr(haystack, needle);
        System.out.println(i);

    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")){
            return 0;
        }
        Map<String,Integer> map = new HashMap<String,Integer>();
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i < n-m + 1 ; i++) {
            map.put(haystack.substring(i, i+m), i);
            if (map.containsKey(needle)){
                return i;
            }
        }

        return -1;

    }
}
