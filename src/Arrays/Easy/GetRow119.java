package Arrays.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 杨辉三角 II
 * <p>
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/16 13:33
 * @Product_Name : leetcode
 */
public class GetRow119 {

    public static void main(String[] args) {
        int rowIndex = 5;
        List<Integer> integers = getRow(rowIndex);
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i)+",");
        }
    }

    //动态规划,一种是将 rowIndex 之前的所有数据都存入
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> rowList = new ArrayList<>();
        //第一个为列表为nulle
        List<Integer> list = new ArrayList<>();
        list.add(1);
        rowList.add(list);

        //找到动态规划方程
        //第 i 行的第j个值 等于 第i-1行的 j 和 j-1 的值
        for (int i = 1; i <= rowIndex +1; i++) {
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

        return rowList.get(rowIndex);
    }

    //空间复杂度为 O(k)
//    public List<Integer> getRow1(int rowIndex) {
//
//    }


//    public int sum(int n) {
//        int sum = 0;
//        for (int i = 1; i <= n; i++) {
//            for (int j = i; j < n - 1; j++) {
//
//            }
//        }
//    }

}
