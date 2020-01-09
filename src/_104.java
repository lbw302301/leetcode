/**
 * 类别：二叉树
 *
 *要点：DFS，递归
 * 在深度遍历的时候求出整个树的最大深度，则对每个节点的左右子树都进行比较取最大值即可，很简单
 * */
import util.TreeNode;

public class _104 {
    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    public int depth(TreeNode root){
        if(root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right) + 1;
    }
}
