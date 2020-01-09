/**
 * 类别：数学问题 牛顿法
 *
 *
 *
 * */
public class _69 {
    public static int mySqrt(int x) {
        long a = x;
        while( a * a > x){
            a = (a + x/a) /2;
        }
        return (int)a;
    }
}
