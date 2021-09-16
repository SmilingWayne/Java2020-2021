package nest;

public class nest {
    public static int count = 0;
    public void outer(){
        count ++;
    }
    public static  class Inner{
        public void print(){
            System.out.println("Number of count "+ count);
        }
    }
}
