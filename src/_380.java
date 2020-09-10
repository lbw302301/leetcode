/***
 * 类别：数据结构
 *
 * 要点：这里要保证插入、删除、随机访问都为O(1)时间复杂度
 * 随机访问要实现，就必须随机产生一个index，这样才能满足要求
 * 因此需要考虑多个数据结构组合，因为hashmap根据随机产生的数随机访问不符合，而Arraylist删除不符合
 *
 * 因此将这两种数据结构结合，arraylist存储数据；map存储<val，index>的键值对
 *
 * 这样在插入时，list和map都没问题
 *
 * 删除时，先从map中获取val对应的index，array中删除任意数字要将后续元素向前补齐，
 * 因此就将末尾元素迁移到index处，再将末尾元素删除；然后将末尾val对应的key-value在map更新
 * map中删除val
 *
 *
 *
 */
import java.util.*;

public class _380 {
    class RandomizedSet {

        private Map<Integer, Integer> map;
        private ArrayList<Integer> list;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val))
                return false;
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val))
                return false;
            int index = map.get(val);
            Integer last = list.get(list.size() - 1);
            list.set(index, last);
            map.put(last, index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }
    }
}
