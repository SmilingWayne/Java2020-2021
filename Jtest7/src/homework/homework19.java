package homework;

import java.util.*;
public class homework19 {
    /*
    统计所有字母

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String res ="";
        int m =s.length();
        for(int i = 0 ; i < m ; i++ ){
            if(s.charAt(i) >='a' && s.charAt(i) <='z' || s.charAt(i) >='A' && s.charAt(i) <='Z'){
                res += s.charAt(i) + "";
            }
        }
        System.out.println(res);

    }
}