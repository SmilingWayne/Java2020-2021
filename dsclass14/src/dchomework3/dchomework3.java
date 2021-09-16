package dchomework3;
import java.util.*;
public class dchomework3 {
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
        System.out.println(countRangedArray(a, low, high));
    }
    public static int countRangedArray(int[] a ,int lower , int upper){
        int size = a.length;
        int[] sum = new int[size + 1];
        sum[0] = 0;
        int x = 0;
        for(int i = 0; i < size; i ++ ){
            x += a[i];
            sum[i + 1] = x ;
        }
        return getRangedArray(sum, 0 , a.length , lower, upper);

    }
    public static int getRangedArray(int[] sum, int left , int right, int lower, int upper){
        if(left == right){
            return 0;
        }
        int middle = (left + right) /2;
        int result = 0;
        result += getRangedArray(sum, left, middle, lower, upper);
        result += getRangedArray(sum, middle + 1, right, lower, upper);
        int i = left;
        int l = middle + 1;
        int l1 = l;
        int r = middle + 1;
        while (i <= middle) {
            int count = 0;
            while (l1 <= right) {
                if(sum[l1] - sum[i] >= lower && sum[l1] - sum[i] <= upper)
                    count ++;
                l1++;
            }
            result += count;
            i++;
        }
        return result;
    }

}