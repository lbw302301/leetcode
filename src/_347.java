/**
 * 类别：哈希表
 *
 * 要点：首先使用哈希表存储元素和出现次数的对应关系
 *
 * 然后把出现次数当作一个数组的下标，然后数组中的元素是一个list
 * 遍历哈希表，按照value值将key放到数组中对应下标处的list内
 *
 * 注意这个数组大小要是nums。length+1，为了处理【-1，-1】这种情况
 *
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class _347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        //统计出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        //新建数组，出现频率为下标，把数字填到数组中
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (list[value] == null)
                list[value] = new ArrayList<>();
            list[value].add(key);
        }
        //将数组倒着遍历，可以取出前k大的频率
        for (int i = nums.length - 1; i >= 0 && k > 0; i--) {
            if (list[i] != null) {
                ans.addAll(list[i]);
                k -= list[i].size();
            }
        }
        return ans;
    }


}


