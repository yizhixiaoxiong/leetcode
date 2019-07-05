package leetcode.a411to420;

/**
 * @Description : 字符串相加
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 不能使用任何內建 BigInteger 库
 * 也不能直接将输入的字符串转换为整数形式。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/2 23:24
 * @Product_Name : leetcode
 */
public class AddStrings415 {

    public static void main(String[] args) {
        String num1 = "12999";
        String num2 = "1";
        System.out.println(addStrings(num1, num2));
    }

    //使用 (字符 - '0') 获取数字(高效)
    public static String addStrings1(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int high = 0;
        //循环位数多的字符串，位数少的用0补位
        while (n1 >= 0 || n2 >= 0) {
            int i = n1 < 0 ? 0 : num1.charAt(n1--) - '0';
            int j = n2 < 0 ? 0 : num2.charAt(n2--) - '0';
            int sum = i + j + high;
            high = sum / 10;
            sb.append(sum % 10);
        }
        if (high > 0) {
            sb.append(high);
        }
        return sb.reverse().toString();
    }

    //由于条件限制,考虑每个位数相加
    //满10 进1
    //使用StringBulider 追加字符串
    //位数不确定使用while循环位数少的，记录下标，然后把位数多的截取到
    //StringBulider 中
    public static String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        //高位
        int high = 0;

        int n1 = num1.length();
        int n2 = num2.length();
        //取n1 和 n2 中小的循环
        while (n1 > 0 && n2 > 0) {
            int first = Integer.parseInt(num1.substring(n1 - 1, n1));
            int sencod = Integer.parseInt(num2.substring(n2 - 1, n2));
            int sum = first + sencod + high;
            //对10取模，如果sum大于10 则high为1 如果sum小于10则high为0
            high = sum / 10;
            sb.insert(0, sum % 10);//将低位的数字追加到StringBuilder
            n1--;
            n2--;
        }
        if (high > 0) {  //说明高位需要 +1
            if (n1 > n2) {//num1的位数多
                for (int i = n1; i > 0; i--) {
                    int first = Integer.parseInt(num1.substring(i - 1, i));
                    int sum = first + high;
                    high = sum / 10;
                    sb.insert(0, sum % 10);
                    if (high == 0) { //说明在高位 再 +1了
                        //在i 之前的所有字符串放入 StringBuilder
                        sb.insert(0, num1.substring(0, i - 1));
                        break;
                    }
                }
                if (high == 1) {
                    sb.insert(0, high);
                }
            } else if (n1 < n2) {
                for (int i = n2; i > 0; i--) {
                    int second = Integer.parseInt(num2.substring(i - 1, i));
                    int sum = second + high;
                    high = sum / 10;
                    sb.insert(0, sum % 10);
                    if (high == 0) { //说明在高位 再 +1了
                        //在i 之前的所有字符串放入 StringBuilder
                        sb.insert(0, num2.substring(0, i - 1));
                        break;
                    }
                }
                if (high == 1) {
                    sb.insert(0, high);
                }
            } else {    //n1 = n2
                sb.insert(0, high);
            }
        } else {
            if (n1 > n2) {
                sb.insert(0, num1.substring(0, n1));
            } else {
                sb.insert(0, num2.substring(0, n2));
            }
        }
        return sb.toString();
    }



}
