class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new LinkedList<>();
        backtrack(candidates,target,res,new LinkedList<Integer>(),0);
        return res;
    }
    void backtrack(int[] candidates, int target,List<List<Integer>> res,LinkedList<Integer> temp,int startIdx){
        if(target==0){
            res.add(new LinkedList<Integer>(temp));
            return;
        }
        for(int i=startIdx;i<candidates.length;i++){
            if(i>startIdx&&candidates[i]==candidates[i-1]){//防止对于同个位置使用重复的元素
                continue;
            }
            if(target-candidates[i]<0){//如果当前已经大于target，那么后续元素不需要考虑
                break;
            }
            temp.add(candidates[i]);
            backtrack(candidates,target-candidates[i],res,temp,i+1);
            //lastRemove=temp.peekLast();
            temp.removeLast();
        }
    }

}
