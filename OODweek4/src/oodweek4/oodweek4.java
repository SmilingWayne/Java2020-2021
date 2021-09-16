package oodweek4;

import java.util.ArrayList;

public class oodweek4 {

    public static int c = 0;

    public static void example(int[] ret1, String[] ret2, ArrayList<Integer> a){

    }
    public static long factore(int n)
    {
        if(n == 1)
            return 1;
        else{
            return n*factore(n-1);
        }
    }
    public static void print(String str){

        System.out.println(str);
        System.out.println("Hello world");
    }

    /**
     * 了解一下尾递归
     *
     * @param str1
     * @param str2
     */
    public static void print(String str1,String str2){
        System.out.println(str1+str2);
    }
    public int fibonaci(int n ){
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        else{
            return fibonaci(n-1)+fibonaci(n-2);
        }//递归不能定义太大的数据结构，会消耗内存//
    }
    public static int gcd(int x, int y){
        return y==0?x:gcd(y,x%y);
    }
    public static void fibo(int n ){

    }
    public static void main(String[] args){
        //静态函数//
        int x = gcd(60,15);
        System.out.print(x);
    }
}
