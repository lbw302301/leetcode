/**
 * 类别：数组
 *
 * 要点：在重置的时候要注意original = original。clone（）；因为如果返回array再做修改的话
 * 会连同original一块修改
 * Random random = new Random（）
 * random。nextInt（）获取随机数
 * */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _384 {
    class Solution {
        private int[] array;
        private int[] original;
        private Random random;
        public Solution(int[] nums) {
            array = nums;
            original = nums.clone();
            random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            array = original;
            original = original.clone();
            return array;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            List<Integer> aux = new ArrayList<>();
            for(int num : array){
                aux.add(num);
            }
            for(int i = 0 ; i < array.length; i++){
                int index = random.nextInt(aux.size());
                array[i] = aux.get(index);
                aux.remove(index);
            }
            return array;
        }
    }
}
