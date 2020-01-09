/*
* 类别：栈
*
* 这里注意避免过多的对string的截断处理，尽量使用index获取string中的字符
*
*
* */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _20_Valid_Parentheses {
    public static boolean isValid(String s) {
        if (s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for(int i = 0;i < s.length();i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                if (stack.empty())
                    return false;
                if (stack.peek() == map.get(cur))
                    stack.pop();
                else
                    return false;
            } else
                stack.push(cur);
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
}
