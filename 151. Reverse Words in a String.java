class Solution {
    public String reverseWords(String s) {
        char[] sca=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        //用于存储单词对应substring下标的stack
        int[] startStack=new int[s.length()];
        int[] endStack=new int[s.length()];
        int top1=0;
        int top2=0;
        int cur=0;   
        while(cur<sca.length){
            while(cur<sca.length&&sca[cur]==' '){//跳过前导空格
                cur++;
            }
            int start=cur;
            while(true){ 
                if(cur<sca.length&&sca[cur]!=' '){
                    cur++;
                }else{
                    if(cur>=sca.length){
                        break;
                    }else{
                        break;
                    }
                }
            }
            startStack[top1++]=start;
            endStack[top2++]=cur;
            while(cur+1<sca.length&&sca[cur+1]==' '){//跳过单次间的多个空格
                cur++;
            }
            cur++;
        }
        while(top1>0){//依次取栈顶的(start,end)对，append sb
            if(top1!=1){
                sb.append(s.substring(startStack[--top1],endStack[--top2])+' ');
            }else{
                sb.append(s.substring(startStack[--top1],endStack[--top2]));
            }
            
        }
        return sb.toString();
        
    }

}
