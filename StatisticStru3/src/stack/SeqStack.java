package stack;

public class SeqStack{

    public final int INITIAL_STACK_SIZE = 100;

    public String[] base;

    public int top;

    public SeqStack(){
        base = new String[INITIAL_STACK_SIZE];
        top = 0;
    }

    public void clear(){
        top = 0;
    }

    public boolean is_empty(){
        if(top == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){
        return top;
    }

    public String get_top() throws Exception{
        if(top == 0){
            throw new Exception("get_top错误：空栈");
        }
        return base[top - 1];
    }

    public void push(String a) throws Exception{
        if(top == base.length){
            throw new Exception("push错误：栈满");
        }
        base[top ++] = a;
    }

    public String pop() throws Exception{
        if(top == 0){
            throw new Exception("pop错误：空栈");
        }
        top --;
        return base[top];
    }

    @Override
    public String toString(){
        String str = "";
        for(int i = 0; i < top; i++){
            str += base[i] + " ";
        }
        return str;
    }
}