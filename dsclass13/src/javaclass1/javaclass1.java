package javaclass1;

import java.io.File;
import java.util.Scanner;

public class javaclass1 {
    public static boolean dfs(int n, int m, int index, int[] a, int[] b){
        if(index == m){
            return true;
        }
        for(int i = 0; i < n; i++){
            if(b[i] <= 0 || index > 0 && a[index - 1] ==i){
                continue;
            }
            a[index] = i;
            b[i] --;
            boolean ret = dfs(n, m, index + 1, a, b);
            if(ret){
                return true;
            }
            b[i] ++;
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        Scanner scan =  new Scanner(new File("data/input3"));
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] s = new int[n];
        for(int i = 0; i < n; i++){
            s[i] = scan.nextInt();
        }
        scan.close();
        int[] a = new int[m];
        int[] b = new int[n];
        System.arraycopy(s, 0, b, 0, s.length);
        boolean ret = dfs(n, m, 0, a, b);
        if(ret){
            for(int i = 0; i < m; i++){
                System.out.print((a[i] + 1) + " ");
            }
            System.out.println();
        }
        else{
            System.out.println("-");
        }
    }

}
