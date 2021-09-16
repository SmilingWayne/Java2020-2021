package homework;
import java.util.*;
public class homework40 {
    public static void main(String[] args) {
        /*
        SPFA 算法，成功实现！可以用来判断是否存在负环路
        测试数据：
        10   11
0    7   17.47

0    6      12.57

8    0    9.09

1    5   11.19

1    6   15.14

1    7   8.25

8    1   16.09

2    8   9.22

3    4   11.67

4    5    12.37

6    9   8.07
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
        for(int i = 0 ; i < m ; i ++ ){
            int x = scan.nextInt();
            int y = scan.nextInt();
            double length = scan.nextDouble();
            graph[x][y] = length;
        }
        scan.close();
        double[] dist = new double[graph.length];
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[0] = 0;
        double res = SPFA(graph, dist, 0);
        if(res != Double.MIN_VALUE){
            System.out.println(res);
        }
    }
    public static double SPFA(double[][] graph, double[] dist, int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] judge = new int[graph.length];
        Arrays.fill(judge, 0);
        boolean stop = false;
        while(!queue.isEmpty()){
            int a = queue.poll();
            for(int i = 0 ; i < graph.length; i ++ ){
                if(graph[a][i] != Double.MAX_VALUE){
                    if(dist[i] > dist[a] + graph[a][i]){
                        dist[i] = dist[a] + graph[a][i];
                        if(!queue.contains(i)){
                            queue.add(i);
                            judge[i] ++;
                            if(judge[i] == graph.length){
                                stop = true;
                                break;
                            }
                        }
                    }
                }
            }
            if(stop){
                System.out.println("存在负环路");
                return Double.MIN_VALUE;
            }
        }
        return dist[graph.length - 1];

    }
}
