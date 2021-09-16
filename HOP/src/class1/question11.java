package class1;
import java.util.*;
public class question11{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        double[][] graph = new double[n][n];
        for (int i = 0; i < m; i++) {
            int temp_1 = scan.nextInt();
            int temp_2 = scan.nextInt();
            double temp_3 = scan.nextDouble();
            graph[temp_1][temp_2] = temp_3;
            graph[temp_2][temp_1] = temp_3;
        }
        scan.close();
        System.out.printf("%.2f", Dijkstra(graph));
    }
    private static double Dijkstra(double[][] graph) {
        int n = graph.length;
        double[] distance = new double[n];
        int[] judge = new int[n];
        Arrays.fill(distance, Double.MAX_VALUE);
        distance[0] = 0;
        judge[0] = -1;
        int i = 0, j, m = -1, t = 1;
        double min = Double.MAX_VALUE;
        while (true) {
            for (j = 0; j < n; j++) {
                if (judge[j] != -1 && graph[i][j] != 0) {
                    distance[j] = Math.min(distance[j], distance[i] + graph[i][j]);
                    judge[j] = 1;
                    if (distance[j] < min) {
                        min = distance[j];
                        m = j;
                    }
                }
            }
            judge[m] = -1;
            t++;
            if (t != n) {
                i = m;
                min = Double.MAX_VALUE;
                for (j = 0; j < n; j++) {
                    if (judge[j] == 1 && distance[j] < min) {
                        min = distance[j];
                        m = j;
                    }
                }
            } else
                break;
        }
        return distance[n - 1];
    }
}