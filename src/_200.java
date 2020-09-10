/**
 * 类别：DFS
 *
 * 要点：与130题类似
 *
 * 将数组看成无向图，这个题目就是要找图里面的连通图的数量，因此从1开始的找到所有1的联通图，可以使用dfs，而这里每个节点链接四个其他节点，要都访问
 * 进行dfs的次数就是连通图个数
 *
 * 这里就对数组开始遍历，当从'1'开始的时候，进行dfs，将本次所经过的所有为'1'的节点改为'0'
 * 然后进行dfs的次数就是这里的结果
 * */
public class _200 {
    private int rows;
    private int columns;
    public int numIslands(char[][] grid) {
        int ans = 0;
        rows = grid.length;
        if(rows == 0)
            return 0;
        columns = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    private void dfs(char[][] grid, int x, int y){
        if(inArea(x,y) && grid[x][y] == '1') {
            grid[x][y] = '0';
            dfs(grid, x - 1, y);
            dfs(grid, x, y + 1);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
        }
    }
    private boolean inArea(int x, int y){
        return x>=0 && x < rows && y>=0 && y < columns;
    }

}
