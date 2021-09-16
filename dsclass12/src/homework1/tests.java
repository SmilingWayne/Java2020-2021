package homework1;

import java.util.*;
public class tests {
    public static void main(String[] args) {
        int count = 0;
        double ans =1;
        while(ans < 2){
            ans *= (1+0.005);
            count += 1;
        }
        System.out.println(count);

    }
}
