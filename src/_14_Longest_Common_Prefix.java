/*
* 最长前缀问题，没有太多的捷径可走，因为是前缀，所以必须从字符串的最开始一位寻找
* 那么可以考虑strs中strs[0]和剩余其他项分别的最长前缀，即从strs[0]本身开始，逐渐变短
*
* 简便方法—————可以通过对strs中找到最短长度的串minLen，然后对minLen进行二分法，如果
* substring(0, minLen/2)中有最长前缀则载扩大minLen的值即把前置再加长
* 如果没有的话，则继续缩减minLen/2；然后重复此过程，直至找到一个minLen合适的位置且其值最大
* 即通过在最短串中寻找一个合适的前缀结束点
*
*
*
* */

public class _14_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";

        String prefix = strs[0];
        for(int i = 1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}
