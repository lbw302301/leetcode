/*
* 这里将罗马数字转换成整数的时候，需要从字符串的开始位置判断
* 特殊情况即为4 9 40 90 400 900，即所有的两个字符组成的特殊情况
* 其他时候存在几个罗马字符就是几个对应的数字相加即可
*
*
*
* */
import java.util.HashMap;
import java.util.Map;

public class _13_Roman_to_Integer {
    public int romanToInt(String s) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("CD", 400);
        map.put("XC", 90);
        map.put("XL", 40);
        map.put("IX", 9);
        map.put("IV", 4);
        int index = 0;
        while(index < s.length()){
            if(((index+1)<s.length()) && (map.containsKey(s.substring(index,index+2)))){
                result += map.get(s.substring(index,index+2));
                index += 2;
            }else{
                result += map.get(s.substring(index,index+1));
                index++;
            }
        }
        return result;
    }
}
