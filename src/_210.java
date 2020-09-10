/**
 * 类别：有向图
 * 要点：与207题一样
 *
 * 这道题要找到一中遍历所有节点的路径
 * 这里使用BFS方法；首先构建所有点的入度，这里就是不使用循环的方法将所有不联通的部分都访问
 *
 * 首先将所有入度为0的点入队，然后当队列不为空时将队首元素出队，将此元素放入结果数组
 * 将所有出队点指向的点的入度 -1 ，然后再将入度为0的入队
 * 重复上述过程，直至队列为空
 *
 * */
import java.util.LinkedList;
import java.util.Queue;

public class _210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[][] adjacency = new int[numCourses][numCourses];
        int[] order = new int[numCourses];
        for(int[] cp : prerequisites){
            indegree[cp[0]]++;//构建入度表
            adjacency[cp[1]][cp[0]] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        //入度为0的入队
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        int index = 0;//用于记录结果数组中存放的点个数
        while (!queue.isEmpty()) {
            //队首出队并且放入结果中
            int cur = queue.remove();
            order[index++] = cur;
            //将此元素的邻接点的入度减一，并且将入度为0的入队
            for (int j = 0; j < numCourses; j++) {
                if (adjacency[cur][j] == 1) {
                    indegree[j]--;
                    if (indegree[j] == 0)
                        queue.add(j);
                }
            }
        }
        if (index == numCourses)
            return order;
        return new int[0];
    }
}
