import java.util.HashMap;
import java.util.Map;

/**
 * 类别：数学题
 *
 * 要点：a⊕b⊕a=(a⊕a)⊕b=0⊕b=b，因此将所有的值异或操作可以获得只有一个的值
 *
 * 或者可以用hashMap
 *
 * */
public class _136 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        if(nums.length == 1)
            return nums[0];
        for(int i = 1; i < nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
    }

    /*public int singleNumber(int[] nums){
        Map<Integer,Integer> res = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(res.containsKey(nums[i])){
                res.put(nums[i], res.get(nums[i])+1);
            }else{
                res.put(nums[i],1);
            }
        }
        for(Integer i : res.keySet()){
            if(res.get(i) == 1)
                return i;
        }
        return -1;
    }*/
}
