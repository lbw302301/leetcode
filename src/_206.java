/**
 * 类别：链表
 * 要点：这里由于是单向链表，因此需要额外的prev来记录其前一个元素，
 * 每遍历到一个元素都使其next指向prev，并且将prev指针指向cur，
 * */
public class _206 {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode temp = cur.next;//事先取出cur。next
            cur.next = prev;//使的当前元素的next指向prev指针指向的节点
            prev = cur;//使得prev指针指向当前遍历节点
            cur = temp;//cur指向下一个节点
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
