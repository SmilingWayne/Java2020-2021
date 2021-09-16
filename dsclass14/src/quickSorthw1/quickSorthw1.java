package quickSorthw1;
import java.util.*;
public class quickSorthw1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int all = scan.nextInt();
        int times = scan.nextInt();
        int[] total = new int[all];
        for(int i = 0 ; i < all; i ++ ){
            total[i] = scan.nextInt();
        }
        scan.close();
        quicksort(total,0, total.length - 1, times);
        for(int i = 0; i < total.length; i ++ ){
            System.out.print(total[i] + " ");
        }
    }
    public static boolean judge(int[] total, int start , int end){
        if(end - start == 0){
            return true;
        }
        for(int i = start ; i <= end - 1; i ++ ){
            if(total[i] <= total[i + 1]){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static int quicksort(int[] total, int start , int end , int times){
        if(end - start <= 0 || judge(total, start ,end ) == true || times <= 0 ){
            return times;
        }
        else{
            times = times - 1;
        }
        int i = start;
        int j = end;

        int record = total[i];
        while(i < j){
            while(j > i && total[j] >= record){
                j -- ;
            }
            total[i] = total[j];
            while( i < j && total[i] <= record){
                i ++ ;
            }
            total[j] = total[i];
        }
        total[i] = record;
        int res = quicksort(total, start, i - 1, times);
        if(res <= 0){
            return 0;
        }
        else {
            res = quicksort(total, i + 1, end, times);
        }
        return res;
    }
}