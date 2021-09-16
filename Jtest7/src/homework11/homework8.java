//package homework11;

import java.util.*;
public class homework8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        double[][] items = new double[n][3];
        for(int i = 0 ;i < n ; i ++ ){
            items[i][0] = scan.nextDouble();
            items[i][1] = scan.nextDouble();
            items[i][2] = items[i][0] / items[i][1];
        }
        Arrays.sort(items, (a,b) -> {
            if(a[2] < b[2]){
                return 1;
            }
            else{
                return -1;
            }
        });
        double value = 0;
        int pos = 0;
        while(m > 0){
            if(m > items[pos][1]){
                value += items[pos][0];
                m -= items[pos][1];
                pos ++ ;
            }
            else{
                value += m * (items[pos][2]);
                m = 0;
            }
        }
        System.out.printf("%.2f", value);
    }

}