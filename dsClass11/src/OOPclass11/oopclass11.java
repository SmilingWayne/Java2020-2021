package OOPclass11;
import java.util.*;
public class oopclass11 {
    public static void main(String[] args) {
        int[] a = {4,3,3};
        int[] b = {2,3,4};
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                count ++;
                i ++;
                j++;
            }
            else{
                j++;
            }
        }
        System.out.println(count);
    }
}
