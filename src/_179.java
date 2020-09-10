/**
 * 类别：数组 comparator
 *
 * 要点：这里要使得拼接出来的结果最大，则要保证最高位的数最大，
 * 因此要对数组排序，排序依据就是两个数之间有两个拼接可能，
 * 谁在前拼接出来的结果越大，谁就越大
 *
 * ！！！这里要注意comparator的用法
 *
 * ！！！Arrays.sort（strs， new comparator（））
 *
 * */
import java.util.Arrays;
import java.util.Comparator;

public class _179 {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, new LargetstComparator());
        if(strs[0].equals("0"))
            return "0";
        for(String s : strs)
            sb.append(s);
        return sb.toString();
    }

    private class LargetstComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String com1 =  o1+o2;
            String com2 = o2+o1;
            //为了使数组按照从大到小的顺序排列
            return com2.compareTo(com1);
        }
    }

}
