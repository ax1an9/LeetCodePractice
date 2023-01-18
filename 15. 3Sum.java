class Solution {
    private List<List<Integer>> Res=new LinkedList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1]){//i必须使得nums[i]！=nums[i-1]
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    LinkedList temp=new LinkedList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    Res.add(temp);
                    while(left<right&&nums[left]==nums[left+1]){//跳过相同的，防止结果集发生重复
                    left++;
                }
                while(left<right&&nums[right]==nums[right-1]){//跳过右侧相同的，防止重复
                    right--;
                }
                left++;right--;//收缩
                }
                if(sum>0){//当前sum过大
                    while(left<right&&nums[right]==nums[right-1]){//调小
                        right--;
                    }
                    right--;
                }
                if(sum<0){
                    while(left<right&&nums[left]==nums[left+1]){//调大
                        left++;
                    }
                    left++;
                }
            }
        }
        return Res;
    }
}
