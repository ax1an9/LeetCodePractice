class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res=new int[nums.length];
        int res_idx=nums.length-1;
        int i=0;
        int j=nums.length-1;
        while(res_idx>=0){
            if(i==j){
                res[res_idx--]=nums[i]*nums[i];
            }else{
                if(nums[i]*nums[i]>=nums[j]*nums[j]){
                    res[res_idx--]=nums[i]*nums[i];
                    ++i;
                }else{
                    res[res_idx--]=nums[j]*nums[j];
                    --j;
                }
            }
        }
        return res;
    }
}
//平方最大的项只可能出现在原数组两侧，因此只需要不断比较数组两端的数，并且加入新的数组即可。
//空间复杂度 O（n）
//时间复杂度 O（n）
