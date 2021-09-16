package class1;
import java.util.*;
public class question1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        int total = 0;
        n = scan.nextInt();
        for(int i = 0; i < n ; i ++ ){
            total += scan.nextInt();
        }
        System.out.println(total);
    }
}
