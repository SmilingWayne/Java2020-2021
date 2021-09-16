package class1;
import java.util.*;
public class question9 {
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
        boolean[] visited = new boolean[n];
        Arrays.fill(route, Double.MAX_VALUE);
        route[0] = 0;
        double x = Dijkstra(0, graph, route, visited);
        System.out.printf("%.2f",x);
    }
    public static double Dijkstra(int src, double[][] graph,double[] route, boolean[] visited){
        int n = graph.length;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.cost > o2.cost){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });
        pq.add(new Node(src, 0));
        while (!pq.isEmpty()){
            Node t = pq.poll();
            int x = t.node;
            if(x == graph.length - 1) {
                return route[graph.length - 1];
            }
            if (visited[x]){
                continue;
            }
            visited[x] = true;
            for(int i = 0; i < n; i ++) {
                if(graph[x][i] == Double.MAX_VALUE || visited[i] == true ){
                    continue;
                }
                double a = route[x] + graph[x][i];
                if (a < route[i]) {
                    route[i] = a;
                    pq.add(new Node(i, route[i]));
                }
            }
        }
        return -1;
    }
}
class Node {
    public int node;
    public double cost;
    public Node(int node, double cost){
        this.node = node;
        this.cost = cost;
    }
}