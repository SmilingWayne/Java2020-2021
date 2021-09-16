package class1;
import java.util.*;
public class question3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long a = scan.nextLong();
        long b = scan.nextLong();
        scan.close();
        System.out.println(GCD(a,b));

    }
    public static long GCD(long a, long b){
        if(a < b){
            return GCD(b,a);
        }
        else{
            if(b == 0){
                return a;
            }
            else{
                return GCD(b , a % b);
            }
        }
    }
}
