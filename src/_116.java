/**
 * 类别：二叉树
 *
 * 递归
 *！！！！！！多看看！！！！
 *
 * 还有另外一种BFS的解法但是不符合题目中使用常亮空间复杂度，因为Queue的长度跟树大小有关
 * 要点：start指向每层的开始，cur指向BFS当前遍历的节点，pre指当前遍历节点的前一个节点
 *  cur=null的时候表示当前一层已经遍历完需要换下一层
 *  pre没到新的一层总是指向第一个， cur指向第二个，然后一直后移
 *
 *  通过cur指示每一层的最后一位，start表示每一层的第一位
 *
 *  pre会把除最后一层外的都遍历，然后再当前层将下一层的next连接好
 *
 * */
import util.Node;

public class _116 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node pre = root;
        Node cur = null;
        Node start = pre;
        while (pre.left != null) {


            //遍历到了最右边的节点，要将 pre 和 cur 更新到下一层，并且用 start 记录
            if (cur == null) {
                //我们只需要把 pre 的左孩子的 next 指向右孩子。
                pre.left.next = pre.right;

                pre = start.left;
                cur = start.right;
                start = pre;
                //将下一层的 next 连起来，同时 pre、next 后移
            } else {
                //把 pre 的左孩子的 next 指向右孩子
                pre.left.next = pre.right;
                //pre 的右孩子的 next 指向 cur 的左孩子。
                pre.right.next = cur.left;

                pre = pre.next;
                cur = cur.next;
            }
        }
        return root;
    }
}
