package class1;
import java.util.*;
public class question14 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] total = new int[n][n];
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int value = scan.nextInt();
            total[a - 1][b - 1] = -value ;
            //judge[a - 1][b - 1] = true;
        }
        for(int i = 0; i < n; i ++ ){
            for(int j = 0; j < n ; j ++ ){
                if(total[i][j] == 0){
                    total[i][j] = -2000;
                }
            }
        }
        scan.close();
        new KM(total).solve();

    }
}


class KM {
    public int[][] graph;
    boolean[] xUsed;
    boolean[] yUsed;
    int[] X;
    int[] Y;
    int[] less;
    int[] match;
    public KM(int[][] graph){
        this.graph = graph;
        xUsed = new boolean[graph.length];
        yUsed = new boolean[graph.length];
        X = new int[graph.length];
        Y = new int[graph.length];
        less = new int[graph.length];
        match = new int[graph.length];
        for(int i = 0 ; i < graph.length; i ++ ){
            match[i] = -1;
        }
        Arrays.fill(less, Integer.MAX_VALUE);
        for(int i = 0 ; i < graph.length; i ++ ){
            X[i] = graph[i][0];
            for(int j = 0; j < graph.length; j++ ){
                X[i] = Math.max(X[i], graph[i][j]);
            }
        }
    }
    public void solve(){
        for(int i = 0; i < graph.length; i ++ ) {
            Arrays.fill(less, Integer.MAX_VALUE);
            while(true){
                Arrays.fill(xUsed, false);
                Arrays.fill(yUsed, false);
                if(HungaryDFS(i))
                    break;
                int diff = Integer.MAX_VALUE;
                for(int j = 0 ; j < graph.length; j ++ ){
                    if(!yUsed[j]){
                        diff = diff <= less[j] ? diff : less[j];
                    }
                }
                for(int j = 0; j < graph.length; j ++ ){
                    if(xUsed[j]){
                        X[j] -= diff;
                    }
                    if(yUsed[j]){
                        Y[j] += diff;
                    }
                    else{
                        less[j] -= diff;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < graph.length; i++) {
            res += graph[match[i]][i];
            //System.out.println(graph[match[i]][i]);
        }
        System.out.println(res);

    }
    public boolean HungaryDFS(int i){
        xUsed[i] = true;
        for(int j = 0; j < graph.length; j ++ ){
            if(yUsed[j]){
                continue;
            }
            int gap = X[i] + Y[j] - graph[i][j];
            if(gap == 0){
                yUsed[j] = true;
                if(match[j] == -1 || HungaryDFS(match[j])){
                    match[j] = i;
                    return true;
                }
            }
            else{
                less[j] = less[j] <= gap ? less[j] : gap;
            }
        }
        return false;
    }
}
//
//class KM {
//    int[][] graph;
//    boolean[] xUsed;
//    boolean[] yUsed;
//    int[] match;
//    int len;
//    int[] less;
//    private static final int INFINITE = Integer.MAX_VALUE;;
//    int[] X;
//    int[] Y;
//    public KM(int[][] data) {
//        this.graph = data;
//        len = data.length;
//        xUsed = new boolean[len];
//        yUsed = new boolean[len];
//        match = new int[len];
//        less = new int[len];
//        X = new int[len];
//        Y = new int[len];
//        for (int i = 0; i < len; i++) {
//            match[i] = -1;
//        }
//        for (int k = 0; k < len; k++) {
//            X[k] = data[k][0];
//            for (int l = 0; l < len; l++) {
//                X[k] = X[k] >= data[k][l] ? X[k] : data[k][l];
//            }
//        }
//    }
//    void km() {
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len; j++) {
//                less[j] = INFINITE;
//            }
//            while (true) {
//                for (int j = 0; j < len; j++) {
//                    xUsed[j] = false;
//                    yUsed[j] = false;
//                }
//
//                if (HungaryDFS(i)) break;
//
//                int difference = INFINITE;
//                for (int j = 0; j < len; j++) {
//                    if (!yUsed[j]) difference = difference <= less[j] ? difference : less[j];
//                }
//                for (int j = 0; j < len; j++) {
//                    if (xUsed[j]) X[j] -= difference;
//                    if (yUsed[j]) Y[j] += difference;
//                    else less[j] -= difference;
//                }
//            }
//        }
//        int res = 0;
//        for (int i = 0; i < len; i++) {
//            res += graph[match[i]][i];
//            //System.out.println(graph[match[i]][i]);
//        }
//        System.out.println(-res);
//    }
//
//    private boolean HungaryDFS(int i) {
//        xUsed[i] = true;
//        for (int j = 0; j < len; j++) {
//            if (yUsed[j]) continue;
//            int gap =  X[i] + Y[j]- graph[i][j]  ;
//            if (gap == 0) {
//                yUsed[j] = true;
//                if (match[j] == -1 || HungaryDFS(match[j])) {
//                    match[j] = i;
//                    return true;
//                }
//            } else {
//                less[j] = less[j] <= gap ? less[j] : gap;
//            }
//        }
//        return false;
//    }
//}

