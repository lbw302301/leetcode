/**
 * 类别：字母排序 哈希表
 *
 * 要点：这里先统计每个字母出现次数
 * 然后再对字符串遍历，查看此字母出现次数是否为1，是则返回index；否则继续循环
 *
 *
 * */
import java.util.HashMap;
import java.util.Map;

public class _387 {
    public int firstUniqChar(String s) {
        int[] ans = new int[26];
        for(int i = 0 ; i < s.length(); i++){
            ans[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < s.length(); i++){
            if(ans[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;

    }

    public int firstUniqChar2(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        for(int i = 0 ; i < s.length();i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
