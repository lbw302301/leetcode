/**
 * 类别：二叉树
 *
 * BFS变形
 *
 * 要点：这里主要对BFS进行一个变形操作，利用层数来进行判断是否翻转
 * 同时翻转不能影响下一层的正常访问顺序
 * 因此不能对队列进行顺序修改
 * 此时就利用LinkedList实现将node输出到结果集中的翻转，即addFirst;
 * */

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null)
            return levels;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> oneLevel = new LinkedList<>();
            int level_length = queue.size();
            for (int i = 0; i < level_length; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0)//第0层以及2、4、6……层不需要翻转
                    oneLevel.add(node.val);
                else//奇数层需要翻转，即在输出的时候进行翻转
                    oneLevel.addFirst(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            levels.add(oneLevel);
            level++;
        }
        return levels;
    }
}
