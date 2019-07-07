package leetcode.a681to690;

/**
 * @Description : 重复叠加字符串匹配
 * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，
 * 使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1
 * <p>
 * 举个例子，A = "abcd"，B = "cdabcdab"。
 * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时
 * B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
 * <p>
 * A 与 B 字符串的长度在1和10000区间范围内。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/6 10:27
 * @Product_Name : leetcode
 */
public class RepeatedStringMatch686 {

    public static void main(String[] args) {
//        String A = "aaabbaa";
//        String B = "aabbaaaaabbaa";
//        String A = "aaaaa";
//        String B = "aaaaaaaaa";
//        String A = "abcd";
//        String B = "cdabcdab";
        String A ="a";
        String B = "aa";

//          String A = "abc";
//          String B = "cabcabca";

        System.out.println(repeatedStringMatch(A, B));
    }


    //字符串 B 是 字符串A * k的 子串
    //求 k

    public static int repeatedStringMatch(String A, String B) {
        //最大的情况
        int max = 2+ B.length()/A.length();
        //求B/A 的商，如果B/A 不等于0.说明B比A 的一倍大否则B没有A 的一倍大
        int n = B.length()/A.length() == 0 ? 1:B.length()/A.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=n ; i++) {
            sb.append(A);
        }
        while ( n <= max){
            if (sb.indexOf(B) > -1){
                return n;
            }else{
                sb.append(A);
                n++;
            }
        }
        return -1;
    }

    public static int repeatedStringMatch1(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        //求商
        int k = lenB / lenA;
        String newA = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= k; i++) {
            sb.append(A);
        }

        if (sb.length() < B.length()){
            sb.append(A);
            k++;
        }
        newA = sb.toString();
        //A中有B
        if (newA.indexOf(B) != -1) {
            return k;
        }else {
            sb.append(A);
            newA = sb.toString();
            if (newA.indexOf(B) != -1) {
                return k + 1;
            }
        }
        return -1;
    }
}
