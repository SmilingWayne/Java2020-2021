package dchomework1;
import java.util.*;
public class dchomework1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int low = scan.nextInt();
        int high = scan.nextInt();
        int[] a = new int[total];
        for(int i = 0 ; i < total; i ++ ){
            a[i] = scan.nextInt();
        }
        scan.close();
        int count = 0;
        int helper = 0;
        for(int i = 0 ; i < total; i ++ ){
            if(i == 0){
                helper += a[i];
                if(helper >= low && helper <= high){
                    count ++;
                }
            }
            else{
                helper += a[i];
                if(helper >= low && helper <= high){
                    count ++;
                }
                int assist = helper;
                for(int j = 0 ;j < i ;j ++ ){
                    assist -= a[j];
                    if(assist >= low && assist <= high){
                        count ++;
                    }
                }
            }
        }
        System.out.println(count);



    }

}
