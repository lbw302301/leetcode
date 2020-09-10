/**
 * 类别： 回溯法 子集
 *
 * 要点：注意这里的回溯的过程，要保证每次都是只把当前遍历过的下一位添加进来即可
 *
 *
 * */
import java.util.ArrayList;
import java.util.List;

public class _78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, int i, List<List<Integer>> res, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            backtrack(nums, j + 1, res, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
