class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] digit_letters=new char[10][4];//号码和字母映射
        int cur=0;
        for(int i=2;i<=9;i++){//填充映射
            int letterNum=3;
            if(i==7||i==9){
                letterNum=4;
            }
            for(int j=0;j<letterNum;j++){
                digit_letters[i][j]=(char)('a'+cur);
                cur++;
            }
        }
        char[] sca=digits.toCharArray();
        List<String> res=new LinkedList<>();
        backtrack(sca,0,digit_letters,new StringBuilder(),res);
        return res;
    }
    void backtrack(char[] sca,int startIdx,char[][] digit_letters,StringBuilder sb,List<String> res){//startIdx 表示最小需要回溯填充的位
        int n=sca.length;
        if(n==0){//没有数字，直接返回
            return;
        }
        if(sb.length()==n){//填满sb，添加一个结果
            res.add(sb.toString());
            return;
        }
        for(int i=startIdx;i<n;i++){//遍历sca中的元素
            int letterNum=3;
            int number=sca[i]-48;
            if(number==7||number==9){
                letterNum=4;
            }
            for(int j=0;j<letterNum;j++){//对于每个数字其对应的字母有多个，需要多次尝试，尝试后回溯
                char toAdd=digit_letters[number][j];
                sb.append(toAdd);
                backtrack(sca,i+1,digit_letters,sb,res);//注意此时下一层回溯的startIdx应为i+1，因为我们依次解析数字为字母
                sb.delete(sb.length()-1,sb.length());//撤消
            }
        }
    }
}
