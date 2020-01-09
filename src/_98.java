/**
 * 类别： 二叉树遍历
 * 验证搜索二叉树是否有效
 *
 * 要点：要判断有效就要保证中序遍历的时候是有序的
 *
 * 或者另外一种思路，要保证，一个节点左边的所有元素都要小于它，因此在递归时要设置边界
 *
 */

import java.util.Stack;

public class _98 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder)
                return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }


}
