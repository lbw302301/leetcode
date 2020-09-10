/**
 * 类别：进制转换
 *
 * 要点：26进制转成十进制
 * */
public class _171 {
    public int titleToNumber(String s) {
        if(s.length() == 0)
            return -1;
        int length = s.length() - 1;
        double ans = 0;
        for(int i = 0; i <= length; i++){
            ans += (s.charAt(i) - 'A' + 1) * Math.pow(26, length - i);
        }
        return (int)ans;
    }
}
