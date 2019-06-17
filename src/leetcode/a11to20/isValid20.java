package leetcode.a11to20;

import java.util.Map;

/**
 * @Description : 有效字符
 *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/17 17:15
 * @Product_Name : leetcode
 */
public class isValid20 {

    public static void main(String[] args) {
//        String s = "()[]{}";
//        String s = "()[]{}{";
//        String s = "([)]";
        String s = "";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        //1.空字符串为合法
        if (s == null || s.equals("")){
            return true;
        }
        int n = s.length();
        char[] symbols = new char[n];
        int size = 0;   //统计数组中个数

        //2.用栈来存储扫面的左括号,如果遇见了又括号，取出栈顶的左括号
        //  看是否和右括号匹配，
        // 结果：（1）如果扫描的过程中不匹配，则false;
        //        (2) 如果扫面完成栈顶为0，则true
        //        (3) 如果扫描，完成栈顶不为0,则fasle
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{'){   //保存在栈中
                symbols[size++] = ch;
            }else {
                if (size == 0) return false;
                if (ch == ')') {
                    if (symbols[size-1] == '(') {
                        size--;
                    }else {
                        return false;
                    }
                }else if (ch == ']'){
                    if (symbols[size-1] == '[') {
                        size--;
                    }else {
                        return false;
                    }
                }else if (ch == '}') {
                    if (symbols[size-1] == '{') {
                        size--;
                    }else {
                        return false;
                    }
                }
            }
        }
        return size == 0 ?true:false;
    }

}
