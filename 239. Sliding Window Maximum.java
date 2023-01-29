class Solution {//滑動窗口最大值
    public int[] maxSlidingWindow(int[] nums, int k) {//單調隊列
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n=nums.length;
        int[] res=new int[n-k+1];
        int idx=0;
        for(int i=0;i<n;i++){ 
            if(!deque.isEmpty() && deque.peekFirst()<=i-k){//如果隊列不爲空，那麽去除不在區間範圍内的
                deque.removeFirst();
            }
            if(!deque.isEmpty()){//如果隊列非空
                while(!deque.isEmpty() && nums[i]>nums[deque.peekLast()]){//清除隊列尾部更小的
                    deque.removeLast();
                }
            }
            deque.add(i);
            if(i>=k-1){//將結果添加到res
                res[idx++]=nums[deque.peekFirst()];
            }         
        }
        return res;
    }
}
