/*
* 主要找规律，下一行是把上一行读出来
* 1. 1
* 2. 11
* 即第二行表示第一行有1个1
*
* */
import java.util.HashMap;
import java.util.Map;

public class _38 {
    public String countAndSay(int n){
        return getList(n).get(n);
    }

    public Map<Integer, String> getList(int n){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        for(int i = 2; i <= n; i++){
            String ans = "";
            String s = map.get(i - 1);
            map.put(i, getSay(s));
        }
        return map;
    }

    public String getSay(String s){
        String ans = "";
        int count;
        for(int i = 0; i < s.length(); i++){
            int current = i + 1;
            String temp = "" + s.charAt(i);
            count = 1;
            while((current < s.length()) && (s.charAt(i) == s.charAt(current))){
                count++;
                current++;
                i++;
            }
            ans = ans + count + temp;
        }
        return ans;
    }

}
