package leetcode.a441to450;

/**
 * @Description :  压缩字符串
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）
 * 在完成原地修改输入数组后，返回数组的新长度。
 * <p>
 * 1、所有字符都有一个ASCII值在[35, 126]区间内。
 * 2、1 <= len(chars) <= 1000。
 * </p>
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/3 2:09
 * @Product_Name : leetcode
 */
public class Compress443 {

    public static void main(String[] args) {
//        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'c'};
//        char[] chars = {'a'};
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int compress = compress(chars);
        System.out.println(compress);

    }

    //单循环，一次性找到
    public static int compress(char[] chars) {
        int len = chars.length;
        //统计字符数量
        int count = 1;
        char c = chars[0];
        int k = 0;  //统计共有多少数组
        for (int i = 1; i < len; i++) {
            //如果 chars[i] 不c
            if (chars[i] == c) {
                count++;
                continue;
            } else {
                if (count == 1) {
                    chars[k] = c;
                    c = chars[i];
                    k++;
                } else {  // count 大于1
                    String str = String.valueOf(count);
                    chars[k] = c;
                    c = chars[i];
                    for (int j = 0; j < str.length(); j++) {
                        chars[++k] = str.charAt(j);
                    }
                    k++;
                    count = 1;
                }
            }
        }
        if (count == 1){
            chars[k] = c;
            k++;
        }else {
            String str = String.valueOf(count);
            chars[k] = c;
            for (int i = 0; i < str.length(); i++) {
                chars[++k] = str.charAt(i);
            }
            k++;
        }

        return k;
    }
}
