public class _8_Myatoi {
    public int myAtoi(String str) {
        if(str.length()==0)
            return 0;
        int firstNonWhite = -1;
        int endIndex = str.length();
        boolean flag = false;
        int ans = 0;
        for(int i = 0 ;i<str.length();i++){
            if(str.charAt(i) != ' '){
                firstNonWhite = i;
                break;
            }
        }
        if(firstNonWhite == -1)
            return 0;
        if(!isNum(str.charAt(firstNonWhite))&&(str.charAt(firstNonWhite)!='+') && (str.charAt(firstNonWhite)!='-'))
            return 0;
        if((str.charAt(firstNonWhite) == '-') || (str.charAt(firstNonWhite) == '+')){
            if(str.charAt(firstNonWhite)=='-')
                flag = true;
            firstNonWhite++;
        }
        for(int i = firstNonWhite; i <str.length(); i++){
            if(!isNum(str.charAt(i))){
                endIndex = i;
                break;
            }
        }
        str = str.substring(firstNonWhite, endIndex);
        if(str.length()==1&&((str=="+")||(str=="-")))
            return 0;
        if(flag){
            for(int i = 0;i<str.length(); i++){
                int num = -1 * (str.charAt(i) - '0');
                if((ans < Integer.MIN_VALUE/10) || ((ans==Integer.MIN_VALUE/10)&&(num < Integer.MIN_VALUE%10)))
                    return Integer.MIN_VALUE;
                ans = ans*10 + num;
            }
        }
        else{
            for(int i = 0;i<str.length(); i++){
                int num = str.charAt(i) - '0';
                if((ans > Integer.MAX_VALUE/10) || ((ans==Integer.MAX_VALUE/10)&&(num > Integer.MAX_VALUE%10)))
                    return Integer.MAX_VALUE;
                ans = ans*10 + num;
            }
        }
        return ans;
    }
    public boolean isNum(char c){
        if(c-'0'<0 || c-'0'>9)
            return false;
        return true;
    }

}
