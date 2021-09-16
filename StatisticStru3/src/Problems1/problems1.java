package Problems1;
import java.util.*;
public class problems1 {
    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        int target = in.nextInt();
        int helper = target>>7;
        System.out.println(helper>>4);

    }
}
