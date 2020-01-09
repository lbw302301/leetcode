/*
* 类别：数组遍历
*
* 要点：这里主要注意数独成立的几个条件，先判断一个数在这一列是否重复，再判断行中是否重复，再判断小块重复
* 然后对整个数组遍历，对每一个元素执行上述操作
*
* */
public class _36_ {
    public boolean isValidSudoku(char[][] board) {
        boolean flag = true;
        if(board == null)
            return false;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if((board[i][j] != '.') && ((board[i][j] - '1') >= 0)&&((board[i][j] - '1') <= 8)) {
                    if (!isValid(i, j, board))
                        flag = false;
                    else
                        continue;
                }
                else if(board[i][j] == '.')
                    continue;
                else
                    return false;
            }
        }
        return flag;
    }

    public boolean isValid(int row, int column, char[][] board){
        //在column列是否有效
        for(int j = 0; j < 9; j++){
            if((board[row][column] == board[row][j]) && (j != column))
                return false;
        }
        //在第row行是否有效
        for(int i = 0; i < 9; i++)
            if((board[row][column] == board[i][column]) && (i != row))
                return false;
        //判断在所处的小块内是否有重复
        int rowBegin = (row / 3) * 3;
        int rowEnd = rowBegin + 2;
        int columnBegin = (column / 3) *3;
        int columnEnd = columnBegin + 2;
        for(int i = rowBegin; i <= rowEnd; i++)
            for(int j = columnBegin; j <= columnEnd; j++)
                if((board[i][j] == board[row][column]) && ( i != row) && ( j != column))
                    return false;
        return true;
    }
}
