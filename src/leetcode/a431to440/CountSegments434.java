package leetcode.a431to440;

/**
 * @Description : 字符串中的单词数
 *                统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/3 1:27
 * @Product_Name : leetcode
 */
public class CountSegments434 {

    public static void main(String[] args) {
        String s = ", , , ,        a, eaefa";
        System.out.println(countSegments(s));
    }


    public static int countSegments(String s) {

        if (s.length() == 0 || s.equals("")){
            return 0;
        }
        int count = 0;  //单词数量
        s = s.trim();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            //不是空格
            if (s.charAt(i) != ' ') {
                length++;
                continue;
            }else{
                if (length == 0) continue;
                count++;
                length = 0;
            }
        }
        if (length != 0 ) count++;
        return count;
    }

}
