package leetcode.a811to820;

import java.util.*;

/**
 * @Description : 最常见的单词
 * <p>
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。
 * 返回出现次数最多，同时不在禁用列表中的单词。题目保证至少
 * 有一个词不在禁用列表中，而且答案唯一。
 * <p>
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单
 * 词不区分大小写。答案都是小写字母。
 * <p>
 * 示例：
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/7 15:38
 * @Product_Name : leetcode
 */
public class MostCommonWord819 {

    public static void main(String[] args) {
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit! ";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
    }

    //在字符串中寻找一个出现最多的子串
    //   条件：子串不再禁用列表中
    //   答案是小写字母

    public static String mostCommonWord(String paragraph, String[] banned) {
        //转换成小写
        paragraph = paragraph.toLowerCase();
        char[] chars = paragraph.toCharArray();
        //将段落中不是字母的字符替换成空格
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 97 || chars[i] > 122){
                chars[i] = ' ';
            }
        }
        String str = String.valueOf(chars);
        String[] strs = str.trim().split(" ");
        Map<String ,Integer> strMap = new HashMap<>();
        toMap(strMap,banned,strs);
        //循环strMap找到value最大的值
        String result = " ";
        int count = 0;
        Iterator<Map.Entry<String ,Integer>> iterator = strMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> it = iterator.next();
            if (count < it.getValue()){
                count = it.getValue();
                result = it.getKey();
            }
        }
        return result;
    }
    public static void toMap(Map<String , Integer> strMap,String[] banned,String[] strs){
        //坏单词set.
        //也可以用map但是速度没有set快
        Set<String> set = new HashSet<>();
        Collections.addAll(set, banned);
        for (String s : strs) {
            if (s.equals(" ") || s.equals("")){
                continue;
            }
            //不在坏单词中
            if (!set.contains(s)){
                //已经才好单词中，则次数+1
                if (strMap.containsKey(s)){
                    Integer integer = strMap.get(s);
                    strMap.put(s, integer+1);
                }else {
                    //放入好单词中不存在,则放入好单词中次数初始化为1
                    strMap.put(s, 1);
                }
            }
        }

    }
}
