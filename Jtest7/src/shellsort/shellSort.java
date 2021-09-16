package shellsort;
import java.util.*;
public class shellSort {
    public static void main(String[] args){
        int[] hello = {8,9,1,7,2,3,5,4,6,0};
        sortway2(hello);
        System.out.print(Arrays.toString(hello));

    }
    public static void sortway1(int[] m){
        int length = m.length;
        for(int interval = length / 2 ; interval > 0; interval/=2){
            for(int i = interval; i < length; i++){
                for(int j = i - interval; j >=0; j -=interval){
                    if(m[j] > m[j+interval]){
                        int temp = m[j];
                        m[j] = m[j + interval];
                        m[j + interval] = temp;
                    }
                }
            }
        }
    }
    //对希尔排序的优化：移位法//
    public static void sortway2(int[] m ){
        for(int gap = m.length/2; gap > 0; gap/=2){
            for(int i = gap; i < m.length; i++){
                int j = i;
                int temp = m[j];
                if(m[j] < m[j - gap]){
                    while(j - gap >=0 && temp < m[j - gap]){
                        m [j] = m[j - gap];
                        j-=gap;
                    }
                    m[j] = temp;
                }
            }
        }
    }
}
