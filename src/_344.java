/**
 * 类别：双指针
 *
 * 要点：从开始和末尾开始遍历，将两个元素互换位置即可
 * */
public class _344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
