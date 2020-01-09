/**
 *
 * 类别： 双指针
 *
 * 要点：要仔细考虑降低时间和空间复杂度
 *
 *
* */
import java.util.Arrays;

public class _88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*方法1  先合并再排序*/
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        /*方法2 双指针，因为数组已经提前排好序
        *
        * 要实现空间复杂度最高，则不申请额外空间，就从num1的末尾开始插入最大值*/
        int p1 = m - 1;//p1指示num1中的最大值
        int p2 = n - 1;
        int p = m + n - 1;//p指示应该插入的位置
        while((p1 >= 0)&&(p2 >= 0)){
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);//将nums2中的剩余部分复制过去，因为nums1是目标地址因此不需要整体复制
    }
}
