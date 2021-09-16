package Lambdatest;
import java.util.*;
public class lambdatest {
    public static void main(String[] args){
        String[] planets = new String[]{
                "Mercury","Venus","Mars","Earth","Jupiter","Saturn"
        };
        System.out.println(Arrays.toString(planets));
        Arrays.sort(planets);
        System.out.println("Sorted by length");
        Arrays.sort(planets,(first,second)->second.length()-first.length());
        System.out.println(Arrays.toString(planets));//lambda表达式。。//


    }
}
