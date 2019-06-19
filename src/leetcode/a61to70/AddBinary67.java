package leetcode.a61to70;

import java.util.Calendar;

/**
 * @Description :
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/19 12:31
 * @Product_Name : leetcode
 */
public class AddBinary67 {

    public static void main(String[] args) {
        String a = "1111";
        String b = "1111";
        String result = addBinary(a, b);

        System.out.println(result);
    }

    public static String addBinary(String a, String b) {

        //初始想法，判断两个字符串的长短，然后循环短的次数
        //定位下标k，之后判断k的位置是否会进1.再处理剩余部分

        StringBuilder sb = new StringBuilder();

        int n = a.length();
        int m = b.length();
        if (n >= m) {
            for (int i = 0; i < n - m; i++) {
                sb.append(0);
            }
            sb.append(b);
            b = sb.toString();
            sb = new StringBuilder();
        } else {
            for (int i = 0; i < m - n; i++) {
                sb.append(0);
            }
            sb.append(a);
            a = sb.toString();
            sb = new StringBuilder();
        }

        int up = 0;
        for (int i = Math.max(m, n) - 1; i >= 0 ; i--) {
            int cha = a.charAt(i) - '0';
            int chb = b.charAt(i) - '0';
            if (cha + chb + up < 2) {
                sb.append(cha + chb +up);
                up = 0;
            }else{
                sb.append((cha+chb +up)%2);
                up = 1;
            }
        }
        if (up == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

}
