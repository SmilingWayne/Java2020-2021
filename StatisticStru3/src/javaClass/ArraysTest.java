package javaClass;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args){
        int[] a= new int[10];
        int[] b= new int[10];
        Arrays.fill(a,1);//给A全部赋值1//
        for(int i=0;i<b.length;i++){
            b[i]=a[i];
        }
        //System.arraycopy(a,0,b,0,10);

        int n =100;
        int count=0;
        for(int i=0;i<n;i++){
            boolean prime =true;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    prime=false;
                    break;
                }
            }
            if(prime)
                count++;
        }
        System.out.println(count);

    }
}
