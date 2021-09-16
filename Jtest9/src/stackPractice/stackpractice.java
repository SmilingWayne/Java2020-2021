package stackPractice;
import java.util.*;
import java.lang.reflect.Array;

public class stackpractice {
    public static void main(String[] args){
        Arraystack stack = new Arraystack(4);
        boolean loop = true;
        String key = "";
        Scanner scan = new Scanner(System.in);
        while(loop){
            System.out.println("s");
            System.out.println("exit");
            System.out.println("push");
            System.out.println("pop");
            key = scan.next();
            switch(key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("输入一个数字");
                    int value = scan.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try{
                        int res = stack.pop();
                        System.out.printf("输出的数据是%d\n",res);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scan.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
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
    public int pop() throws Exception{
        if(isEmpty())
        {
            throw new Exception("栈空了");
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

}