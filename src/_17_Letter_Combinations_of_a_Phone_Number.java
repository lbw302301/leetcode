/*
* 类别：回溯
*
* 回溯的定义就是通过穷举所有可能的情况来找到所有解的算法，如果一个候选解最后发现不是可行解，则返回到之前的步骤做修改
* 在这里，当把digits即给定的输入读到最后一位时，认为其遇到困难，则回退到上一步进行数字对应的字母的选择，这样可以完成遍历
*
*
* */

import java.util.*;

public class _17_Letter_Combinations_of_a_Phone_Number {
    List<String> res = new ArrayList<>();
    Map<String, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        if(digits.length() != 0)
            backtrack("", digits);
        return res;
    }

    public void backtrack(String sb, String digits){
        if(digits.length() == 0)
            res.add(sb.toString());
        else{
            String digit = digits.substring(0, 1);
            String letters = map.get(digit);
            for(int i = 0; i<letters.length(); i++){
                backtrack( sb + (letters.substring(i, i+1)), digits.substring(1));
            }
        }
    }
}
