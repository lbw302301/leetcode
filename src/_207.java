/**
 * 类别：有向图
 *
 * 要点：这个题所说的意思，就是在图中将有先后关系的课变成有向图中的两个点
 * 这里的结果就是要判断有向图是否有环！！
 *
 * 首先将课程关系换成邻接矩阵表示的有向图，矩阵的长宽均为课程数！
 *
 * 那么最简单的方式就是，从一个点都开始进行一次DFS，如果访问到一个访问过的点就证明有环，return false
 * DFS的过程中，对每个点维持三种状态，0未访问、1表示在从某一点开始的DFS中正在进行DFS的一条路中访问过；
 * -1表示在从某个点开始DFS时，这个点已在其他路中遍历过无需重复，
 * 即当前节点的所有邻接节点都被访问过。！！！注意主要是这一个条件达成即可置为-1，减少重复
 * */
public class _207 {
    private int[][] adjacency;
    private int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjacency = new int[numCourses][numCourses];
        visited = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adjacency[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        //这个循环是为能够保证孤立的点也被访问到
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i))
                return false;
        }
        return true;
    }

    private boolean dfs(int start) {
        if (visited[start] == 1)
            return false;
        if (visited[start] == -1)
            return true;
        visited[start] = 1;//当前dfs路中访问这个点
        for (int j = 0; j < adjacency.length; j++) {
            if ((adjacency[start][j] == 1) && !dfs(j))
                return false;
        }
        //从这个点它的所有可能邻接节点都已经访问过
        visited[start] = -1;
        return true;
    }

}
