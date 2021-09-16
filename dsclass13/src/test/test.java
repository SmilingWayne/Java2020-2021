package test;
import java.util.*;
public class test {
    public static void main(String[] args) {
        Random r = new Random(System.currentTimeMillis());
        long cur = System.currentTimeMillis();
        for(int i= 0 ; i < 8000; i ++ ){
            System.out.println(r.nextInt(100000));
        }
        long now = System.currentTimeMillis();
        System.out.println("Time : " + (now - cur));

    }

}
