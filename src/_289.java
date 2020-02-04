/**
 * 类别：数组 原地标记
 *
 * 要点：这里使用原地标记法；分四种情况，如果发生0-1变化记为3；1-0变化记为2；0-0记为0；1-1记为1
 *
 * 首先对数组进行遍历，使用check函数对每个点的周围八个点进行遍历，计算1的数目count，然后根据题目标记为上述四种情况
 * 统计的时候，情况2和1都表示count++；情况0和3表示count不变
 *
 * 再次遍历数组，根据0，1，2，3四种情况执行数值变化
 *
 * */
public class _289 {
    private int[][] board;
    public void gameOfLife(int[][] board) {
        this.board = board;
        int rows = board.length;
        int columns = board[0].length;
        for(int i = 0 ; i < rows; i++){
            for(int j = 0; j < columns; j++){
                board[i][j] = check(i,j);
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }
    private int check(int x, int y){
        int count = 0;
        int left = Math.max(0, y - 1);
        int right = Math.min(board[x].length - 1, y+1);
        int top = Math.max(0, x - 1);
        int bottom = Math.min(board.length - 1, x+1);
        for(int i = top; i <= bottom; i++ ){
            for(int j = left; j <= right; j++){
                if((i == x)&&(j == y))
                    continue;
                if((board[i][j] == 1) || (board[i][j] == 2))
                    count++;
            }
        }
        if(board[x][y] == 1){
            return (count > 3 || count < 2) ? 2 : 1;
        }else{
            return (count == 3) ? 3 : 0;
        }
    }

}
