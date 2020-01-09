/*
*类别：回文
*
*
* 第5题，通过中心扩展的方法获取最长的回文串，有两种情况。
* 第一种情况是回文串的长度为奇数，那么中心就有n个；第二种为偶数长度，则中心为s中两个元素的空白处，则有n-1个
* */
class LongestPalindromicSubstring {
    public String longestPalindrome(String s){
        if(null == s || s.length()<=1)
            return s;
        int start = 0;
        int end = 0;
        for(int i = 0;i<s.length();i++){
            //从元素扩展出奇数个的情况
            int len1 = expandAroundCenter(s, i, i);
            //从空白处扩展偶数个的情况
            int len2 = expandAroundCenter(s, i, i+1);
            //选择两个中其中较长的
            int len = Integer.max(len1, len2);
            //选择所有情况中较长的
            if(len > end -start + 1){
                //由于无论从元素扩展还是从空白扩展需要向后的位数都是长度的一半；但是偶数时，向左平移的位数需要考虑到i只能指向元素
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }
    public int expandAroundCenter(String s, int left, int right){
        while((left>=0)&&(right < s.length())&&(s.charAt(left)==s.charAt(right))){
            left--;
            right++;
        }
        return right - left -1;
    }
}
