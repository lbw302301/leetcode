/**
 * 类别：栈
 *
 * 要点：使用栈辅助存储，每当碰到运算符，即从栈中弹出两个元素，并且后弹出的是op1，op1 运算符 op2
 * 然后将结果放入栈中
 *
 * */
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _150 {
    private List<String> operators = Arrays.asList(new String[]{"+", "-", "*", "/"});

    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        if (len == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (operators.contains(tokens[i])) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(getRes(op1, op2, tokens[i]));
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    private int getRes(int op1, int op2, String operator) {
        if (operator.equals("+"))
            return op1 + op2;
        if (operator.equals("-"))
            return op1 - op2;
        if (operator.equals("*"))
            return op1 * op2;
        if (operator.equals("/"))
            return op1 / op2;
        else
            return 0;
    }
}
