/**
 * 类别：数组
 *
 * 要点：这里对数组先排序
 * 然后计算len/2，如果奇数个则取len/2 + 1；以此分成两部分
 * 然后将排序好的两部分倒序交叉放到一个数组中，先放较小的一个数值
 * */
import java.util.Arrays;

public class _324 {
    public void wiggleSort(int[] nums) {
        //排序
        Arrays.sort(nums);
        int len=nums.length,i = 0;
        int[] smaller=new int[len%2==0?len/2:(len/2+1)],bigger=new int[len/2];
        //复制
        System.arraycopy(nums,0,smaller,0,smaller.length);
        System.arraycopy(nums,smaller.length,bigger,0,len/2);
        //穿插
        for (; i < len / 2; i++) {
            nums[2*i]=smaller[smaller.length-1-i];
            nums[2*i+1]=bigger[len/2-1-i];
        }
        if (len%2!=0) nums[2*i]=smaller[smaller.length-1-i];
    }
}
