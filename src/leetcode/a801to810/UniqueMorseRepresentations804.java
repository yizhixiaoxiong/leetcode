package leetcode.a801to810;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description :唯一摩尔斯密码词
 * <p>
 * 给定一个单词列表，每个单词可以写成每个字
 * 母对应摩尔斯密码的组合。例如，"cab" 可以
 * 写成 "-.-..--..."，(即 "-.-." + "-..."
 * + ".-"字符串的结合)。我们将这样一个连接过
 * 程称作单词翻译。
 * 返回我们可以获得所有词不同单词翻译的数量。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/7 17:35
 * @Product_Name : leetcode
 */
public class UniqueMorseRepresentations804 {

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }

    //用字符 - 'a' 来在morse数组中查找对应的字符的摩斯
    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-."
                , "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "" +
                "..-", "...-", ".--", "-..-", "-.--", "--.."};

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                sb.append(morse[chars[j] - 'a']);
            }
            //没循环一次加入到set中,因为set集合不重复的特性
            //所以set集合的长度就是 不同的翻译个数
            set.add(sb.toString());
        }
        return set.size();
    }
}
