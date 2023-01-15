class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res=Integer.MAX_VALUE;
        int sum=0;
        int i=0;//左端点
        for(int j=0;j<nums.length;j++){//j代表窗口右端点
            sum+=nums[j];
            while(sum>=target){//如果当前sum>=target就尝试更新val
                res=Math.min(res,j-i+1);
                sum-=nums[i++];//移除窗口左侧的
            }
        }
        if(res==Integer.MAX_VALUE){//没有符合的窗口
            return 0;
        }
        return res;

    }
}
