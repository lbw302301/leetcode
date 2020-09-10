/**
 * 类别：数组
 * 要点：这里注意观察规律，每行都是递增、每列都是递增，但是行列之间没有大小限制
 * 这里要发现，从左下角或者右上角移动，会导致一个方向增、一个方向减
 * 这样可以利用这个特点，从左下角或者右上角开始，
 * 举例从左下角开始，如果当前数字小于target，则可以向右移动增大，
 * 若大于target，则可以向上移动减小
 * 这样最终直至找到target，否则返回false；
 * */
public class _240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int column = 0;
        while(row >= 0 && column < matrix[0].length){
            if(matrix[row][column] > target)
                row--;
            else if(matrix[row][column] < target)
                column++;
            else if(matrix[row][column] == target)
                return true;
        }
        return false;
    }
}
