/**
 * 类别：哈希表 除法
 *
 * 要点：这里使用长除的方法，即按照竖式的计算过程开始计算
 * 如果每次除完以后，余数循环证明商的小数部分也循环
 * 使用map记录每一个余数以及这个余数对应商放在结果string中的下标，如果循环则可以快速插入括号
 *
 * 注意使用long避免溢出
 * */
import java.util.HashMap;
import java.util.Map;

public class _166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0 || denominator < 0) && !(numerator < 0 && denominator < 0))
            sb.append("-");
        long chushu = Math.abs(Long.valueOf(numerator));
        long beichushu = Math.abs(Long.valueOf(denominator));
        sb.append(chushu / beichushu);
        long reminder = chushu % beichushu;
        if (reminder == 0)
            return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        //
        while (reminder != 0) {
            //这里通过map取出循环的余数所对应的下标，插入括号
            if (map.containsKey(reminder)) {
                sb.insert(map.get(reminder), "(");
                sb.append(")");
                break;
            }
            //如果此时余数还未重复，则直接插入map
            map.put(reminder, sb.length());
            //此时计算余数对应的商，并放入string里
            reminder *= 10;
            sb.append(reminder / beichushu);
            reminder %= beichushu;
        }
        return sb.toString();
    }
}
