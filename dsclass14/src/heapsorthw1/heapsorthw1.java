package heapsorthw1;
import java.util.*;
public class heapsorthw1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int[] s = new int[total];
        for(int i = 0 ; i < total; i ++ ){
            s[i] = scan.nextInt();
        }
        scan.close();
        boolean flag = true;
        for(int i = 0 ; i < total/2; i ++ ){
            if(i * 2 + 1 < total){
                if(s[i * 2 + 1] <= s[i]){
                    flag = false;
                    break;
                }

            }
            if(i * 2 + 2 < total){
                if(s[i * 2 + 2] <= s[i]){
                    flag = false;
                    break;

                }
            }
        }
        if(flag){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }
    }
}
