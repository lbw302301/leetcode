/**
* 类别：递归法
*
* 要点：通过一分为二的方法，只需要一般的工作量即可,即如果是2的4次方,则可以先算2的2次方，然后结果相乘
* 如果算2的5次方，则先算2的2次方，相乘再多乘一个2
*
*
*
* */

public class _50 {
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

}
