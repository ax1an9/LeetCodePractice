class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Arrays.sort(logs,(x,y)->{
            if(x[0]<y[0]){
                return -1;
            }else{
                if(x[0]==y[0]){
                    return x[1]-y[1];
                }else{
                    return 1;
                }
            }
        });//按照序号升序，操作时间升序排序logs
        // for(int i=0;i<logs.length;i++){//print logs
        //     System.out.println(logs[i][0]+","+logs[i][1]);
        // }
        int[]res=new int[k];//res set res[i-1]表示操作数为i的用户的个数
        for(int i=0;i<logs.length;i++){
            int cnt=1;//用户的首条记录，说明该用户至少操作一次
            while(1+i<logs.length){
                if(logs[1+i][0]==logs[i][0]){//跳过所有相同的时间
                    if(logs[1+i][1]==logs[i][1]){
                        i++;
                        continue;
                    }else{//发现不同的操作时间
                        cnt++;
                        i++;
                        continue;
                    }
                }else{//进入下个用户的记录
                    res[cnt-1]++;
                    break;
                }
            }
            if(1+i>=logs.length){//没有下一个用户，也需要将cnt统计
                res[cnt-1]++;
            }
        }
        return res;
    }
}
