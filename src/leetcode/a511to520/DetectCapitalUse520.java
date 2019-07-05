package leetcode.a511to520;

/**
 * @Description : 检测大写字母
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * <p>
 * 即：
 * 1.字母都是大写字母或是小写字母
 * 2.如果第一个是大写字母，则后一个都不能是大写字母
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/3 21:42
 * @Product_Name : leetcode
 */
public class DetectCapitalUse520 {

    public static void main(String[] args) {
//        String word = "USA";
        String word = "Flag";
        System.out.println(detectCapitalUse(word));
    }

    //1.字母都是大写字母或是小写字母 则正确
    //2.如果第一个是大写字母，则后一个都不能是大写字母
    //'a'-'z' 是 97 - 122
    //'A'-'Z' 是 65-90
    public static boolean detectCapitalUse(String word) {

        if (word.length() == 1){
            return true;
        }

        char[] chars = word.toCharArray();
        char first = chars[0];
        char sencod = chars[1];

        //如果第一个字符在'A'-'Z'之间
        if (first >= 65 && first <= 90) {
            //第二个字符在'A'-'Z'之间
            if (sencod >= 65 && sencod <= 90) {
                for (int i = 2; i < chars.length; i++) {
                    //如果之后的字母不在'A' - 'Z'
                    if (chars[i] < 65 || chars[i] >90) {
                        return false;
                    }
                }
                //如果第二个字符是小写'a' - 'z'
            }else if(sencod >= 97 && sencod <= 122){
                for (int i = 2; i < chars.length; i++) {
                    //如果之后的字母都不在'a'-'z'
                    if (chars[i] < 97 || chars[i] > 122){
                        return false;
                    }
                }
            }
        }else if(first >=97 && first <= 122){ //如果第一个字符是小写
            //全部必须是小写
            for (int i = 1; i < chars.length; i++) {
                //如果往后的字母不在'a' - 'z' 之间，则false
                if (chars[i] < 97 || chars[i] > 122) {
                    return false;
                }
            }
        }
        return true;
    }

}
