package test;
import java.util.*;
public class newtowmethod {
    public static void main(String[] args) {
        double x = 1.5;
        double err = 1;
        int count = 0;
        double xx = 0;
        while(count < 6){
            xx = x - function(x)*function2(x) / (function2(x)*function2(x) - function(x)*function3(x));
            err = Math.abs(xx - x);
            count ++;
            System.out.println("xx = " + xx + " ");
            System.out.println("err = " + err + " ");
            System.out.println("_________________");
            x = xx;
        }

    }
    public static double function(double x){
        return Math.pow(x,4)-4 *Math.pow(x,2) + 4;
    }
    public static double function2(double x){
        return 4*Math.pow(x,3) - 8 * x;
    }
    public static double function3(double x){
        return 12*Math.pow(x,2) - 8;
    }
}
