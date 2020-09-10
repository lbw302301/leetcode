/**
 * 类别：二分法
 *
 * 要点：1.找出二维矩阵中最小的数left，最大的数right，那么第k小的数必定在left~right之间
 * 2.mid=(left+right) / 2；在二维矩阵中寻找小于等于mid的元素个数count
 * 3.若这个count小于k，表明第k小的数在右半部分且不包含mid，即left=mid+1, right=right，又保证了第k小的数在left~right之间
 * 4.若这个count大于k，表明第k小的数在左半部分且可能包含mid，即left=left, right=mid，又保证了第k小的数在left~right之间
 * 5.因为每次循环中都保证了第k小的数在left~right之间，当left==right时，第k小的数即被找出，等于right
 *
 * 注意：这里的left mid right是数值，不是索引位置。
 *
 * */
public class _378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n-1];
        while(left < right){
            int mid = (left + right) / 2;
            int count = find(matrix, mid, n);
            if(count < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private int find(int[][] matrix, int target,int n){
        int i = n - 1;
        int j = 0;
        int count = 0;
        while(i >= 0 && j < n){
            //当第i行，j列的数组小于target时，0 -- i-1行的j列都小与target，count才如此计算
            if(target >= matrix[i][j]){
                count += i + 1;
                j++;
            }else{
                i--;
            }
        }
        return count;
    }
}
