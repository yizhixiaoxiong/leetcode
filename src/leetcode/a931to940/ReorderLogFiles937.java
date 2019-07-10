package leetcode.a931to940;

import java.util.*;

/**
 * @Description :重新排列日志文件
 * <p>
 * 日志数组有两种日志，一种是数字日志一种是字母日志
 * 每个日志开头都带 一个标志
 * <p>
 * 要求：日志重排,字母排在数字之前，字母日志按字母顺序排列
 * 内容相同按标识符排序。数字日志按照原来的书讯排列
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/9 13:47
 * @Product_Name : leetcode
 */
public class ReorderLogFiles937 {

    //这个方法有优化，
    // 一、可以在for循环中完成排序
    //      即将map排序放在reorderLogFiles的for循环中
    //二、 不用mao，将map的排序换成list排序使用的方法可以是List 的 add(index,ele);

    public static void main(String[] args) {
        String[] logs = {"a1 9 2 3 1","g1 acab car","g1 acab car","g1 aca acar","zo4 4 7","ab1 " +
                "off key dog","a8 acta zoo"};
        String[] result = reorderLogFiles(logs);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    //找到字母日志，进行排序，
    //然后用一个(什么)存储顺序的数字日志
    public static String[] reorderLogFiles(String[] logs) {
        //字符列表
        List<String> listStr = new ArrayList<>();
        //数字列表
        List<String> listNum = new ArrayList<>();

        //循环日志列表
        for (int i = 0; i < logs.length; i++) {
            //获取日志中的字符串
            String[] s = logs[i].split(" ");
            //标识
            char[] chars = s[1].toCharArray();
            //判断标识符后面是数字还是字母
            //是字母存储到list中
            if (chars[0] >= 65 && chars[0] <= 122) {
                listStr.add(logs[i]);
            }else{
                listNum.add(logs[i]);
            }
        }
        String[] strs = new String[listStr.size()];
        listStr.toArray(strs);
        Map<Integer, String> map = sort(strs);
        for (int i = map.size()-1; i >= 0; i--) {
            logs[map.size()-1-i] = map.get(i);
        }
        for (int i = 0; i < listNum.size(); i++) {
            logs[map.size()+i] = listNum.get(i);
        }
        return logs;
    }

    //排列顺序，返回排列后的下标数组
    //假设全部是字母日志
    public static Map<Integer, String> sort(String[] strLogs) {
        Map<Integer, String> map = new HashMap<>();
        String first = strLogs[0];
        int n = strLogs.length-1;
        //从后往前存储,前面是小的，后面是大的
        map.put(n, first);
        int k = 0;
        for (int i = 1; i < strLogs.length; i++) {
            k = i;
            for (int j = n-k+1; j <= n; j++) {
                String str = map.get(j);
                String sub1 = str.substring(str.indexOf(" "));
                String sub2 = strLogs[i].substring(strLogs[i].indexOf(" "));
                if (sub1.compareTo(sub2) == 0) {
                    if (str.compareTo(strLogs[i]) <= 0) {    //说明str大
                        map.put(n-k, strLogs[i]);
                        break;
                    } else {
                        map.put(n-k, str);
                        k--;
                    }
                }else if (sub1.compareTo(sub2) < 0){   //sub1大
                    map.put(n-k, strLogs[i]);
                    break;
                }else{      //sub2大,将sub1存储到k并比较前面的
                    map.put(n-k, str);
                    k--;
                }
                map.put(j,strLogs[i]);
                }
            }
        //map就是排序好的字符日志
        return map;
    }

}
