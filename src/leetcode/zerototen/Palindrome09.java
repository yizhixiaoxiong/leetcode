package leetcode.zerototen;

/**
 * @Description : 回文数
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/14 19:11
 * @Product_Name : leetcode
 */
public class Palindrome09 {

    public static void main(String[] args) {
        int x = 11;
        System.out.println(isPalindrome2(x));

    }

    //转换成字符串模式
    public static boolean isPalindrome(int x){
        if (x<0 || x %10 ==0 &&  x!=0) return false;
        if (x<10) return true;
        String s = String.valueOf(x);
        int n = s.length();
        for (int i = 0; i <= n/2; i++) {
            if (!s.substring(i, i+1).equals(s.substring(n-i-1, n-i))){
                return false;
            }
        }
        return true;
    }

    //不转换成字符串模式，从尾部去摸组合数和前一半比较
    public static boolean isPalindrome2(int x){

        if (x<0 || x%10 == 0 && x!=0){
            return false;
        }
        if (x<10){
            return true;
        }
        int result = 0;
        //反转数字比大小
        while (x > result){
            int a = x%10;
            result = result*10 + a;
            if(result == x){
                return true;
            }
            x = x/10;
        }
        return result == x;
    }
}
