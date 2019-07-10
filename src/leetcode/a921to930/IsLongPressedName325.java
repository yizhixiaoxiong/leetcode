package leetcode.a921to930;

/**
 * @Description : 长按键入
 * <p>
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，
 * 在键入字符 c 时，按键可能会被长按，而字符可
 * 能被输入 1 次或多次。
 * 你将会检查键盘输入的字符 typed。如果它对应的
 * 可能是你的朋友的名字（其中一些字符可能被长按）
 * ，那么就返回 True。
 * <p>
 * 示例 1：
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 3：
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * <p>
 * 提示：
 * name.length <= 1000
 * typed.length <= 1000
 * name 和 typed 的字符都是小写字母。
 * <p>
 * * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/8 20:17
 * @Product_Name : leetcode
 */
public class IsLongPressedName325 {

    public static void main(String[] args) {
//        String name = "alex";
//        String typed = "aaleex";
//        String name = "saeed";
//        String typed = "ssaaedd";
//        String name = "leelee";
//        String typed = "lleeeleeeeede";
        String name = "pyplrz";
        String typed = "ppyypllr";
        System.out.println(isLongPressedName(name, typed));
    }

    //两个字符串name和typed
    //true的条件    1:  typed和name中的字符相同
    //              2： 每种字符的排列顺序一样，而且typed的每种字符
    //                  数量大于等于name
    public static boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int m = typed.length();
        if (n > m || n == 0 || name.equals(" ") || name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        char ch = typed.charAt(0);
        int k = 0;
        //循环typed
        for (int i = 0; i < m; i++) {
            if (typed.charAt(i) == name.charAt(k)) {
                k++;
                ch = typed.charAt(i);
            } else {
                //不相等，i和i-1是否相等,如果相等查看下一个,如果不相等，则说明
                //typed的i值和name的k值不等,返回false
                if (ch == typed.charAt(i)) {
                    continue;
                } else {
                    return false;
                }
            }
            //到了name的末尾
            if (k == n) {
                //等于name的最后一个字符
                ch = name.charAt(n - 1);
                //判断typed的剩余字符是否都等于name的最后一个字符
                //如果不是则返回false
                while (i < m) {
                    if (typed.charAt(i) != ch) {
                        return false;
                    } else {
                        i++;
                    }
                }
            }
        }
        if (k != n) {
            return false;
        }
        return true;
    }

    //分别统计type和name的字符顺序,类型以及对应的个数
    //如：name = "leelee";   typed = "lleeeleeeeee";
    //      l(1)e(2)l(1)e(2)  l(2)e(3)l(1)e(6)
    //分别组成字符串
    //      l1e2l1e2    和 l2e3l1e6
    //先比较长度，长度不一样则false
    //长度一样 ，分别比较两个字符串的字符和数字
    //如果字符不同，返回false。如果字符相同，比较数字。tyepe的数字 >= name的数字

    //这个方法运行速度不如上面一次循环的。因为这个方法需要先循环组成新字符串，然后在循环新字符串。
    //
    public boolean isLongPressedName1(String name, String typed) {
        return false;
    }
}
