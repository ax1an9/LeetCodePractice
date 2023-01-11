class Solution {
    public int numSquares(int n) {
        int[]dp=new int [n+1];//dp 数组：dp[i]表示对于一个正整数，和为 n 的完全平方数的最少数量
        /*
        状态转移方程推导：
            对于正整数n，其可以表示为x+y^2,其中y^2是一个完全平方数，x可以表示为完全平方数的和
            因此求解本问题等价于 dp[n]=min{dp[x]}+1=min{dp[n-y^2]}+1
         */
        dp[0]=0;//边界条件
        for(int i=1;i<=n;i++){
            int target=Integer.MAX_VALUE;//未知/待优化
            for(int j=1;j*j<=i;j++){
                //对于完全平方数来说，target=dp[0]=0
                target=Math.min(target,dp[i-j*j]);
            }
            dp[i]=target+1;
        }
        return dp[n];
        
        

    }
}