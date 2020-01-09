/*
* 在这里需要从最高位开始判断，即千位，用m记录当前执行的是哪一位
* 用count记录当前位上的数值，如1994，则开始m=1000.count=1,
* 再依次向低位操作
* 其中注意count进行分类，其中4,9为两种特殊情况，要通过这两个值进行判断条件分割
*
* */
import java.util.HashMap;
import java.util.Map;

public class _12_Integer_to_Roman {
    public String intToRoman(int num) {
        if(num > 3999 || num < 1)
            return null;
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10,"X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        int m = 1000;
        while (m > 0){
            int count = num / m;
            num = num % m;
            if(count==9){
                sb.append(map.get(m) + map.get(m * 10));
            }
            else if(count >= 5){
                sb.append(map.get(m*5));
                while(count-->5)
                    sb.append(map.get(m));
            }
            else if(count == 4){
                sb.append(map.get(m)+map.get(5*m));
            }
            else if(count > 0){
                while(count-->0){
                    sb.append(map.get(m));
                }
            }
            m /= 10;
        }
        return sb.toString();
    }
}
