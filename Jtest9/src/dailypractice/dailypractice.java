package dailypractice;

import java.util.*;
public class dailypractice {
    public static void main(String[] args){
        //System.out.println("Input the String：");
        /*Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();
        scan.close();*/
        String expression = "(20+3*2)*5+4";//如何处理多位数的问题//
        String keepNumber = "";
        //这种方式只适用于一位数的加减乘除运算//
        Arraystack numStack =  new Arraystack(10);
        Arraystack operStack = new Arraystack(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        while(true) {
            ch = expression.substring(index, index + 1).charAt(0); //这句话取出了一个只含有一个字符的字符串//
            if (operStack.isoper(ch)) {
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = operStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);//字符串到数字的转换////查看ASICC编码;

                }
            }
            else if (operStack.frontKuo(ch)){
                operStack.push('(');

            }
            else if(operStack.backKuo(ch)){
                while(true){
                    if(operStack.peek()=='('){
                        break;
                    }
                    else{
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = operStack.cal(num1,num2,oper);
                        numStack.push(res);
                    }
                }
                operStack.pop();
            }
            else {
                keepNumber += ch;
                if(index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNumber));
                }
                //问题出在这里：不知道是几位数？？//
                else if(operStack.isoper(expression.substring(index+1,index+2).charAt(0))
                        ||operStack.frontKuo(expression.substring(index+1,index+2).charAt(0))||
                        operStack.backKuo(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNumber));
                        keepNumber="";
                    }//我傻了吧唧的。。直到下一个是符号才停止//
            }
            index++;
            if (index >= expression.length())
                break;
        }
        while(true){
            if(operStack.isEmpty()){
                break;
            }
            else{
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = operStack.pop();
                res = operStack.cal(num1,num2,oper);
                numStack.push(res);
            }
        }
        System.out.printf("表达式结果%s=%d ",expression,numStack.pop());
    }
}
class Arraystack{
    public int MAXSIZE;
    public int[] stack;
    public int top = -1;
    public Arraystack(int MAXSIZE){
        this.MAXSIZE = MAXSIZE;
        stack = new int[this.MAXSIZE];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==MAXSIZE-1;
    }
    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return ;
        }
        else{
            top++;
            stack[top] = value;
        }
    }
    public int pop(){
        if(isEmpty())
        {
            return 0;
        }
        else{
            int value = stack[top--];
            return value;
        }

    }
    public void list(){
        if(isEmpty()){
            System.out.println("栈空，没有数据");

        }
        for(int i = top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
    //返回数字的优先级//
    public int priority(int oper){ //int和char类型可以相互转换//
        if(oper == '*'||oper == '/'){
            return 1;
        }
        else if(oper == '+'||oper =='-')
            return 0;
        else{
            return -1;
        }
    }
    public boolean isoper(char val){
        return val == '+'||val == '-'||val == '*'||val == '/';
    }
    public int peek(){
        return stack[top];
    }
    //计算方法//
    public boolean frontKuo(char kuo){
        return kuo == '(';
    }
    public boolean backKuo(char kuo){
        return kuo == ')';
    }
    public int cal(int num1,int num2,int oper){
        int res = 0;//存放计算结果//
        switch(oper){
            case '+':res = num1+num2;
            break;
            case '-':res = num2 - num1;
            break;
            case '*':res = num2*num1;
            break;
            case '/':res = num2/num1;
            break;
            default:
                break;
        }
        return res;
    }


}