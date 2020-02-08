/**
 * 类别：双指针
 *
 * 要点：这里要找交集，就是找出两个数组中都出现过的元素
 * 先将数组排序
 * 然后从头开始遍历，如果两个数相同，则放入nums1【k】上，k++，继续访问两个数组的下一位
 * 如果两数不等，则使数较小的那个下移一位，防止遗漏。
 * */
import java.util.Arrays;

public class _350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k= 0;
        while(i<nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]) {
                nums1[k++] = nums1[i];
                i++;
                j++;
            }else if(nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
}
