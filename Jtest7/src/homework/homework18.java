package homework;

import java.util.*;
public class homework18 {
    /*
    统计输入字符串中单词、数字、空格的个数
    a b c ***
    3 0 3 3
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = s.toLowerCase();
        int m = s.length();
        int countVal = 0;
        int countNum = 0;
        int countSpace = 0;
        int countOth = 0;
        for(int i = 0 ; i < m ; i ++ ){
            if(s.charAt(i) >='a' && s.charAt(i) <= 'z'){
                countVal ++;
            }
            else if(s.charAt(i) == ' '){
                countSpace ++ ;
            }
            else if(s.charAt(i) >='0' && s.charAt(i) <='9'){
                countNum ++ ;
            }
            else{
                countOth ++ ;
            }
        }
        System.out.print(countVal + " " + countNum + " " + countSpace + " " + countOth) ;

    }
}