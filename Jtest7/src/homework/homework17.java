package homework;

import java.util.*;
public class homework17 {
    /*
    统计输入字符串中单词的个数
    Hello world!
    2

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int count = 0;
        int m = s.length();
        for(int i = 0; i < m ; i ++ ){
            if(s.charAt(i) != ' '){
                while(i < m && s.charAt(i) != ' '){
                    i ++ ;
                }
                i --;
                count ++ ;
            }
        }
        System.out.println(count);
    }
}
