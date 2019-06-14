package leetcode.a1to10;

/**
 * @Description : 整数反转
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/14 7:58
 * @Product_Name : leetcode
 */
public class Reverse07 {

    public static void main(String[] args) {
        int x = 1124500678;
        int reserse = reserse2(x);
        System.out.println(reserse);
    }

    public static int reserse(int x) {
        int minValue = Integer.MIN_VALUE;
        int maxValue = Integer.MAX_VALUE;
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        char[] tmp = new char[chars.length];
        char[] result = new char[tmp.length];
        for (int i = chars.length - 1; i >= 0; --i) {
            tmp[chars.length - 1 - i] = chars[i];
        }
        if (tmp[chars.length - 1] == '-') {     //负数
            result[0] = tmp[chars.length - 1];
            for (int i = 1; i <= tmp.length - 1; i++) {
                result[i] = tmp[i - 1];
            }
        } else {                              //正数
            for (int i = 0; i <= tmp.length - 1; i++) {
                result[i] = tmp[i];
            }
        }
        String str = String.valueOf(result).trim();
        long b = (long) Long.parseLong(str);
        if (b > maxValue || b < minValue) {
            return 0;
        }
        return (int) b;
    }

    public static int reserse2(int x){

        long result = 0;
        while (x != 0){
            int a = x%10;
            result = result*10 + a;
            x = x/10;
        }
        if (result > Integer.MAX_VALUE || result<Integer.MIN_VALUE){
            return 0;
        }else{
            return (int)result;
        }
    }

}
