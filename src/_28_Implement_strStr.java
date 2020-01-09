public class _28_Implement_strStr {
    public static int strStr(String haystack, String needle) {
        if(needle == null)
            return 0;
        if(needle.length() > haystack.length())
            return -1;
        if(needle==""&&haystack=="")
            return 0;
        int length = needle.length();
        for(int i = 0;i<haystack.length()-length;i++){
            if(haystack.substring(i, i+length).equals(needle))
                return i;
        }
        return -1;
    }
}
