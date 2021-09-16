package homework;

import java.util.*;
public class homework39 {
    public static void main(String[] args) {
        /*
        Bellman_ford 可以解决带负权单源最短路问题(有向)
        已实现
         */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        double[][] graph = new double[n][n];
        for(int i = 0 ; i < n ; i ++ ){
            for(int j = 0 ; j < n ; j ++ ){
                graph[i][j] = Double.MAX_VALUE;
            }
        }
        double test = scan.nextDouble();
        //System.out.println(test);
        for(int i = 0 ; i < m ; i ++ ){
            int x = scan.nextInt();
            int y = scan.nextInt();
            double length = scan.nextDouble();
            graph[x][y] = length;
        }
        scan.close();

        double[] dist = new double[n];
        Arrays.fill(dist, Double.MAX_VALUE);
        double ans = Bellman_Ford(graph, n - 1, dist, 0);
        System.out.printf("%.2f",ans);
    }
    public static double Bellman_Ford(double[][] graph, int end, double[] dist, int start){
        dist[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        for(int i = 1; i < graph.length ; i ++ ){
            int size = queue.size();
            boolean judge = true;
            for(int j = 0 ; j < graph.length; j ++ ){
                if(queue.contains(j)) {
                    for (int k = 0; k < graph.length; k++) {
                        if(graph[j][k]!= Double.MAX_VALUE && dist[k] > dist[j] + graph[j][k]){
                            dist[k] = dist[j] + graph[j][k];
                            queue.add(k);
                            judge = false;
                        }
                    }
                }
            }
            if(judge){
                break;
            }
            for(int j = 0 ; j < size ; j ++ ){
                queue.poll();
            }
        }

        boolean judge = false;
        for(int i = 0; i < graph.length; i ++ ){
            judge = true;
            for(int j = 0 ;j < graph.length ; j ++ ){
                if(i != j &&  graph[j][i] != Double.MAX_VALUE){
                    if(dist[i] > dist[j] + graph[j][i]){
                        System.out.println("存在负环！");
                        dist[i] = Double.MIN_VALUE;
                        break;
                    }
                }
            }
            if(judge){
                break;
            }
        }
        return dist[8];

    }
}
