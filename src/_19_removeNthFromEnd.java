/*
*
*类别：双指针、链表
* 1.普通遍历解法，要考虑边界问题，如要删除最左边元素时，应当特殊考虑；
* 2.双指针解法，
* 我们可以设想假设设定了双指针 p 和 q 的话，当 q 指向末尾的 NULL，p 与 q 之间相隔的元素个数为 n 时，
* 那么删除掉 p 的下一个指针就完成了要求。
* ！！！why dummyHead，因为这个时候要考虑只有一个元素节点的情况，所以要让dummyhead->next = head,
* ！！！同时保证最终p是todel Node的前一个
* 设置虚拟节点 dummyHead 指向 head
* 设定双指针 p 和 q，初始都指向虚拟节点 dummyHead
* 移动 q，直到 p 与 q 之间相隔的元素个数为 n
* 同时移动 p 与 q，直到 q 指向的为 NULL
* 将 p 的下一个节点指向下下个节点
*
*
* */
 class _19_removeNthFromEnd {
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        length -= n;
        cur = dummy;
        while(length-- > 0){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
