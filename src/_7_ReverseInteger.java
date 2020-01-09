/*
* 类别：数字转换
* 这里要考虑x%10，如果x为负数，则余数也为负数
* 另外如果要将一个数字反过来只需要，取余得到最后一位然后再乘10，此后每多一位就乘一次10
*
* ！！！！！！！！！！！！！注意这里一定要判断整数的边界，Integer的最大和最小都能通过MAX_VALUE
* ！！！！！！！！！！！！！获得，而且要先判断少一位时是否越界，否则就不需要多计算一次
* */

class ReverseInteger {
    public int reverse(int x) {
        int ans = 0;
        int pop = 0;
        while(x != 0){
            pop = x % 10;
            x = x/10;
            if((ans > Integer.MAX_VALUE/10) || (ans == Integer.MAX_VALUE/10 && pop>Integer.MAX_VALUE%10))
                return 0;
            if((ans < Integer.MIN_VALUE/10) || (ans == Integer.MIN_VALUE/10 && pop<Integer.MIN_VALUE%10))
                return 0;
            ans = ans * 10 + pop;
        }
        return ans;
    }
}
