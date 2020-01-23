/**
 * 类别：递归
 *
 * 要点：采用记录状态减少递归中重复的操作
 * 首先考虑从头开始，先找到第一个存在于词典中的词语前缀，然后对前缀后边的部分重复操作，
 * 如果后边部分return false，则尝试将首个前缀扩张看能否找到更长匹配
 * 递归出现在上方所述过程
 * memo用来存储从当前index开始寻找词语的状态，如果遍历过且符合条件为true，否则为false
 * 这样memo可以用来避免重复的操作
 *
 * */
import java.util.List;

public class _139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s,wordDict,0,new Boolean[s.length()]);
    }

    private boolean helper(String s, List<String> wordDict,int start,Boolean[] memo){
        if(start == s.length())
            return true;
        if(memo[start] != null)
            return memo[start];
        for(int end = start + 1; end<=s.length();end++){
            if(wordDict.contains(s.substring(start,end)) && helper(s,wordDict,end,memo))
                return memo[start] = true;
        }
        return memo[start] = false;
    }


}
