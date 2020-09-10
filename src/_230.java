/**
 * 类别：二叉树
 *
 * 要点：排序二叉树或者叫二叉搜索树，这个树按照中（根）序遍历得到的结果就是一个有序数组
 * 这个数组按照从大到小排列
 * 可以先中序遍历后，返回第k-1个元素即可
 * */
import java.util.ArrayList;
import java.util.List;

public class _230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list.get(k-1);
    }

    private void traverse(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        traverse(root.left,list);
        list.add(root.val);
        traverse(root.right,list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
