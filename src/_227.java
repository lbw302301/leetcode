/**
 * 类别：栈
 *
 * 类似150题
 * 要点：这里需要先将表达式转换成后缀表达式也叫做逆波兰表达式
 * 转换过程中，需要一个后缀表达式，一个运算符栈
 *      如果碰到数字直接加到后缀表达式中；
 *      如果碰到运算符，如果栈顶运算符的优先级大于或者等于当前运算符，则弹出到表达式中；再完成入栈
 *      最后遍历完输入的表达式后，将栈中的元素弹出到后缀表达式
 *
 * 根据后缀表达式进行计算结果
 * 当遍历到数字则压入栈，如果遇到运算符则弹出栈内两个元素并用运算符计算，将结果压栈
 * 遍历完后，将栈顶弹出即可
 *
 * */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _227 {
    public int calculate(String s) {
        //转换成后缀表达式
        List<String> back = new ArrayList<>();
        Stack<Character> op = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ')
                continue;
            //运算符先看栈顶元素优先级，将栈内优先级高或等的弹出到后缀表达式
            else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                while(!op.isEmpty())
                    back.add(String.valueOf(op.pop()));
                op.push(s.charAt(i));
            }
            else if(s.charAt(i) == '*' || s.charAt(i) == '/'){
                while(!op.isEmpty() && (op.peek()=='/' || op.peek() == '*'))
                    back.add(String.valueOf(op.pop()));
                op.push(s.charAt(i));
            }else{
                //如果是数字，则将数字拼接成一个有效的数字再放入后缀表达式
                int j = i + 1;
                for(;j<s.length() && Character.isDigit(s.charAt(j));j++){

                }
                back.add(s.substring(i, j));
                i = j - 1;
            }
        }
        //遍历完后将运算符栈弹出到后缀表达式
        while(!op.isEmpty()){
            back.add(String.valueOf(op.pop()));
        }

        //计算后缀表达式
        Stack<Integer> ans = new Stack<>();
        for(int i = 0; i < back.size(); i++){
            if(back.get(i).equals("+") || back.get(i).equals("-")|| back.get(i).equals("*") || back.get(i).equals("/")){
                int op2 = ans.pop();
                int op1 = ans.pop();
                ans.push(getRes(op1, op2, back.get(i)));
            }else{
                ans.push(Integer.valueOf(back.get(i)));
            }
        }
        return ans.pop();
    }

    private int getRes(int op1, int op2, String operator){
        if(operator.equals("+"))
            return op1 + op2;
        if(operator.equals("-"))
            return op1 - op2;
        if(operator.equals("*"))
            return op1 * op2;
        if(operator.equals("/"))
            return op1 / op2;
        else
            return 0;
    }

}
