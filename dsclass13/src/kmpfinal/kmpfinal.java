package kmpfinal;
import java.io.*;
import java.util.*;
public class kmpfinal {
    public static void main(String[] args) {
        File file = new File("src/kmpfinal/dataa");
        try {
            Scanner scan = new Scanner(file);
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            int[] next = getNext(str2);
            int i = 0;
            int j = 0;
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
        catch(Exception x){
            System.out.println("错误！");
        }
    }
    public static int[] getNext(String str){
        int[] next = new int[str.length()];
        next[0] = -1;
        int i = 0 ;
        int j = -1;
        while(i < str.length()){
            if(j == -1 || str.charAt(i) == str.charAt(j) ){
                i ++;
                j ++;
                next[j] = j;
            }
            else{
                j = next[j];
            }
        }
        for(int k = 0 ; k < next.length; k ++ ){
            System.out.println(next[k] + " ");
        }
        return next;

    }
}
