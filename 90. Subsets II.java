class Solution {
    List<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> temp=new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0);
        return res;
    }
    void backtrack(int[] nums,int startIdx){
        res.add(new LinkedList<>(temp));
        for(int i=startIdx;i<nums.length;i++){
            if(i>startIdx && nums[i]==nums[i-1]){//如果当前要添加的元素非首个元素且上个移除的和当前要加入的相同，可跳过
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums,i+1);
            temp.removeLast();
        }
    }
}
