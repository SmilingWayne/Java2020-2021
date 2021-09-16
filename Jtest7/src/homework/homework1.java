package homework;

import java.util.*;
public class homework1 {
    /*
    Question: Read Integer n and then n Integers, print the
     sum of the two largest numbers amount them.
     e.g.
        7
        162 173 159 164 181 158 175
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        if(length == 0){
            System.out.println(0);
        }
        int[] all = new int[length];
        int large = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;
        for(int i = 0 ; i < length ; i ++ ){
            all[i] = scan.nextInt();
            if(large <= all[i]){
                secondLarge = large;
                large = all[i];
            }
            else if(large > all[i]){
                if(secondLarge <= all[i]){
                    secondLarge = all[i];
                }
                else{
                    continue;
                }
            }
        }
        if(secondLarge == Integer.MIN_VALUE){
            System.out.println(large);
        }
        else {
            System.out.println(secondLarge + large);
        }
    }
}
