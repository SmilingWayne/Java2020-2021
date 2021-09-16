package splitNumbers;

import java.util.*;


public class splitNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();
        if(isPrime(target)){
            System.out.println("1*" + target);

        }
        else {
            String x = change(target);

            System.out.println(x);
        }
    }
    public static String change(int x){
        if(isPrime(x)){
            return  "" + x;
        }
        else{
            for(int i = 2 ;i <= (int)(Math.sqrt(x)); i ++ ){
                if(x % i == 0 && isPrime(i)){
                    return i + "*" +  change(x/i);
                }
            }
        }
        return "" + x;
    }
    public static boolean isPrime(int x){
        for(int i = 2; i <= (int)(Math.sqrt(x)); i ++ ){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
}
