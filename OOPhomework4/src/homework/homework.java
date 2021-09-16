package homework;
import java.util.*;

/**
 * 因子分解成2、3、5
 */
public class homework {
    public static void getnumber(int x){
        boolean flag = false;
        for(int i = 2; i < x; i++){
            if(x%i==0){
                flag = true;
                System.out.print(i);
                System.out.print("*");
                getnumber(x/i);
                break;
            }
        }
        if(flag == false){
            System.out.printf("%d",x);
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        scan.close();
        System.out.printf("%d=",number);
        getnumber(number);

    }
}
