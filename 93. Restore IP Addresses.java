class Solution {
    List<String> res=new LinkedList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> restoreIpAddresses(String s) {
        if(s.length()>12){//剪枝，本题不允许000001=1之类的情况
            return res;
        }
        backtrack(s,0,4);
        return res;
    }
    void backtrack(String s,int startIdx,int need){
        if(need==0){
            if(startIdx==s.length()){
                res.add(sb.substring(0,sb.length()-1));
            }
            return;
        }
        for(int i=startIdx;i<s.length();i++){
            if(i-startIdx+1>3){//过长
                break;
            }
            if(s.charAt(startIdx)=='0'){//对于零 只能当零处理
                sb.append("0.");
                backtrack(s,i+1,need-1);
                sb.delete(sb.length()-2,sb.length());
                break;
            }
            if(isPartOfIP(s,startIdx,i+1)){
                String temp=s.substring(startIdx,i+1)+".";
                sb.append(temp);
                backtrack(s,i+1,need-1);
                sb.delete(sb.length()-temp.length(),sb.length());
            }else{//不合法，更长就更不合法
                break;
            }
        }
    }
    boolean isPartOfIP(String s,int begin,int end){
        int parsed;
        try{
            parsed=Integer.parseInt(s.substring(begin,end));
        }catch(Error e){
            return false;
        }
        if(parsed<=255&&parsed>=0){
            return true;
        }
        return false;
    }
}
