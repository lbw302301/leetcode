import java.util.HashMap;
import java.util.Map;

/**
 * 类别：
 * 要点：两种方法，
 * 解题中使用的方法，将两个字符串中遍历，用数组统计每个字母出现的次数，然后比较
 *
 * 第二种方法，使用map
 * */
public class _242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] sarg = new int[26];
        int[] targ = new int[26];
        for(int i = 0 ; i < s.length(); i++){
            sarg[s.charAt(i) - 'a']++;
            targ[t.charAt(i) - 'a']++;
        }
        for(int i = 0 ;i < 26;i++){
            if(sarg[i] != targ[i])
                return false;
        }
        return true;
    }
    public boolean isAnagram2(String s, String t){
        if(s.length() != t.length())
            return false;
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            if(!smap.containsKey(schar))
                smap.put(schar, 1);
            else
                smap.put(schar,smap.get(schar)+1);
            if(!tmap.containsKey(tchar))
                tmap.put(tchar, 1);
            else
                tmap.put(tchar,tmap.get(tchar)+1);
        }

        for(Character key : smap.keySet()){
            if(!smap.get(key).equals(tmap.get(key)))
                return false;
        }
        return true;
    }

}
