/**
 * 类别：二叉树
 * 平衡二叉树
 *
 * 要点：采用自底向上的方法，获取每个节点的左右子树的深度以及差是否大于1
 * 在这里如果不平衡则一路返回-1，省去其他计算的过程
 * 做DFS ！！！！获取树的高度，通过自底向上的递归！！！来进行计算
 *
 * DFS中其实就是后序遍历，先访问子节点最后访问根节点
 *
 * */
public class _110 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    public int depth(TreeNode t) {
        //当访问到叶子节点的左子树时要返回
        if (t == null)
            return 0;
        //获取当前节点左子树的深度
        int left = depth(t.left);
        if (left == -1)
            return -1;
        //获取当前节点右子树的深度
        int right = depth(t.right);
        if (right == -1)
            return -1;
        //在当前节点判断左右子树是否平衡，如果是则把当前节点对应的深度+1返回给父节点
        return Math.abs(left - right) < 2 ? Math.max(right, left) + 1 : -1;
    }

}
