class Solution {
  /*
  经典的回溯问题，需要根据条件剪枝
  */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res =new LinkedList<>();
        backtrack(k,n,0,new LinkedList<Integer>(),res);
        return res;
    }
    void backtrack(int k, int n,int start,LinkedList<Integer>temp,List<List<Integer>>res){
        if(k==0&&n==0){
            res.add(new LinkedList<Integer>(temp));
            return ;
        }
        //剪枝
        if(n<0){//超过n了
            return;
        }
        if(n>(start+10+(9-k))*k/2){//剩余元素的和不足
            return;
        }
        if(9-start<k){//个数不足
            return;
        }
        for(int i=start+1;i<=9;i++){
            temp.add(i);
            backtrack(k-1,n-i,i,temp,res);
            temp.removeLast();
        }
    }
}
