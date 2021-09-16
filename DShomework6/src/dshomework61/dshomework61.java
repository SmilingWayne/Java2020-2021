package dshomework61;
import java.util.*;

/**
 * KM 算法求解分配问题
 */
public class dshomework61 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] total = new int[n][n];
        boolean[][] judge = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int value = scan.nextInt();
            total[a - 1][b - 1] = -value ;
            judge[a - 1][b - 1] = true;
        }
        for(int i = 0; i < n; i ++ ){
            for(int j = 0; j < n ; j ++ ){
                if(total[i][j] == 0){
                    total[i][j] = -2000;
                }
            }
        }
        scan.close();
        new KM(total).km();
    }
}
class KM {
    int[][] graph;
    boolean[] xUsed;
    boolean[] yUsed;
    int[] match;
    int len;
    int[] less;
    private static final int INFINITE = Integer.MAX_VALUE;;
    int[] X;
    int[] Y;
    public KM(int[][] data) {
        this.graph = data;
        len = data.length;
        xUsed = new boolean[len];
        yUsed = new boolean[len];
        match = new int[len];
        less = new int[len];
        X = new int[len];
        Y = new int[len];
        for (int i = 0; i < len; i++) {
            match[i] = -1;
        }
        for (int k = 0; k < len; k++) {
            X[k] = data[k][0];
            for (int l = 0; l < len; l++) {
                X[k] = X[k] >= data[k][l] ? X[k] : data[k][l];
            }
        }
    }
    void km() {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                less[j] = INFINITE;
            }
            while (true) {
                for (int j = 0; j < len; j++) {
                    xUsed[j] = false;
                    yUsed[j] = false;
                }

                if (HungaryDFS(i)) break;

                int difference = INFINITE;
                for (int j = 0; j < len; j++) {
                    if (!yUsed[j]) difference = difference <= less[j] ? difference : less[j];
                }
                //这一步实际上是降低所有需求，因为按照每一行都取权重最大的情况来说，无法满足，所以把最后相差最小的（也就是less数组里面的）减去//
                // //
                for (int j = 0; j < len; j++) {
                    if (xUsed[j]) X[j] -= difference;
                    if (yUsed[j]) Y[j] += difference;
                    else less[j] -= difference;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += graph[match[i]][i];
            //System.out.println(graph[match[i]][i]);
        }
        System.out.println(-res);
    }

    private boolean HungaryDFS(int i) {
        xUsed[i] = true;


        for (int j = 0; j < len; j++) {
            if (yUsed[j]) continue;
            int gap =  X[i] + Y[j]- graph[i][j]  ;


            if (gap == 0) {
                yUsed[j] = true;
                if (match[j] == -1 || HungaryDFS(match[j])) {
                    match[j] = i;
                    return true;
                }
            } else {
                less[j] = less[j] <= gap ? less[j] : gap;
            }
        }
        return false;
    }
}

