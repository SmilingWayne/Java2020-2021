package stack;

public class Main {
    public static void main(String[] args) throws Exception{ // 注意Exception//
        SeqStack stack = new SeqStack();
        stack.push("c");
        stack.push("b");
        stack.push("c");
        stack.pop();
        System.out.println(stack);
        while(stack.is_empty()==false){
            System.out.println(stack.pop());
        }
    }
}
