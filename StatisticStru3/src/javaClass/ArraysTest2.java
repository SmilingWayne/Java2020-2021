package javaClass;

public class ArraysTest2 {
    public static void main(String[] args){
        int[][] a = new int[5][];
        for(int i =0 ;i < 5;i++){
            a[i]= new int[i+1];
            System.out.println(a[i].length);
        }
    }
}
