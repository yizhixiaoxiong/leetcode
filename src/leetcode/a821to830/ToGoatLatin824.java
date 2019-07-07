package leetcode.a821to830;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description :    山羊拉丁文
 * <p>
 * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 * 例如，单词"apple"变为"applema"。
 * <p>
 * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词"goat"变为"oatgma"。
 * <p>
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 * <p>
 * 返回将 S 转换为山羊拉丁文后的句子。
 * <p>
 * 实例1:
 * 输入: "I speak Goat Latin"
 * 输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * <p>
 * 实例2:
 * 输入: "The quick brown fox jumped over the lazy dog"
 * 输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa
 * overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/7 16:44
 * @Product_Name : leetcode
 */
public class ToGoatLatin824 {
    public static void main(String[] args) {
//        String str = "I speak Goat Latin";
        String str = "The quick brown fox jumped over the lazy dog";
        System.out.println(toGoatLatin(str));

    }
    //元音音字:'a''e''i''o''u''A''E''I''O''U'
    public static String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        //分割单词
        String[] strs = S.split(" ");
        for (int i = 0; i < strs.length; i++) {
            //如果是元音字符
            if (isVowel(strs[i].charAt(0))){
                String suffix = suffix(i);
                sb.append(strs[i]+"ma"+ suffix + " ");
            }else{
                strs[i] = strs[i].substring(1, strs[i].length())+strs[i].charAt(0);
                String suffix = suffix(i);
                sb.append(strs[i]+"ma"+suffix+" ");
            }

        }
        return sb.toString().trim();
    }
    public static boolean isVowel(char c) {
        Set<Character> set = new HashSet<>();
        Character[] chars = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Collections.addAll(set, chars);
        if (set.contains(c)){
            return true;
        }

        return false;
    }

    public static String suffix(int n){
        StringBuilder sb = new StringBuilder();
        while (n > -1){
            sb.append("a");
            n--;
        }
        return sb.toString();
    }
}
