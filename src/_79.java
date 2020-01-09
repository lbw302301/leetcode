/**
 * 类别： 回溯法、DFS
 *
 * 要点：这里的相邻指的是上下左右相邻，因此首先要确定一个寻找方向顺序（上右下左）
 *       这里可以从第一个找到匹配的地方开始深度遍历，而深度遍历的顺序就要遵循上边的方向顺序，通过一个marked数组标识是否已经访问此点
 *       direction用来标注board中一个点的四种访问方向，
 *       在遍历中如果找到了不匹配的点则立即回溯到上一个状态，然后从上一个状态的下一个方向继续寻找
 *
 *
 *
 * */
public class _79 {
    private boolean marked[][];
    private int[][] direction= {{0,-1},{1,0},{0,1},{-1,0}};
    private int rows;
    private int columns;
    private String word;
    private char[][] board;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        if(rows == 0)
            return false;
        columns = board[0].length;
        marked = new boolean[rows][columns];
        this.board = board;
        this.word = word;
        //从这里开始寻找第一个匹配点
        for(int i = 0 ;i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(dfs(i, j , 0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(int i , int j, int start){
        if(start == word.length() - 1)
            return board[i][j] == word.charAt(start);
        if(board[i][j] == word.charAt(start)){
            marked[i][j] = true;
            for(int k = 0; k < 4;k++){
                int nextX = i + direction[k][0];
                int nextY = j + direction[k][1];
                if(inArea(nextX, nextY) && !marked[nextX][nextY]){
                    if(dfs(nextX, nextY, start + 1))
                        return true;
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < columns;
    }

}
