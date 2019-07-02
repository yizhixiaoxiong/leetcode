package leetcode.a381to390;

/**
 * @Description : 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)
 * 字符串，\判断第一个字符串ransom能不能由第二个字符串magazines
 * 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * 实质上： 就是统计 magazines 的字符串中的字符是不是包含了ransom的所有字符
 * 第一: 不计顺序
 * 第二：每个字符只能用一次
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/2 11:58
 * @Product_Name : leetcode
 */
public class CanConstruct383 {

    public static void main(String[] args) {
//        String ransomNote = "aa";
//        String magazine = "aab";

        String ransomNote = "bjaajgea";
        String magazine =
                "affhiiica b hbdchbidghcci j jbfjfhjeddgggb a jhidhjchiedhdibge a ecffbbbefiab j " +
                        "dh g gihcc e c";

        System.out.println(canConstruct(ransomNote, magazine));
    }

    //总体思路：
    //  1、当 ransomNote 的长度大于 magazine的时候，一定不满足
    //  2、当 ransomNote 的长度小于 magazine的时候：
    //      2.1、用一个数组 magazine 的字符中每个字符出现的次数。然后遍历 ransomNote
    //          在数组中查找对应的字符，如果字符存在，则遍历下一个字符，并在数组中将这
    //          个字符出现的次数减 1 。 如果字符不在数组中,则返回false。全部都在返回true
    public static boolean canConstruct(String ransomNote,
                                       String magazine) {


        if (ransomNote.length() > magazine.length()) return false;

        //用数组统计每个字符出现的次数
        //下标为 (字符 - 'a')
        int[] b = new int[26];

        //统计每个字符在magazine中出现的次数
        for (char c : magazine.toCharArray()) {
            b[c - 'a']++;
        }

        //比对 ransomNote 中的字符是否在magazine中
        for (char c : ransomNote.toCharArray()) {
            //如果 ransomNote 不在 数字b中，返回false
            if (b[c - 'a'] == 0) {
                return false;
            }
            //ransomNote 在数组b中存在，将b中的这个字符次数 减 1.
            b[c - 'a']--;
        }

        return true;
    }


    //双指针
    //这里统计了顺序，错误解法
//    public static boolean canConstruct(String ransomNote,
//                                String magazine) {
//        if (ransomNote.length() == 0 || ransomNote.equals(" ")){
//            return true;
//        }
//        if (ransomNote.length() > magazine.length()){
//            return false;
//        }
//        int f = 0;
//        int l = 0;
//        while (f <= ransomNote.length()-1 ){
//            if (l > magazine.length()-1){
//                return false;
//            }
//            //如果 magazine 的值不等于 ransomNote ，就看
//            // 下一个magazine 的值
//            if (ransomNote.charAt(f) != magazine.charAt(l)){
//                //下一个magazine的值
//                l++;
//                //如果已经是最后一个了，说明不匹配
//                if ( l > magazine.length()-1){
//                    return false;
//                }
//            }else{  //如果 这个值相等，则同时考察下一个
//                f++;
//                l++;
//
//            }
//        }
//        return true;

//}
}
