package leetcode.a91to100;

/**
 * @Description : 给定两个二叉树，编写一个函数来检验它们是否相同。
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/6/28 19:57
 * @Product_Name : leetcode
 */
public class IsSameTree100 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    //方法： 可以将两棵树遍历并将值组成 一个字符串,然后比较两个字符串是否相同
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //分析：
        //先从结构上判断
        //再从节点上判断
        StringBuilder strp = new StringBuilder();
        StringBuilder strq = new StringBuilder();

        pre(p, strp);
        pre(q, strq);


        if (strp.toString().equals(strq.toString())) {
            return true;
        } else {
            return false;
        }
    }

    //前序遍历二叉树
    public static void pre(TreeNode node, StringBuilder sb) {

        if (node != null) {
            sb.append(node.val);
            pre(node.left, sb);
            pre(node.right, sb);
        }else{
            sb.append(0);
        }
    }

    public static void main(String[] args) {
//        TreeNode p = new TreeNode(1);
//        p.left = new TreeNode(2);
//
//        TreeNode q = new TreeNode(1);
//        q.left = null;
//        q.right = new TreeNode(2);

        TreeNode p = null;
        TreeNode q = null;

        System.out.println(isSameTree(p, q));
    }
}
