package homework;
import java.util.*;
public class homework11 {
    /*
    硬币兑换问题，有25，10，5，1的硬币，先选择小的面额的硬币
    输入0。99
    output:
    3 2 0 4
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double target = scan.nextDouble();
        int t = (int)(target * 100);
        int[] coins = {25,10,5,1};
        int[] count = new int[4];
        for(int i = 0 ; i < 4; i ++ ){
            if(t >= coins[i]){
                count[i] = t/coins[i];
                t = t - (t/coins[i]) * coins[i];
            }
        }
        for(int i = 0;i < 4; i ++ ){
            System.out.print(count[i] + " ");
        }
        //System.out.println(count);
    }
}
