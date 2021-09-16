package homework;

import java.util.*;

public class homework8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        double p = (double)(a + b + c)/2;
        double ans = Math.sqrt(p * (p - a) * (p - b) * (p -c));
        System.out.printf("%.3f", ans);
    }
}
