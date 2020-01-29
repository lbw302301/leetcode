/**
 * 类别：位操作
 * 要点：要将二进制数颠倒
 * */
public class _190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int i = 0;
        int tmp = 0;
        while(i<32){
            tmp <<= 1;//tmp左移，为新来元素空出位置，注意tmp刚开始为0，远远到不了32位，所以不存在溢出的情况
            tmp |= (n & 1);//将n的最低位添加到tmp，这里n&1，表示n除了最后一位表示正确值，其他位都被置为0；和tmp 与 操作
            n >>= 1;//n右移 去掉刚刚处理的最低位
            i++;
        }
        return tmp;
    }
}
