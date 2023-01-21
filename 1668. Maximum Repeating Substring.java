class Solution {
  /*
  1668. Maximum Repeating Substring
  最大重复字符串
  */
    public int maxRepeating(String sequence, String word) {
        char[] sca=sequence.toCharArray();
        char[] wca=word.toCharArray();
        int maxCnt=0;//最大重复串的重复个数
        int cnt=0;//当前重复串的重复个数
        for(int i=0;i<sca.length;i++){//遍历sca中每个元素
            int tempi=i;
            for(int j=0;j<wca.length;j++){
                if(sca.length-tempi>=wca.length-j&&sca[tempi]==wca[j]){//可以构成下一个word并且下一个char相同
                    tempi++;//seq中的下标++
                    if(j==wca.length-1){//识别一个word
                        cnt++;
                        j=-1;//再次识别word
                    }
                }else{
                    maxCnt=Math.max(maxCnt,cnt);//更新maxCnt
                    cnt=0; 
                    break;
                }
            }
        }
        maxCnt=Math.max(maxCnt,cnt);//更新maxCnt
        return maxCnt;
    }
}
