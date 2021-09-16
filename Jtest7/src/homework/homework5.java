package homework;
import java.util.*;
public class homework5 {
    /*
    求解一元二次方程
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = b*b - 4*a*c ;
        if(d >= 0){
            double x1 =(-b + Math.sqrt(d))/(2*a);
            double x2 =(-b - Math.sqrt(d))/(2*a);
            if(d == 0){
                System.out.printf("%.2f", x1);
            }
            else{
                System.out.printf("%.2f %.2f", x1, x2);
            }
        }
        else{
            System.out.println("非一元二次方程");
        }
    }
}
