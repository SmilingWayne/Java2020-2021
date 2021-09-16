package homework1;
import java.util.*;
public class bit {
    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(0|(1<<4)));
        String[] example = {"abcd", "fkjl"};
        for(String a:example){
            getBinary(a);
        }
    }
    public static void getBinary(String t){
        int temp = 0;
        for(int i = 0 ; i < t.length(); i ++ ){
            temp |= ( 1 <<t.charAt(i) - 'a');
        }
        System.out.println(Integer.toBinaryString(temp));
    }
}
