/**
 * 类别：链表
 *
 * 要点：参考206题
 *
 * 这里使用快慢指针，快指针是慢指针的两倍速度，则可以将链表等分为两部分
 *
 * 对前半部分链表翻转，参考206；然后与后半部分对比
 * */
public class _234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head.next.next;
        //这里快慢指针将链表分为两部分
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //翻转前半部分
        slow = slow.next;
        ListNode next = null;
        ListNode prev = null;
        while(head != slow){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        //如果链表有奇数个，则将中间节点跳过；fast == null证明是偶数个
        if(fast != null)
            slow = slow.next;
        //翻转后的前部分跟后半部分比较
        while(prev != null){
            if(prev.val != slow.val)
                return false;
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

}
