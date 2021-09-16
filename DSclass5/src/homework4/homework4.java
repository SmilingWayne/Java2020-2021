package homework4;
import java.util.*;
public class homework4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int m = scan.nextInt();
        int n = scan.nextInt();
        int[] numbers = new int[n];
        int[] peoples = new int[n];

        for(int i = 0 ; i < n;i++){
            numbers[i] = scan.nextInt();
        }
        scan.close();
        for(int i = 0 ; i < n; i++){
            peoples[i] = i + 1;
        }
        int count =0;
        int people = 0;
        int[] res = new int[n];
        for (int i = 0; i%n < n; i++) {
            if (peoples[i%n] != -1) {
                count++;
            }
            if(count == m){
                res[people] = i%n+1;
                peoples[i%n] = -1;
                people++;
                m = numbers[i%n];
                count = 0;
            }
            if(people == n){
                break;
        }
        }
        for(int i = 0; i < n;i++)
            System.out.println(res[i]);
    }
}
