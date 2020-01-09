/*
 *类别：回溯法
 *
 *！！！当解空间为一棵树时，而且需要自底向上进行修正的情况，完美适用回溯法！！！
 *！！！回溯就是递归的应用！！！
 *这里需要考虑括号匹配问题，当left代表的左括号数量多于右括号数量时可以添加右括号，反之则不能
 *开始时给初始值“(”可以减少一半的情况
 *在回溯过程中，每次走到树的最低端向上一级反馈，这时就会恢复到上一级调用的状态，包括str的值，
 */
import java.util.ArrayList;
import java.util.List;

public class _22_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,"(",1,0,n);
        return result;
    }

    public void backtrack(List<String> result, String cur, int left, int right, int max){
        if(cur.length() == 2 * max){
            result.add(cur);
            return;
        }
        if(left < max)
            backtrack(result, cur+"(", left+1,right, max);//注意这里left的状态在回溯时也要回退
        if(right < left)
            backtrack(result, cur+")", left, right+1, max);
        return;
    }
}
