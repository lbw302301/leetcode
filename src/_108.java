/**
 * 类别：二叉树  二分法
 *
 * 要点：要构造的树 的中序遍历  就是对数组二分查找的访问顺序
 *      根节点就是(left + right) / 2对应的点
 *      然后再把数组以此中点分割成两部分，分部当做左右子树
 *
 *
 * */
import util.TreeNode;

public class _108 {
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return build(0, nums.length - 1);
    }

    public TreeNode build(int left, int right) {
        if (right < left)
            return null;
        int index = ((left + right) % 2 == 0) ? (left + right) / 2 : (left + right) / 2 + 1;
        TreeNode root = new TreeNode(nums[index]);
        root.left = build(left, index - 1);
        root.right = build(index + 1, right);
        return root;
    }
}
