/**
 * 类别：链表
 *
 * 要点：首先计算两个链表长度，
 * 要看是否相交，则需要末尾对齐，因此要从头部开始消除长度差
 * 因此要先将较长的head向后移动
 *
 * */
public class _160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode head = headA;
        //计算a、b的长度
        while (head != null) {
            lengthA++;
            head = head.next;
        }
        head = headB;
        while (head != null) {
            lengthB++;
            head = head.next;
        }
        int dif = lengthA - lengthB;
        //如果a的长度较长，则将a向后移动
        if (dif >= 0)
            while (dif > 0) {
                headA = headA.next;
                dif--;
            }
        //如果b的长度较长，将b后移
        else {
                while(dif < 0){
                    headB = headB.next;
                    dif++;
                }
        }
        while(headA != null && headB != null){
            //注意这里要保证引用指向的是同一个node，而不能只是值相同
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
