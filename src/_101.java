/**
 * 类别：二叉树 递归
 *
 *
 * 要点：1. 对于初始根节点，左右子树对称则对称；以此类推开始递归，两个根的对应子树判断是否对称；
 *       2. 两个树镜像的定义—————根的值相等并且每个树的左子树与另一个树的右子树镜像对称
 *
 * */
public class _101 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

}
