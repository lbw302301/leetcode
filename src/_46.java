/*
* 类别：回溯法
*
*
* 要点：1.解空间也是一棵树，需要一层一层的修正
*       2.注意最终的返回条件
*       3.要注意状态回溯时，所有的变量都要手动回溯！！！
*       4.注意回溯过程中会对一些对象进行修改，要特别注意！！！
*
* */
import java.util.ArrayList;
import java.util.List;

public class _46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        boolean[] visited = new boolean[len];
        if(len == 0)
            return res;
        backtrack(res, nums, len, visited, new ArrayList<>(), 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, int len, boolean[] visited, List<Integer> ans, int curLength){
        if(curLength == len){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = 0 ; i < len; i++){
            if(!visited[i]){
                ans.add(nums[i]);
                visited[i] = true;
                backtrack(res, nums, len, visited, ans, curLength + 1);//注意这里要保证回退的时候，curLength也回退
                visited[i] = false;
                ans.remove(Integer.valueOf(nums[i]));
            }
        }
    }
}
