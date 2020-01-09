/*
*
* 一定要注意边界问题
*
*  思路为：通过辗转相减的方法，来不断让除数逼近被除数。
* 为了减少循环次数，则可以通过对被除数每次都翻倍的方法进行增加
*
*
*
* */
public class _29_Divide_two_integer {
    public int divide(int dividend, int divisor) {
        long result = 0;
        if (dividend == 0)
            return 0;
        if(divisor == 1)
            return dividend;
        if(divisor == -1){
            if(dividend > Integer.MIN_VALUE)
                return -dividend;
            else
                return Integer.MAX_VALUE;
        }
        if(divisor == dividend)
            return 1;
        boolean flag = true;//标识最后的结果是否为负
        if((dividend < 0 && divisor >0) || (dividend > 0 && divisor < 0))
            flag = false;
        long temp_dividend = (long)dividend;
        long temp_divisor = (long)divisor;
        if(temp_dividend < 0)
            temp_dividend = -temp_dividend;
        if(temp_divisor < 0)
            temp_divisor = -temp_divisor;
        while(temp_dividend >= temp_divisor){//外层循环保证，当除数增长以后大于被除数的情况
            long k = 1;
            long temp = temp_divisor;
            while(temp_dividend >= temp) {//除数成倍增长过程
                temp_dividend -= temp;
                result += k;
                temp += temp;
                k += k;
            }
        }
        if(flag){
            if(result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else
                return (int)result;
        }else{
            if(-result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else
                return (int)(-result);
        }
    }
}
