/**
 * 类别：位操作
 *
 * 与190题类似，这里将n&1，可以获取末位值，如果末位为1则count++
 * n >>= 1，则将n向右移动一位，这样可以对二进制的n进行遍历
 *
 * */
public class _191 {
    public int hammingWeight(int n) {
        int count = 0;
        int i = 0;
        while(i < 32){
            if((n & 1) == 1)
                count++;
            n >>= 1;
            i++;
        }
        return count;
    }
}
