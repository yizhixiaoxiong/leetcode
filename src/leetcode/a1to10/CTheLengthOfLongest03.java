package leetcode.a1to10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description :
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串的长度。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/12 8:15
 * @Product_Name : Algorithm
 */
public class CTheLengthOfLongest03 {

    public static void main(String[] args) {
        String s = "bbbbbb";
        String l = " ";
//        System.out.println(s.equals(l));
        System.out.println(longest(s));
    }

    public static int longest(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int index = 0;
        int maxNum = 0;
        int tmpNum = 0;
        if (s.equals("")) {
            return ++maxNum;
        }
        String a = s.substring(index, index + 1);
        map.put(a, index);
        tmpNum = 1;
        while (a != null) {
            index++;
            try {
                a = s.substring(index, index + 1);
            } catch (Exception e) {
                a = null;
                return maxNum > tmpNum ? maxNum : tmpNum;
            }
            if (!map.containsKey(a)) {
                tmpNum++;
                map.put(a, index);
            } else {
                if (maxNum < tmpNum) {
                    maxNum = tmpNum;
                }
                //删除在出现第一个a之前的元素
                Integer integer = map.get(a);
                Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, Integer> entry = it.next();
                    if (entry.getValue() <= integer) {
                        it.remove();
                    }
                }
                tmpNum = index - integer;
                map.put(a, index);
            }

        }
        maxNum = maxNum > tmpNum ? maxNum : tmpNum;
        return maxNum;

    }

}
