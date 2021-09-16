package homework;
import java.util.*;
public class homework6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        double b = scan.nextDouble();
        int c = scan.nextInt();
        double d = (a * b * Math.pow(1 + b, c))/ (Math.pow(1 + b, c) -1);
        System.out.printf("%.2f", d);
    }
}
