/*
* 类别：数据结构Map的使用
*
* 这里的问题可以看做是，将strs中的每一个str都分解成0#1#.....的格式，
* 代表str中有0个a，1个b.....以此当做map里的key，将符合的str添加到value中
* 然后每一个key的value是一个list，最终结果把map的所有结果都拼接到一个list中返回
*
*
* */
import java.util.*;

public class _49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] num = new int[26];
            for(int i = 0;i< s.length();i++){
                num[s.charAt(i)-'a']++;
            }
            String key = "";
            for(int j = 0; j < 26; j++){
                key = key + num[j] + "#";
            }
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else{
                map.put(key, new ArrayList<>(Arrays.asList(s)));
            }
        }
        return new ArrayList<List<String>>(map.values());
    }

}
