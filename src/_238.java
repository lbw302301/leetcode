/**
 * 类别：动态规划  左右乘积表
 *
 * 注意动态规划中，常规使用dp【】数组，但是可以根据情况只保留i之前的一个或者两个必要值以节约空间
 * 要点：这里可以先计算出每个数字对应的 左乘积和右乘积
 * L【0】 = 1，L【i】= L【i-1】*nums【i-1】；R同理
 * 然后L*R即可得到最终结果
 *
 * 这里进行了优化，不保留L R表
 * 先使用ans数组存储计算出来的左乘积
 * 然后倒序遍历数组，计算出右乘积再与ans中的左乘积相乘存到ans中
 * */
public class _238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int sum = 1;//等效于给L【0】一个初始值1，sum用于保留i-1的nums【i-1】*L【i-1】
        for(int i = 0; i < nums.length; i++){
            ans[i] = sum;//ans相当于L，给L[i]赋值
            sum *= nums[i];
        }

        //倒序，计算右乘积
        sum = 1;//sum用于保留i的nums【i+1】*R【i+1】
        for(int i = nums.length - 1; i >=0;i--){
            ans[i] *= sum;//给ans赋值，L【i】*R【i】
            sum *= nums[i];
        }
        return ans;
    }

}
