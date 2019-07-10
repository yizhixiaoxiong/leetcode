package leetcode.a1071to1080;



import java.util.*;

/**
 * @Description : 字符串的最大公因子
 * <p>
 * 对于字符串 S 和 T，只有在 S = T + ... + T
 * （T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * <p>
 * 返回字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * <p>
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/10 20:03
 * @Product_Name : leetcode
 */
public class GcdOfStrings1071 {

    public static void main(String[] args) {
//        String str1 = "ABCABCABCABC";
//        String str2 = "ABCABC";
        String str2 = "AAAAA";
        String str1 = "AAAAA";
//        String str2 = "LEET";
//        String str1 = "CODE";
//

        System.out.println(gcdOfStrings(str1, str2));
    }


    //求得X 既能被S整除，也能被T整除
    //也即是 X 是最大公因子
    //分析：
    //  只可能出现长度小的字符串，最长为它自己
    //  寻找长度最小的字符串，求他的所有子串
    public static String gcdOfStrings(String str1, String str2) {
        //如果str1和str2 由同一个字母构成
        //由于子串重复，所以子串存在于字符串的前半部分以及它本身。

        Map<Integer, String> map = new HashMap<>();
        map.put(str1.length(), str1);
        //假设除了他本身的子串周期为t
        int t = str1.length() / 2;
        for (int i = t; i > 0; i--) {
            //被整除才可能使周期串
            if (str1.length() % i == 0) {
                boolean isRight = true;
                int n = str1.length() / i;
                for (int j = 1; j < n; j++) {      //次数
                    int k = 0;
                    boolean notT = true;
                    for (int l = 0; l < i; l++) {   //周期比较
                        //说明这个t不符合
                        if (str1.charAt(k) != str1.charAt(j * i + l)) {
                            notT = false;
                            break;
                        } else {
                            k++;
                        }
                    }
                    //flag == false  t不符合
                    if (!notT) {
                        isRight = false;
                        break;
                    }
                }
                //符合
                //保存子串和子串长度
                if (isRight) {
                    map.put(i, str1.substring(0, i));
                }

            }
        }
        //已经获取了子串
        //匹配另一个
        t = Integer.MIN_VALUE;
        for (Map.Entry<Integer, String> m : map.entrySet()) {
            //周期
            int k = 0;
            Integer t1 = m.getKey();
            //能被整除的周期才是有可能的周期
            if (str2.length() % t1 == 0) {
                int n = str2.length() / t1;  //次数
                boolean isRight = true;
                for (int i = 0; i <= n-1; i++) {
                    boolean notT = true;
                    k = 0;
                    for (int j = 0; j < t1; j++) {
                        //不匹配
                        if (m.getValue().charAt(k) != str2.charAt(t1 * i + j)){
                            notT = false;
                            break;
                        }else{
                            k++;
                        }
                    }
                    //如果不匹配
                    if (!notT){
                        isRight =false;
                        break;
                    }

                }
                //匹配
                if (isRight){
                    t = Math.max(t, m.getKey());
                }
            }

        }
        if (t == Integer.MIN_VALUE){
            return "";
        }
        return map.get(t);
    }
}
