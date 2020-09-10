/**
 * 类别：双指针
 *
 * 要点：使用快慢指针，如果链表成环，则快指针可以追上慢指针；不成环的话则fast会先到达末尾
 * 而且快指针每次跳两个节点，慢指针每次跳一个
 *
 * */
public class _141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {//如果成环则会跳出循环
            if (fast == null || fast.next == null)//如果不成环，则fast已经跳到了null，或者fast正指向末尾
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
