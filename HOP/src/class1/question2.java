package class1;
import java.util.*;
public class question2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i ++ ){
            int c = scan.nextInt();
            if(c > first){
                second = first;
                first = c;
            }
            else if(c > second){
                second = c;
            }
        }
        System.out.println(first + second);
    }
}
