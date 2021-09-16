package Stack;

public class SeqStack2{

    public static class Coordinate{

        public int x;

        public int y;

        /**
         * -1: no
         * 0: right
         * 1: right. up
         * 2: right, up, left
         * 3: all
         */
        public int direction = -1;

        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public final int INITIAL_STACK_SIZE = 100;

    public Coordinate[] base;

    public int top;

    public SeqStack2(){
        base = new Coordinate[INITIAL_STACK_SIZE];
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

    public Coordinate get_top() throws Exception{
        if(top == 0){
            throw new Exception("get_top错误：空栈");
        }
        return base[top - 1];
    }

    public void push(Coordinate a) throws Exception{
        if(top == base.length){
            throw new Exception("push错误：栈满");
        }
        base[top ++] = a;
    }

    public Coordinate pop() throws Exception{
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
            str += "(" + base[i].x + base[i].y + ") ";
        }
        return str;
    }
}