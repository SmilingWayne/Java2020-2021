package oophw3;
import java.util.*;
public class oophw3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String x = scan.next();
        String y = "";
        scan.close();

        int length = x.length();
        for(int i = 0; i < x.length(); i++){
            y = x.charAt(i) + y;
        }

        int m = LCS(x,y);
        m = length - m;
        System.out.println(m);

    }
    public static int LCS(String s, String t){
        int[][] f = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    f[i + 1][j + 1] = f[i][j] + 1;
                }
                else{
                    f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
                }
            }
        }
        return f[s.length()][t.length()];

    }
}
