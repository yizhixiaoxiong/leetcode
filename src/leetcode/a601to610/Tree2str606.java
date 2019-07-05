package leetcode.a601to610;

/**
 * @Description : 根据二叉树创建字符串
 * @demand :
 * @Auther : hanxiaofan
 * @Date : 2019/7/5 14:23
 * @Product_Name : leetcode
 */
public class Tree2str606 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        //
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(5);


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);

        root2.right.right = new TreeNode(5);

        System.out.println(tree2str(root2));
    }

    //前序遍历:打印当前结点，再打印左子树，打印右子树
    //按照前序遍历之后的的字符串是将null也用括号表示
    //如     1                            1
    //     /   \                        /   \
    //    2     3                       2     3
    //   /                              \
    //  4                                4
    // 前序遍历为：
    // (1(2(4()())())(3()()))    (1(2()(4()()))(3()()))
    //  1(2(4))(3)               1(2()(4))(3)
    //观察可知，需要将 多余的括号删除
    //  删除条件: 1.节点下有第一个节点(左节点)，
    //            没有第二个节点(右节点),删除第二个(右节点)
    //            2 节点下没有第一个没有第二个，全部删除.
    //            3  删除头节点的括号
    public static String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        preOrder(t, sb);
//        sb.substring(1, sb.length()-1);
//        return sb.toString();

        return sb.substring(1, sb.length()-1);  //去掉头结点的前后括号
    }
    //前序遍历递归实现
    public static void preOrder(TreeNode root ,StringBuilder sb){

        if (root != null){
            sb.append("(");
            sb.append(root.val);
            //如果这个节点不存在左右子树
            //用一个括号包裹值，并不用递归下去
            if (root.left == null && root.right == null) {
                sb.append(")");
                return;
            }
            //有左子树，无右子树，直接递归左子树
            if (root.left != null && root.right == null){
                preOrder(root.left, sb);
            }
            //有右子树，无左子树。递归右子树，但是需要保留左子树的括号
            if (root.left == null && root.right != null){
                sb.append("()");
                preOrder(root.right, sb);
            }
            //有左有右，常规递归
            if (root.left != null && root.right != null) {
                preOrder(root.left, sb);
                preOrder(root.right, sb);
            }
            sb.append(")");
        }

    }

}
