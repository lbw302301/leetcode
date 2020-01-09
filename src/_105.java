/**
 * 类别：二叉树
 * 递归，根据遍历顺序构造树
 *
 *
 * 要点：对preorder进行顺序遍历，preorder中待访问的第一个元素都根节点，则根据此点将inorder划分成左子树和右子树
 *       对inorder按照左右两部分分别重复这个过程
 *
 * 注意 传递边界值比传递部分数组节约开支
 *
 *
 *
 *
 * */
import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _105 {
    int[] preorder;
    int[] inorder;
    int preIndex = 0;
    //map是为了在inorder中找到preorder[0]值对应的index
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        int idx = 0;
        for (Integer val : inorder)
            map.put(val, idx++);
        return build(0, inorder.length);
    }
//in_left表示在inorder中的左侧边界，区间是左闭右闭
    public TreeNode build(int in_left, int in_right) {
        if (in_left == in_right)
            return null;
        int root_val = preorder[preIndex];
        TreeNode root = new TreeNode(root_val);
        int rootVal_In_inorder_Index = map.get(root_val);
        preIndex++;
        root.left = build(in_left, rootVal_In_inorder_Index);
        root.right = build(rootVal_In_inorder_Index + 1, in_right);
        return root;
    }

}
