/**
 * 类别：数组
 *
 * 要点：根据k找到整个数组翻转的点，然后每次都将翻转点前的数字都后移，将翻转点后的一个数字放到最终位置，
 * k是几代表翻转点后有几个点，整个过程就重复几次
 * */
public class _189 {
    public void rotate(int[] nums, int k) {
        int rotation = nums.length - (k % nums.length);
        int begin = 0;
        //while代表从length-k到length-1的点每个都需要平移到数组0---（k-1）的位置
        while(rotation < nums.length){
            int temp = nums[rotation];
            //所有的元素后移
            for(int i = rotation; i > begin; i--)
                nums[i] = nums[i - 1];
            nums[begin] = temp;
            begin++;
            rotation++;
        }
    }
}
