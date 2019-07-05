package leetcode.a511to520;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description : 最长特殊序列 II
 * 给定字符串列表，你需要从它们中找出最长的特殊序列。
 * 最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * <p>
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余
 * 字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 * <p>
 * 输入将是一个字符串列表，输出是最长特殊序列的长度。
 * 如果最长特殊序列不存在，返回 -1
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/4 12:14
 * @Product_Name : leetcode
 */
public class FindLUSlength522 {

    public static void main(String[] args) {
//        String[] strs = {"aaa", "aaa", "aa"};
        String[] strs = {"abc", "bcd", "defd"};
//        String[] strs = {"aba","aba","eae"};
//        String[] strs = {"abc","abc","eae"};
//        String[] strs = {"aabbcc", "aabbcc", "cb"};
        System.out.println(findLUSlength1(strs));
    }
    //最长特殊序列是自己特有而其他字符串没有的子序列
    //如果两个字符串相等 则返回-1 .不相等返回最长的

    //因为是字符数组，会存在有两个字符串相等的情况，这时候需要去重
    //如果去重之后的数组只有一个，则说明整个字符串数组全部相同
    //如果不同，则取最长的


    //所需操作:1.字符数组去重.（重复的字符串不能选）2.去重之后的元素比较。3.用一个变量记录最长特殊子串
    public static int findLUSlength(String[] strs) {

        //key为字符数组的元素。 value 对应字符元素出现的次数
        Map<String, Integer> map = new HashMap<>();
        //存储没有相同字符串
        String[] copy = new String[strs.length];
        //不重复字符串的下标
        int k = 0;
        //最长特殊序列的长度
        int len = -1;
        //获得去重的map集合
        map = delRepeat(strs);
        //如果map的长度等于 strs 数组的长度，说明不存在重复的字符串，可取最长
        if (map.size() == strs.length) {
            for (int i = 0; i < strs.length; i++) {
                len = Math.max(len, strs[i].length());
            }
            return len;
        }
        //遍历map,将重复字符串和不重复字符串分开
        //copy数组里面是不重复的字符串，而map中是重复的字符串
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> it = iter.next();
            if (it.getValue() == 1) {
                copy[k++] = it.getKey();
                iter.remove();
            }
        }
        //先遍历值不存在重复的字符串，判断是否是重复字符串的子集
        for (int j = 0; j < k; j++) {
            Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> it = iterator.next();
                //获取字符串，如果是子串，则选择下一个
                String str = it.getKey();
                if (isSubString(str, copy[j])) {//如果是子串
                    break;
                }
                //都循环完了发现不是map中所有字符的子串则取这个字符串的长度和之前的比对选择最大的
                if (!iterator.hasNext()) {
                    len = Math.max(len, copy[j].length());
//                        len = len < copy[i].length() ?copy[i].length():len;
                }
            }
        }
        return len;
    }

    //将strs去重
    public static Map delRepeat(String[] strs) {
        //key 为字符串, value 为字符串出现的次数,默认为1
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            //如果map中存在这个字符串了,则次数+1。
            if (map.containsKey(strs[i])) {
                map.put(strs[i], map.get(strs[i]) + 1);
                continue;
            } else {
                map.put(strs[i], 1);
            }
        }
        return map;
    }

    //判断是否顺序子串
    //前提：mainStr 和 subString 不相等
    private static boolean isSubString(String mainStr, String subString) {
        //如果子串大于主串
        if (mainStr.length() < subString.length()) {
            return false;
        }
        //记录主串指针
        int k = 0;
        for (int i = 0; i < subString.length(); i++) {
            //如果子串剩余的长度大于主串，则说明不是子串
            if (subString.substring(i, subString.length()).length() > mainStr.substring(k,
                    mainStr.length()).length()) {
                return false;
            }
            for (int j = k; j < mainStr.length(); j++) {
                //找到等值的进行下一次循环
                if (subString.charAt(i) == mainStr.charAt(j)) {
                    k = j + 1;  //记录当前指针
                    break;
                } else {  //如果一直没找到，则k
                    k++;
                    if (k == mainStr.length()) {  //说明循环到最后一个也不相等，返回false
                        return false;
                    }
                }
            }
        }
        return true;
    }


    //第二种方法,化繁为简
    //  暴力匹配,使用双循环来匹配每个串和其它串的
    //  最长特殊序列
    public static int findLUSlength1(String[] strs) {
        int longest = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean isSub = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isSub = false;
                    break;
                }
            }
            if (isSub) longest = Math.max(longest, strs[i].length());
        }
        return longest;
    }

    //判断 a 是否是 b 的子串
    public static boolean isSubsequence(String a, String b) {
        if (a.length() > b.length()) return false;
        if (a.equals(b)) return true;

        int position = 0;

        for (int i = 0; i < b.length(); i++) {
            if (position == a.length()) break;
            if (a.charAt(position) == b.charAt(i)) {
                position++;
            }
        }
        return position == a.length();
    }
}
