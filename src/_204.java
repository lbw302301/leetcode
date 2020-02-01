/**
 * 类别：素数
 *
 * 要点：判断是否素数，只需要判断在小于根号n的数字中，判断一个数是否还有除本身之外其他的除数
 * 这里进行了简化
 *
 * 1不是质数
 * */
import java.util.Arrays;

public class _204 {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i])
                for (int j = 2 * i; j < n; j += i)//所有i的倍数都不能是质数了
                    isPrime[j] = false;
        }
        for (int i = 2; i < n; i++)
            if (isPrime[i])
                count++;

        return count;
    }
}
