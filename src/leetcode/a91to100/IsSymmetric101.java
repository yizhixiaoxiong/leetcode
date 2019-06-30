package leetcode.a91to100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description : 给定一个二叉树，检查它是否是镜像对称的
 * 1
 * / \
 * 2   2       [1,2,2,3,4,4,3]  这是对称的
 * / \ / \
 *3  4 4  3
 * <p>
 *  1
 * / \
 *2   2       [1,2,2,null,3,null,3]  这是不对称的
 * \   \
 *  3   3
 * <p>
 * 如果你可以运用 递归 和 迭代 两种方法解决这个问题，会很加分
 * <p>
 * <p>
 * 由图可知,对称的条件是层与层对称
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/30 11:27
 * @Product_Name : leetcode
 */
public class IsSymmetric101 {

    //节点
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //按层遍历，遍历每层,是否对称
    //用一个队列存储相邻两个节点的值，看是否相同。
    //队列的存储方式是子节点左右相反的方式
    public boolean isSymmetric(TreeNode root) {

        //初始化一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        //将树一分为二，也就是分成左右两个部分。分别放入队列中
        //因为=都是从根节点开始的
        queue.add(root);
        queue.add(root);

        //条件是：队列不为空
        while (!queue.isEmpty()) {
            //分别弹出左右子节点
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            //如果 left 和 right 都为null也是对称，但left和right无子节点，可进行下一次循环
            if ( left == null && right == null) continue;
            //因为前一条语句已经判断出left 和 right 有一个不为 0
            //left 和 right 有一个为null 则是不对称的
            if (left == null || right == null){
                return false;
            }
            if (left.val != right.val){
               return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);

        }
        return true;
    }

    //递归
    public boolean isSymmetric2(TreeNode root) {
        return image(root, root);

    }

    public boolean image(TreeNode left , TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        return image(left.left, right.right) && image(left.right,right.left );
    }
}
