class Solution {
    /**
    对于组合问题，一般需要进行剪枝提高效率
     */
    private List<List<Integer>> Res=new LinkedList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for(int k=0;k<nums.length;k++){
            if(k!=0&&nums[k]==nums[k-1]){//i必须使得nums[i]！=nums[i-1]
                continue;
            }
            if(nums[k]>0&&nums[k]>target){
                break;
            }
            for(int i=k+1;i<nums.length;i++){
            if(i!=k+1&&nums[i]==nums[i-1]){//i必须使得nums[i]！=nums[i-1]
                continue;
            }
            // if(nums[k]>target-nums[i]){
            //     break;
            // }错误的剪枝
            if(nums[i]>0&&nums[k]>target-nums[i]){
                break;
            }
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                // if(nums[i]+nums[k]+nums[left]>target){
                //     break;
                // }错误剪枝
                if(nums[left]>0&&nums[i]+nums[k]>target-nums[left]){
                    break;
                }
                int sum=nums[i]+nums[k]+nums[left]+nums[right];
                if(sum==target){
                    LinkedList temp=new LinkedList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[k]);
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
                if(sum>target){//当前sum过大
                    while(left<right&&nums[right]==nums[right-1]){//调小
                        right--;
                    }
                    right--;
                }
                if(sum<target){
                    while(left<right&&nums[left]==nums[left+1]){//调大
                        left++;
                    }
                    left++;
                }
            }
        }
        }
        
        return Res;
    }
}
