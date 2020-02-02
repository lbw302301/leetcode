/**
 * 类别：链表
 *
 * 要点：注意这里没有给出链表的head
 * 因此不能使用常规方法
 * 这里可以将要删除节点node的值修改为node.next的值，然后将node.next删除，这样就可以达到目的*/
public class _237 {
    public void deleteNode(ListNode node) {
        ListNode cur = node.next;
        node.val = cur.val;
        node.next = cur.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
