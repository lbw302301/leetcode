import java.util.ArrayList;
/*
* 这里都过找到每一个元素的数学规律，遍历s的所有元素，用矩阵表示结果则可以将每一行视作一个StringBuilder
* 然后用ArrayList表示有几行，这样就可以按照顺序依次计算行数，然后添加到相应的行中，
* ****************对字符串进行拼接操作时StringBuilder更高效，StringBuffer则是对同步更友好***********
* */
class ZigZagConversion {
    public String convert(String s, int numRows){
        StringBuilder ret =  new StringBuilder();
        if(numRows == 1)
            return s;
        int zigNums = numRows + numRows - 2;
        ArrayList<StringBuilder> rows = new ArrayList<>();
        for(int i = 0;i<numRows;i++){
            rows.add(new StringBuilder());
        }
        for(int i = 0 ; i<s.length();i++){
            int curRow = (i % zigNums) > (numRows - 1)? zigNums - i % zigNums : (i % zigNums);
            rows.get(curRow).append(s.charAt(i));
        }
        for(StringBuilder row : rows){
            ret.append(row);
        }
        return ret.toString();
    }

}
