package DShomework5;
import java.util.*;

//实现KMP算法：

/**
 * KMP算法
 */
public class dshomework5 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String t = scan.nextLine();
        scan.close();
        System.out.println(kmp_indexof(s,t));
    }
    public static int kmp_indexof(String s, String t){
        int[] next = get_nextVal(t);
        int i = 0 ;
        int j = -1;
        while(i < s.length() && j<t.length()){
            if(j == -1 ||s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else{
                j = next[j];
            }
        }
        if(j >= t.length()){
            return i - t.length();
        }
        else{
            return -1;
        }
    }
    public static int[] get_nextVal(String t){
        int[] next  = new int[t.length()];
        next[0] = -1;
        int i = 0 ;
        int j = -1;
        while(i < t.length() -1){  //注意一下这里的i上限是t的倒数第二个字符，因为实际上每次执行，都给next[i++]赋值了//
            //因为next[0]已经赋值了//
            if( j  == -1||t.charAt(i) == t.charAt(j)){
                i++;
                j++;
                if(t.charAt(i) == t.charAt(j)){
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
