class Solution {
    public int[][] generateMatrix(int n) {
        int[][]res=new int[n][n];//初始化结果矩阵
        int num=1;//填充数字
        //每轮起点：左上角
        int startX=0;
        int startY=0;
        //循环轮次=偏移量
        int offset=0;
        //当前位置
        int i=0;
        int j=0;
        //每次走完一圈（循环一轮）：就会使得下次循环的一条边-2，因此最多可以循环n/2次
        while(offset++<n/2){//处理原则，前闭后开
            for(j=startY;j<n-offset;j++){
                res[startX][j]=num++;
            }
            for(i=startX;i<n-offset;i++){
                res[i][j]=num++;
            }
            for(;j>=offset;j--){
                res[i][j]=num++;
            }
            for(;i>=offset;i--){
                res[i][j]=num++;
            }
            startX++;
            startY++;
        }
        if(n%2==1){
            res[startX][startY]=num;
        }
        return res;
    }
}
