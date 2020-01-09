/**
 * 类别：动态规划
 *
 * 要点:通过上一行计算出下一行的结果即可
 * 如preRow[0] + preRow[1] = curRow[1];
 *   curRow[numRow - 2] = preRow[preNum - 2] + preRow[preNum - 2 + 1]
 *
 *
 * */
import java.util.ArrayList;
import java.util.List;

public class _118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;
        List<Integer> row = new ArrayList<>();
        row.add(1);
        res.add(row);
        if (numRows == 1)
            return res;
        row = new ArrayList<>();
        row.add(1);
        row.add(1);
        res.add(row);
        if (numRows == 2)
            return res;
        for (int i = 3; i <= numRows; i++) {
            row = new ArrayList<>();
            row.add(1);
            List<Integer> preRow = res.get(i - 2);
            int len = preRow.size();
            //
            for (int j = 0; j < len - 1; j++)
                row.add(preRow.get(j) + preRow.get(j + 1));
            row.add(1);
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        generate(5);
    }
}
