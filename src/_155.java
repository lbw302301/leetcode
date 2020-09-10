/**
 * 类别：栈
 *
 * 要点：一般这种采用辅助栈，data正常存储数据，helper用于快速找到最小值
 * 入栈时，helper中栈顶的元素大于等于要入栈的元素才可以push，这样就能保证快速取到最小值，等于是因为要保证有多个最小值出栈时不会出错
 * 出栈时，只有helper和data的栈顶一致时，helper才pop
 * top、getmin、peek都是只获取元素不出栈
 *
 * */
import java.util.Stack;

public class _155 {
    class MinStack {

        private Stack<Integer> data;
        private Stack<Integer> helper;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new Stack<>();
            helper = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if (!helper.isEmpty()) {
                if (helper.peek() >= x)
                    helper.push(x);
            } else {
                helper.push(x);
            }
        }

        public void pop() {
            int x = data.pop();
            if (x == helper.peek())
                helper.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return helper.peek();
        }
    }
}
