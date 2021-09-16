package homework;
import java.io.*;
import java.util.*;
public class homework15 {
    /*
    KMP算法：
    abcdef
    cd
    out:2
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        int[] next = getNext(str2);
        int i = 0;
        int j = -1;
        while(i < str1.length() && j < str2.length()){
            if(j == - 1 || str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }
            else{
                j = next[j];
            }
        }
        if(j >= str2.length()){
            System.out.println(i - j);
        }
        else{
            System.out.println("-1");
        }
    }
    public static int[] getNext(String str){
        int[] next = new int[str.length()];
        next[0] = -1;
        int i = 0 ;
        int j = -1;
        while(i < str.length() - 1){
            if(j == -1 || str.charAt(i) == str.charAt(j) ){
                i ++;
                j ++;
                if(str.charAt(i) != str.charAt(j)){
                    next[i] = j;
                }
                else{
                    next[i] = next[j];
                }
            }
            else{
                j = next[j];
            }
        }
        return next;

    }
}
