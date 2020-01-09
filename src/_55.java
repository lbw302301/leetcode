/**
 *类别：动态规划法
 *
 * 动态规划法就是讲每个点的状态进行保留，这样就可以减少计算次数
 *
 * 要点： 1.通过一个数组来保存从某个点开始起跳，能否到达末尾
 *        2.这样整个问题就可以拆分成 计算从每个点开始能否到达末尾
 *        3.从最右边的倒数第二个开始，算出当前点能到达的最远距离，然后判断从当前点开始到最远点之间是否存在一点可以到达末尾，如果存在，则证明此点也可以
 *        4.对于nums中的每个点重复上述操作，
 *        5.得出结果
 *
 */

public class _55 {
    public boolean canJump(int[] nums) {
        int[] canReachEnd = new int[nums.length];//0代表未计算。1代表可以到。2表示不可以到
        canReachEnd[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            int furthest = Math.min(i + nums[i], nums.length - 1);//从当前点可以跳到的最远距离，如果超过最后一位，则就可以认为成功了
            for(int j = i + 1; j <= furthest; j++){
                if(canReachEnd[j] == 1) {
                    canReachEnd[i] = 1;
                    break;
                }
            }
        }
        return (canReachEnd[0] == 1);
    }

    }
