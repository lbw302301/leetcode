import java.util.HashSet;
import java.util.Set;

public class _73 {
    //解法一，此时空间占用大
    public void setZeroes(int[][] matrix) {
        Set<Integer> zeroColumn = new HashSet<>();
        Set<Integer> zeroRow = new HashSet<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    zeroColumn.add(j);
                    zeroRow.add(i);
                }
            }
        }
        for(Integer column : zeroColumn){
            for(int i = 0; i < matrix.length; i++)
                matrix[i][column] = 0;
        }

        for(Integer row :zeroRow){
            for(int j = 0; j < matrix[0].length; j++)
                matrix[row][j] = 0;
        }
    }

    //解法二，占用空间小
    public void setZeroes2(int[][] matrix){
        //这种方法将数组的第一列和第一排当做存储此列、此行是否要设置为0的信息
        boolean isCol = false;
        for(int i = 0; i < matrix.length; i++){
            //判断第一列原本存不存在0
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            //如果当前访问元素为0，则将对应行列的首元素设成0
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //根据首元素情况，将数组内部变成0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //判断第一行是否需要设成0
        if(matrix[0][0] == 0){
            for(int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
        }
        //判断第一列是否需要设成0
        if(isCol){
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }

    }
}
