/**
 * 类别：递归
 *
 * 要点：这里就是遍历nestedInteger的list，如果元素是list则对这个list进行遍历放入结果中，然后再继续大list的遍历
 * */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


public class _341 {

    class NestedIterator implements Iterator<Integer> {

        private List<Integer> list;
        private int index;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.list = integerIterator(nestedList);
            index = -1;
        }

        @Override
        public Integer next() {
            if(this.hasNext())
                return list.get(++index);
            return null;
        }

        @Override
        public boolean hasNext() {
            return (index+1) < list.size();
        }

        private List<Integer> integerIterator(List<NestedInteger> nestedList) {
            List<Integer> list = new ArrayList<>();
            for (NestedInteger key : nestedList) {
                if (key.isInteger()) {
                    list.add(key.getInteger());
                }else{
                    list.addAll(integerIterator(key.getList()));
                }
            }
            return list;
        }
    }
}
