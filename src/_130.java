/**
 * 类别：回溯 BFS
 *
 * 要点：与79题类似
 *
 * 首先，我们要从边缘点的O开始考虑，所有与这些点相连的O都不能被改写成X
 * 然后，从边缘上的第一个O开始，BFS找到所有的O，并且改写成#，用#表示这些已经访问过而且不能改写成X
 * 然后在对矩阵遍历一遍，将所有#改成O，所有O改成X
 *
 * BFS过程中要对一个的四个方向进行遍历，并且一旦超出矩阵范围或者为X或者#就return
 *
 *
 * */
public class _130 {
    private char[][] board;
    private boolean[][] visited;
    private int[][] direction = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private int rows;
    private int columns;

    public void solve(char[][] board) {
        this.board = board;
        rows = board.length;
        if(rows == 0)
            return;
        columns = board[0].length;
        visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                boolean isEdge = i == 0 || j == 0 || i == rows -1 || j == columns -1;
                if(isEdge && board[i][j] == 'O')
                    dfs(i, j);
            }
        }

        for(int i = 0; i < rows;i++){
            for(int j = 0; j < columns; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(int x , int y){
         if(!inArea(x, y) || board[x][y] == 'X' || board[x][y]== '#')
             return;
         board[x][y] = '#';
         dfs(x -1, y );
         dfs(x, y +1);
         dfs(x + 1, y );
         dfs(x,y - 1);
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < rows && y >=0 && y< columns;
    }

}
