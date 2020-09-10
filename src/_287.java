/**
 * 类别：抽屉原理 二分法
 *
 * 要点：这里应用抽屉原理
 *
 * 以 [1, 2, 2, 3, 4, 5, 6, 7] 为例，一共 8 个数，n + 1 = 8，n = 7，
 * 根据题目意思，每个数都在 1 和 7 之间。
 *
 * 例如：区间 [1, 7] 的中位数是 4，遍历整个数组，
 * 统计小于等于 4 的整数的个数，至多应该为 4 个。换句话说，整个数组里小于等于 4 的整数的个数如果严格大于 4 个，
 * 就说明重复的数存在于区间 [1, 4]，它的反面是：重复的数存在于区间 [5, 7]。
 *
 * 于是，二分法的思路是先猜一个数（有效范围 [left, right]里的中间数 mid），
 * 然后统计原始数组中小于等于这个中间数的元素的个数 cnt，如果 cnt 严格大于 mid，
 * （注意我加了着重号的部分“小于等于”、“严格大于”）依然根据抽屉原理，
 * 重复元素就应该在区间 [left, mid] 里。

 * */
public class _287 {
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            int count = 0;
            for(int num : nums){
                if(num <= mid)
                    count++;
            }
            if(count > mid)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
