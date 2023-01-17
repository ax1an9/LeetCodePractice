class Solution {
    public boolean isHappy(int n) {
        /**
        思路：出现无限循环~非快乐数（如何判断无限循环？存储每轮计算结果）
         */
        Set<Integer> tempSet=new HashSet<>();
        while(true){
            int temp=0;
            while(n/10>0){
                temp+=(n%10)*(n%10);//不断取个位
                n/=10;
            }
            temp+=(n%10)*(n%10);
            if(tempSet.contains(temp)){
                return false;
            }else{
                tempSet.add(temp);
            }
            n=temp;
            if(n==1){
                return true;
            }
        }
    }
}
