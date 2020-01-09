/**
 * 类别：三指针排序问题  荷兰国旗
 *
 * 要点：
 *
 *
 * */
public class _75 {
    public void sortColors(int[] nums) {
        int p0 = 0;//指向0区域的最右端
        int p2 = nums.length - 1;//指向2区域的最左端
        int cur = 0;//指向当前处理的元素
        while(cur <= p2){
            if(nums[cur] == 0){
                int temp = nums[p0];
                nums[p0] = nums[cur];
                nums[cur] = temp;
                cur++;//因为当前指向的值处理完毕，因此向右平移
                p0++;//因为0区域多了一个成员因此要向右平移
            }else if(nums[cur] == 1)
                cur++;
            else if(nums[cur] == 2){
                int temp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
        }
    }
}
