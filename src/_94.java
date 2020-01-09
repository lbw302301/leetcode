/**
 * 类别：二叉树遍历
 *
 * 回溯
 *
 * 要点：注意中序的含义是先遍历左节点，再遍历中间节点最后右节点,这里的序指的是访问根的先后
 *
 * 树的遍历可以分为栈和回溯两种
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(result, root);
        return result;
    }

    public void traverse(List<Integer> result, TreeNode t) {
        if (t == null)
            return;
        traverse(result, t.left);
        result.add(t.val);
        traverse(result, t.right);
    }
    //另外一种方法遍历，栈的方法遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!= null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
