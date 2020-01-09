/**
 * 类型：二叉树
 *
 * BFS
 *
 * 广度优先遍历的一般解法就是使用队列！！！先进先出的特点，将第一层的节点放入，然后在出队列的时候将下一层的节点放入队列，此时通过level来控制哪一层
 * 通过level_length记录一层有多少个节点
 *
 *
 * 递归方法中就要考虑将节点所处的level当做参数放到迭代过程中
 * */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 方法1 递归方式
     * public List<List<Integer>> levelOrder(TreeNode root) {
     * List<List<Integer>> levels = new ArrayList<>();
     * if(root == null)
     * return levels;
     * helper(levels, root, 0);
     * return levels;
     * }
     * <p>
     * public void helper(List<List<Integer>> levels, TreeNode t, int level){
     * if(level == levels.size())
     * levels.add(new ArrayList<Integer>());
     * levels.get(level).add(t.val);
     * if(t.left != null)
     * helper(levels, t.left, level + 1);
     * if(t.right != null)
     * helper(levels, t.right, level + 1);
     * }
     **/
    //方法2  迭代 及使用队列BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null)
            return levels;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            //每次循环都是处理一个level
            levels.add(new ArrayList<Integer>());
            int level_length = queue.size();
            //这里对一层的节点进行遍历，然后把下一层的节点全部加入
            for (int i = 0; i < level_length; i++) {
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            level++;
        }
        return levels;
    }
}
