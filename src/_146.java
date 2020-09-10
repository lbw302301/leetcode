/**
 * 类别：双向链表
 *
 * 使用双向链表，使得刚刚被访问或者加入的节点放到头部，其他的依次后移
 * map当作主体数据结构，用来存储键值对，键为题目里给的key，value为链表node
 * 双向链表控制访问时间先后
 *
 * 或者使用java原生的LinkedHashMap，可以记录插入顺序
 * removeEldestEntry，可以在size》capacity时删除最不常用的项
 *
 * */
import java.util.HashMap;
import java.util.Map;

public class _146 {

    class LRUCache {
        private int size;
        private int capacity;
        private DLinkNode head;
        private DLinkNode tail;
        private Map<Integer, DLinkNode> cache;
        public LRUCache(int capacity) {
            cache = new HashMap<>();
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkNode();
            tail = new DLinkNode();
            head.next = tail;
            tail.prev = head;
        }

        private void add(DLinkNode node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void remove(DLinkNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkNode node){
            remove(node);
            add(node);
        }

        private DLinkNode popTail(){
            DLinkNode last = tail.prev;
            remove(last);
            return last;
        }

        public int get(int key) {
            DLinkNode res = cache.get(key);
            if(res == null)
                return -1;
            moveToHead(res);
            return res.value;
        }

        public void put(int key, int value) {
            DLinkNode node = cache.get(key);
            if(node == null){
                DLinkNode newNode = new DLinkNode();
                newNode.value = value;
                newNode.key = key;
                add(newNode);
                cache.put(key, newNode);
                size++;
                if(size > capacity){
                    cache.remove(popTail().key);
                    size--;
                }
            }else{
                node.value = value;
                moveToHead(node);
            }
        }

        class DLinkNode{
            int key;
            int value;
            DLinkNode prev;
            DLinkNode next;
        }
    }
}
