package homework;
import java.util.*;
public class homework7 {
    public static void main(String[] args) {
        /*
        取一个整数a从右端开始的4到7位构成的整数，例如假如a=100，
        则有a从右端开始的4 ～7位构成的整数为12

        直接进行位移操作就行啦！

         */
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int t = a;
        int b = a>>3;
        int c = t>>7;
        System.out.println(b -c);
    }
}
