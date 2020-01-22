/**
 * 类别：回文 递归
 *
 *
 * 要点：先考虑在第 1 个位置切割，a | abb
 * 这样我们只需要知道 abb 的所有结果，然后在所有结果的头部把 a 加入
 * abb 的所有结果就是 [a b b] [a bb]
 * 每个结果头部加入 a，就是 [a a b b] [a a bb]
 *
 * 后边每个分割位置都如此
 *
 * 递归过程发生在找到一个切割位置以后，对与分割后的右边重复操作
 * 递归过程中，要对每一个右边部分使用for循环遍历所有的切割点
 *
 *
 * */
import java.util.ArrayList;
import java.util.List;

public class _131 {
    private String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        return digui(0);
    }

    private List<List<String>> digui(int start){
        //递归结束条件
        if(start == s.length()){
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s.substring(start, i+1))){
                String left = s.substring(start, i+1);
                for(List<String> l : digui(i + 1)){
                    l.add(0, left);
                    ans.add(l);
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
