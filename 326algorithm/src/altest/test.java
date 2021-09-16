package altest;
import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String[] temp = a.substring(1,a.length() - 1).split(", ");
        boolean c = false;
        judge(c, 10,5);
        System.out.println(c);

    }
    public static void judge(boolean a, int b, int c){
        if(b > c){
            a = true;
        }
    }
}
