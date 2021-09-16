package javaClass;

public class JavaClass3 {
    public static void main(String[] args){
        int a=10;
        int b=15;
        System.out.println(a<<1);
        System.out.println(a&b);//与的操作//
        System.out.println(a|b);
        //System.out.println(a<<1);//二进制数的转换,向左移动就是最后加0//
        /*for(int i = 0 ;i<22;i++){
            for(int j=0;j<22;j++){
                if(i==0||j==0){
                    System.out.println("*");
                }
                else if(i%j==0||j%i==0){
                    System.out.println("*");
                }
                else{
                    System.out.println(" ");
                }
            }
        }*/
        //Newton//
        double n = 5;
        double threshold = 1e-6;
        double c = 1;
        while(Math.abs(c-n/c)>threshold){
            c=(c+n/c)/2.0;
        }
        System.out.println(c);


    }
}
