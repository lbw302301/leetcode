/**
 * 类别：数学
 *
 * 要点：这里3的幂，就是3的几次方，可以最简单的，使用n/3，判断每次除三能否被整除即可
 *
 * 或者使用第二种方法，计算出每个3的次方数，然后和n比较，但是计算次方的过程太复杂，时间复杂度高
 * */
public class _326 {
    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree2(int n) {
        for (int i = 0; Math.pow(3,(double) i) < Integer.MAX_VALUE; i++)
            if (Math.pow(3, (double) i) == n)
                return true;

        return false;
    }
}
