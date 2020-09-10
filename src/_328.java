/**
 * 类别：链表
 *
 * 重点看！！
 *
 * 要点：主要这里使用两条链表分别指示odd、even，奇偶链表，其实只是创建了两个reference，
 * 他们各自指向已经申请好的内存中的奇偶节点
 *
 * ！！！主要对象的reference与对象本身的区别！！！！
 * */
public class _328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
}
