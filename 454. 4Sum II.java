class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //四个数相加等于零->一对数相加和另一对数相加为相反数。
        //12为一组，34为一组
        int res=0;
        Map<Integer,Integer>rightSum_count=new HashMap<>();//统计nums3，4元素任意组合的和（相反数）出现个数
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                rightSum_count.put(-nums3[i]-nums4[j],rightSum_count.getOrDefault(-nums3[i]-nums4[j],0)+1);
            }
        }
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int get=rightSum_count.getOrDefault(nums1[i]+nums2[j],0);
                if(get>0){//如果对应值出现，res+=对应值出现个数
                    res+=get;
                }
            }
        }
        return res;
    }
}
