class Solution {
    public String removeDuplicates(String s) {
        char[] sca=s.toCharArray();
        char[] stack=new char[sca.length];
        int top=0;//棧頂+1
        for(int i=0;i<sca.length;i++){
            if(top==0){
                stack[top++]=sca[i];
            }else{
                if(sca[i]==stack[top-1]){//消除一對
                    top--;
                }else{//正常入棧
                    stack[top++]=sca[i];
                }
            }
        }
        return String.valueOf(stack).substring(0,top);
    }
}
