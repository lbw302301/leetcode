/**
 * 类别：双指针 快慢指针
 * 要点：快乐数的定义就是在计算过程中如果出现循环，则不是快乐数
 *
 * 方法一：使用快慢指针，快指针计算一次，慢指针计算两次，如果有循环，则slow==fast
 *        这时候查看指针值是否为1，如果为1就是快乐数
 *
 * 方法二：使用set，判断某个按位乘方计算出的值是否存在，如果存在则不是快乐数；
 *        重复按位计算如果在循环计算中计算出1，则跳出计算循环；如果计算出存在的数return false
 * */
public class _202 {
    private int bitsquare(int n){
        int sum = 0;
        while(n > 0){
            int bit = n % 10;
            sum += bit * bit;
            n = n /10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = bitsquare(n);
        int fast = bitsquare(n);
        fast = bitsquare(fast);
        while(slow != fast){
            slow = bitsquare(slow);
            fast = bitsquare(fast);
            fast = bitsquare(fast);
        }
        return slow == 1;
    }
}
