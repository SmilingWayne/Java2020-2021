package randomNum;
import java.util.*;
public class randomnum {
    public static void main(String[] args) {
        Random r = new Random();
        for(int i = 0 ; i < 10; i ++ ){
            int k = r.nextInt(100);
            System.out.println(k);
        }
    }
}
