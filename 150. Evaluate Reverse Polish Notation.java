class Solution {
    public int evalRPN(String[] tokens) {
        int []stack=new int[10001];//模拟栈
        int top=0;//下一个入栈元素应该放的位置
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].charAt(0)<='9'&&tokens[i].charAt(0)>='0'){//正数
                stack[top++]=Integer.parseInt(tokens[i]);
            }else{
                if(tokens[i].charAt(0)=='-'&&tokens[i].length()>1){//负数
                    stack[top++]=Integer.parseInt(tokens[i]);
                    continue;
                }
                //处理操作符
                int op2=stack[--top];
                int op1=stack[--top];//到栈顶取操作数
                switch(tokens[i].charAt(0)){//根据操作符做运算，并且将结果压栈
                    case '+':
                        stack[top++]=op1+op2;
                        break;
                    case '-':
                        stack[top++]=op1-op2;
                        break;
                    case '*':
                        stack[top++]=op1*op2;
                        break;
                    case '/':
                        stack[top++]=op1/op2;
                        break;
                    default: break;
                }
            }
        }
        return stack[--top];//取栈顶元素，此时栈顶为计算结果
    }
}
