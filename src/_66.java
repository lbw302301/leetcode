/**
 * 类别：简单的数组更换
 *
 *
 *
 * */
public class _66 {
    public int[] plusOne(int[] digits) {
        int jinwei = (digits[digits.length - 1] + 1 ) / 10;
        digits[digits.length - 1] = (digits[digits.length - 1] + 1 ) % 10;
        for(int i = digits.length - 2; i >= 0; i--){
            int add  = digits[i] + jinwei;
            if(add >= 10){
                jinwei = 1;
                digits[i] = add - 10;
            }else{
                jinwei = 0;
                digits[i] = add;
            }
        }
        if(jinwei == 1){
            int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
