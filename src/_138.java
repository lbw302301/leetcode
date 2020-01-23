/**
 * 类别：深拷贝
 *
 * 要点：注意深拷贝是要将对象里包含的指针同样的也要拷贝到新建的对象上
 * 这里，首先对head进行拷贝，next和random先认为为null
 * 使用map记录新建的node和原有的node的对应关系
 * 对newhead的next和random进行考虑，如果head相应的next，random没有在map中则创建一个新node
 * 然后将新建node对应到newhead中，put到map里
 *
 * 对head循环，按照next链式寻找，newhead同样的顺序进行循环赋值
 *
 * */
import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class _138 {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Map<Node, Node> visited = new HashMap<>();
        Node newHead = new Node(head.val);
        Node cur = newHead;
        visited.put(head, newHead);
        while (head != null) {
            if (head.next == null) {
                cur.next = null;
            } else if (!visited.containsKey(head.next)) {
                Node newNode = new Node(head.next.val);
                cur.next = newNode;
                visited.put(head.next, newNode);
            } else {
                cur.next = visited.get(head.next);
            }

            if (head.random == null) {
                cur.random = null;
            } else if (!visited.containsKey(head.random)) {
                Node newNode = new Node(head.random.val);
                cur.random = newNode;
                visited.put(head.random, newNode);
            } else {
                cur.random = visited.get(head.random);
            }

            head = head.next;
            cur = cur.next;
        }
        return newHead;
    }

}
