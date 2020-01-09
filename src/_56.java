/**
 * 类别：数组、collections的排序
 *
 * 思路：可以将所有的区间范围排序，则可以从左向右开始遍历并合并
 *
 * 注意collections的排序
 *
 * list.sort()
 *new Comparator<T>(){
 *   @override
 *   public int compare(T o1, T o2){
 *       todo yourself;
 *   }
 *}
 *
 *
 *
 * */

import java.util.*;

public class _56 {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++)
            list.add(intervals[i]);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0])
                    return 1;
                else if(o1[0] == o2[0])
                    return 0;
                else
                    return -1;
            }
        });
        for(int[] interval : list){
            //如果结果为空或者结果中的最后一个范围与当前所指的范围不重合，则直接添加到结果中
            if(res.isEmpty() || (res.getLast()[1] < interval[0]))
                res.add(interval);
            //因为结果集中可能包含当前所指的前一个或者是前一个范围合并后的结果（永远表示的意思都是与当前所指重合），则合并到结果集末尾
            else{
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            }
        }
        int[][] result = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
