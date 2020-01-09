/*类别：回文数
* 不要考虑转换成字符串，再通过中心扩展的方法解决问题，这样导致时间过长
* */
class _9_Palinddrome_Number {
    public boolean isPalindrome(int x){
        if(x < 0)
            return false;
        int cur = x;
        int ans = 0;
        int pop = 0;
        while(cur!=0){
            pop = cur % 10;
            cur = cur / 10;
            if((ans > Integer.MAX_VALUE/10) || ((ans == Integer.MAX_VALUE)&&pop>7))
                return  false;
            ans = ans*10+pop;
        }
        if(ans == x)
            return true;
        else
            return false;
    }
}
