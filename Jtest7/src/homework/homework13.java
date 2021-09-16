package homework;
import java.util.*;
public class homework13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();
        dfs(target);

    }
    public static void dfs(int a){
        if(isPrime(a)){
            System.out.print(a);
            return;
        }
        for(int i = 2; i <= a; i ++ ){
            if(a % i == 0){
                System.out.print(i + "*");
                dfs(a/i);
                break;
            }
        }
    }
    public static boolean isPrime(int x){
        if(x == 2 || x == 1){
            return true;
        }
        for(int i = 2; i < Math.sqrt(x) + 1; i ++ ){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
}
