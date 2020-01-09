/*
*类别：数组遍历
*
* 要点：注意可以分层次的读，先把矩阵最外一层的四周遍历，再遍历里面一层
* 注意边界值的情况，注意结束条件
* 注意当只剩一行或者一列这种特殊情况的处理(这时候，对上边或者右边遍历已经完成，无需再遍历其他两边)
*
*
* */
import java.util.ArrayList;
import java.util.List;

public class _54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return res;
        //找到四个角所对应的坐标
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while((up <= down) && (left <= right)){
            //对上边的值遍历
            for(int i = left; i <= right; i++)
                res.add(matrix[up][i]);
            //对右边的值遍历
            for(int i = up + 1; i <= down; i++)
                res.add(matrix[i][right]);
            //主要处理只剩下一行或者一列的情况，这时候前面的遍历已经覆盖，就不需要对下边或者左边遍历
            if(up < down && left < right){
                //对下边遍历
                for(int i = right - 1; i >= left; i--)
                    res.add(matrix[down][i]);
                //对左边遍历
                for(int i = down - 1; i >= up + 1; i--)
                    res.add(matrix[i][left]);
            }
            //读完一层之后，向内收缩再读一层
            up++;
            right--;
            left++;
            down--;
        }
        return res;
    }
}
