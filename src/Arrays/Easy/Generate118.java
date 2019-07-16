package Arrays.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/16 10:53
 * @Product_Name : leetcode
 */
public class Generate118 {

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> generate = generate1(numRows);
        for (int i = 0; i < generate.size(); i++) {
            for (int j = 0; j < generate.get(i).size(); j++) {
                System.out.print(generate.get(i).get(j) + ",");
            }
            System.out.println();
        }

    }

    //看返回值可知 List中有另一个List
    //分析，第一个List代表行数
    //      第二个List代表行数中的Integer数据
    //画图可知:
    //  给了一个非负整数numRows,则行数的长度为numRows。
    //  第一行有1个数据，第二行有2个数据，第n行有n个数据
    //  数据中的数据为对称相等的
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rowList = new ArrayList(numRows);
        List<Integer> list = new ArrayList<>(1);
        if (numRows == 0) {
            rowList.add(list);
            return rowList;
        }
        list.add(1);
        rowList.add(list);  //第一行 下标为0
        //向rowList中添加数据
        for (int i = 2; i <= numRows; i++) {
            list = new ArrayList<>(i);
            List<Integer> integers = rowList.get(i - 2);
            int pre = 0;
            for (int j = 0; j < integers.size(); j++) {
                int tmp = pre + integers.get(j);    //计算的值
                list.add(tmp);
                pre = integers.get(j);              //更换前一个节点的值
            }
            list.add(1);
            rowList.add(list);
        }
        return rowList;
    }

    //动态规划解法
    //动态转移方程：
    // 第i行的第j的元素  =  (第 i-1 行的 第 j - 1 的元素) + (第 i-1 行的 第 j 个元素)
    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> rowList = new ArrayList<>();
        //如果numRows
        if (numRows == 0) {
            return rowList;
        }
        //第一个为列表为1
        List<Integer> list = new ArrayList<>();
        list.add(1);
        rowList.add(list);

        //找到动态规划方程
        //第 i 行的第j个值 等于 第i-1行的 j 和 j-1 的值
        for (int i = 1; i < numRows; i++) {
            //第 i 行的 列表
            list = new ArrayList<>();
            //第一个元素始终是1
            list.add(1);
            // 获取 第 i - 1 行 的列表
            List<Integer> listi = rowList.get(i - 1);
            for (int j = 1; j < listi.size(); j++) {
                list.add(listi.get(j - 1) + listi.get(j));
            }
            list.add(1);
            rowList.add(list);
        }

        return rowList;
    }

}
