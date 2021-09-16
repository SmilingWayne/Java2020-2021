package homework;
import java.util.*;

public class homework12 {
    public static void main(String[] args) {
        for(int i = 100 ; i < 1000; i ++ ){
            if(isFlower(i)){
                System.out.println(i);
            }
        }

    }
    public static boolean isFlower(int b){
        int[] list = new int[3];
        int a = b;
        for(int i = 0 ; i < 3; i ++ ){
            list[i] = a % 10;
            a = a/10;
        }
        int z = 0;
        for(int i = 0 ; i < 3; i ++ ){
            z += list[i]*list[i]*list[i];
        }
        return z == b;
    }
}
