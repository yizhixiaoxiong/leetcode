package leetcode.a381to390;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 字符串中的第一个唯一字符
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/2 18:18
 * @Product_Name : leetcode
 */
public class FirstUniqChar387 {

    public static void main(String[] args) {
//        String s = "leetcode";
//        String s = "loveleetcode";
//        String s = "cc";
//        String s = "dacca";
        String s = "itwqbtcdprfsuprkrjkausiterybzncbmdvkgljxuekizvaivszowqtmrttiihervpncztuoljftlxybpgwnjb";
        System.out.println(firstUniqChar2(s));
    }

    //用map
    public static int firstUniqChar(String s) {
        if (s.length() == 0 || s.equals(" ")) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //如果以及存在了这个字符
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i + s.length());
            } else {
                map.put(s.charAt(i), i);
            }
        }
        int k = Integer.MAX_VALUE;
        //查找map中 值最小的
        for (Character c : map.keySet()) {
            Integer index = map.get(c);
            //取最小值
            if (k > index && index <= s.length()) {
                k = index;
            }
        }
        //如果k的值大于整个数组，则返回-1
        if (k >= s.length()) {
            k = -1;
        }
        return k;
    }

    //用数组
    public static int firstUniqChar1(String s) {
        int[] b = new int[26];
        for (char c : s.toCharArray()) {
            b[c - 'a']++;
        }
        int k = Integer.MAX_VALUE;
        for (int i = 0; i < b.length; i++) {
            if (b[i] == 1) {
                //找到出现次数为1 字符，返回下标
                 int index = s.indexOf((char) ('a' + i));
                //找到最小值k
                if (k > index) {
                    k = index;
                }
            }
        }
        if (k > s.length()-1){
            return -1;
        }
        return k;
    }

    //使用String 库
    //indexOf() 和 lastIndexOf() 对比
    public static int firstUniqChar2(String s){

        int index = -1;
        for (char i = 'a'; i <= 'z'; i++) {

            int beginIndex = s.indexOf(i);

            //如果这个字符在字符串中只存在一个
            if (beginIndex != -1 && beginIndex == s.lastIndexOf(i)){
                //index 是下标最小的那个
                index = (index == -1 || index > beginIndex) ? beginIndex : index;
            }
        }
        return index;

    }
}
