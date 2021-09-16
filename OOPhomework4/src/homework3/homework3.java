package homework3;
public class homework3 {

    /**
     * 输出一个数，加上100与168后都是完全平方数
     * @param args
     */
    public static void main(String[] args){
        int i = 1;
        for(i = 0; i<1000000;i++){
            int helper = i +100;
            int helper2 = i + 168;
            int x = (int)Math.sqrt(helper);
            int y = (int)Math.sqrt(helper2);
            if(helper == x*x){
                if(helper2 == y*y)
                    System.out.println(i);
            }
        }
    }
}
