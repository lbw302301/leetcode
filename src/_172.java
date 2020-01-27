/**
 * 类别：数学
 *
 * 要点：这里要找后缀0的个数就是要找有多少2*5，而分解出2的数量比5多，则转换为找5的数量
 *
 * 这里要找5的数量，就要从离阶乘最近的5*x构成的数字开始寻找，即n/5就可以找到最大的5*x构成的数字里5的个数，然后依次类推
 * 把找到的值相加即可。
 * */
public class _172 {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n>=5){
            count += n/5;
            n = n/5;
        }
        return count;
    }
}
