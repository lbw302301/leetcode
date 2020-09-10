/**
 * 类别：双指针 最长子串 递归
 *
 * 要点：这里可以采用分治法处理或者叫递归，将找符合要求最长的过程化为双指针指向头尾，然后根据要求对前后指针分别收缩
 * 这样在第一次完全符合要求的地方停下
 *
 *  双指针首先指向头尾
 *
 * */
public class _395 {
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if(len == 0 || k > len)
            return 0;
        if(k < 2)
            return len;
        return count(s, 0, len - 1, k);
    }

    private int count(String s, int start, int end, int k){
        if((end - start + 1) < k)
            return 0;
        int[] ans = new int[26];
        //首先对这个范围统计词频
        for(int i = 0; i<= end; i++){
            ans[s.charAt(i) - 'a']++;
        }
        //从start端开始，将开头处的不符合要求的跳过
        while((end - start + 1) >= k && ans[s.charAt(start)-'a'] < k)
            start++;
        //从end端开始，将末尾的不符合要求的跳过，缩小范围
        while((end - start + 1) >= k && ans[s.charAt(end)-'a'] < k)
            end--;
        //如果处理完两头，发现长度小于k，则返回0，证明不符合要求
        if((end - start + 1) < k)
            return 0;
        //从处理过头尾的，start处开始遍历到end处，寻找不符合要求的点i，并且从此处分割，分别递归两个子集，直接返回最大值
        for(int i = start;i <= end; i++){
            if(ans[s.charAt(i) - 'a'] < k)
                return Math.max(count(s, start, i - 1,k), count(s, i + 1, end,k));
        }
        //如果去掉头尾后，中间没有不合条件的点，则直接把这个范围返回
        return end - start + 1;
    }
}
