import java.util.Arrays;
import java.util.Comparator;

public class AliBaBatest2 {
    public static void main(String[] args){
        int n = 4;
        String[] strs = {"aaa","bcd","zzz","abcdef"};
        Arrays.sort(strs, new Mycomparator());
        int[] dp = new int[n];
        int[] pre = new int[n];
        for(int i = n - 1; i >= 0; i--){
            for(int j = i -1; j >= 0; j--){
                if(strs[i].charAt(0) >= strs[j].charAt(strs[j].length() - 1)) {
                    pre[i] = j;
                    break;
                }
            }
        }
        dp[0] = strs[0].length();
        int max = 0;
        for(int i = 1; i < n; i++){
            dp[i] = dp[pre[i]] + strs[i].length();
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }

    static class Mycomparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            char c1 = o1.charAt(o1.length() - 1);
            char c2 = o2.charAt(o2.length() - 1);
            if(c1 > c2)
                return 1;
            else if(c1 < c2)
                return -1;
            else
                return 0;
        }
    }
}
