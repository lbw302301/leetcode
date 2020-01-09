/**
 * 类别：双指针   回文
 *
 * 要点：通过双指针夹逼，只要使得从中间镜像对称即可，即i从开始遍历，j从末尾开始遍历，完全一致即为回文
 *
 * 注意使用库函数Character.isLetterOrDigit来去掉非字母或者数字。
 *
 * */
public class _125 {
    public boolean isPalindrome(String s) {
        if(s.length() == 0)
            return true;
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
