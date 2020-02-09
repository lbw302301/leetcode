/**
 * 类别：流程控制
 * */
import java.util.ArrayList;
import java.util.List;

public class _412 {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        int count = 1;
        while(count <= n){
            if( count % 15 == 0)
                ans.add("FizzBuzz");
            else if(count % 5 == 0)
                ans.add("Buzz");
            else if(count % 3 == 0)
                ans.add("Fizz");
            else
                ans.add(String.valueOf(count));
            count++;
        }
        return ans;
    }
}
