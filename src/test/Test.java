package test;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description :
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/15 15:46
 * @Product_Name : leetcode
 */
public class Test {

    public static void main(String[] args) {
//        char ch = '\\';
//        System.out.println((char) 1);
//        List<String> list = new ArrayList<>();
//        list.add("abcd");
//        list.add("abcd");
//        list.add(0,"abcd");
//        for (String s:list) {
//            System.out.println(s);
//        }

        String a = " acab car";
        String b = " acab car";
        System.out.println(a.compareTo(b) == 0);

        Map<Integer,String> map = new HashMap<>();
        for (int i = 4; i >=0; i--) {
            map.put(i, String.valueOf(i));
        }

        for (int i = 0; i <= 4; i++) {
            System.out.println(map.get(i));
        }
    }

}
