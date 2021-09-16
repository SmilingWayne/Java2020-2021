package class1;
import java.util.*;
public class question10 {
    /*
    DFS 解决最短路问题：
    70分
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        double[][] graph = new double[n][n];
        for(int i = 0 ; i < n ; i ++ ){
            for(int j = 0 ; j < n ; j ++ ){
                graph[i][j] = Double.MAX_VALUE;
            }
        }
        for(int i = 0 ; i < m ; i ++ ){
            int x = scan.nextInt();
            int y = scan.nextInt();
            double length = scan.nextDouble();
            graph[x][y] = length;
            graph[y][x] = length;
        }
        double[] route = new double[n];
        Arrays.fill(route, Double.MAX_VALUE);
        route[0] = 0;
        dfs(graph, 0, route);
        System.out.printf("%.2f", route[n - 1]);
    }
    public static void dfs(double[][] graph, int position, double[] route){
        for(int i = 0 ; i < graph.length; i ++ ){
            if(i == position){
                continue;
            }
            if(route[position] + graph[position][i] < route[i]){
                route[i] = route[position] + graph[position][i];
                dfs(graph, i, route);
            }
        }
    }
}