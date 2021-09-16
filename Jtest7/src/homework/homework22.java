package homework;
import java.util.*;

public class homework22 {
    /*
    Dijkstra算法：
    测试数据：
    7 12
        1 2 3
        1 3 5
        2 4 7
        3 4 6
        4 5 4
        5 6 6
        4 6 8
        4 7 5
        7 6 7
        2 3 1
        2 5 12
        3 6 11
        7表7个点；
        12表12个边；
        MST输入的两个数字表示起点和终点
        这里判断环路：直接忽略环了，直接看是否遍历过这个数字
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int edge = scan.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0 ; i < n; i ++ ){
            for(int j = 0 ; j < n ; j ++ ){
                matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0 ; i < edge; i ++ ){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int dis = scan.nextInt();
            matrix[x - 1][y - 1] = dis;
            matrix[y - 1][x - 1] = dis;
        }
        Dijkstra jk = new Dijkstra(n, edge, matrix);
        System.out.println(jk.MST(1,7));

    }
}
class Dijkstra{
    public int vex_num;
    public int edge_num;
    public int[][] matrix ;
    public boolean[] visited;
    public int[] dis;
    public int[] path;
    public Dijkstra(int vex_num, int edge_num, int[][] matrix){
        this.vex_num = vex_num;
        this.edge_num = edge_num;
        this.matrix = matrix;
        visited = new boolean[vex_num];
        this.dis = new int[vex_num];
        this.path = new int[vex_num];
    }
    public int MST(int start, int end){
        for(int i = 0; i < vex_num; i ++ ){
            dis[i] = matrix[start - 1][i];
        }
        int min_cost = 0;        // 权值最小
        int min_cost_index = start;  // 权值最小的下标

        for (int i = 1; i < vex_num; i++)  // 找到源点到另外 vertex_num-1 个点的最短路径
        {
            min_cost = Integer.MAX_VALUE;

            for (int j = 0; j < vex_num; j++)
            {
                if (visited[j] == false && dis[j] < min_cost)  // 找到权值最小
                {
                    min_cost = dis[j];
                    min_cost_index = j;
                }
            }
            visited[min_cost_index] = true;  // 该点已找到，进行标记
            for (int j = 0; j < vex_num; j++)  // 更新 dist 数组
            {
                if (visited[j] == false &&
                        matrix[min_cost_index][j] != Integer.MAX_VALUE &&  // 确保两点之间有边
                        matrix[min_cost_index][j] + min_cost < dis[j])
                {
                    dis[j] = matrix[min_cost_index][j] + min_cost;
                    path[j] = min_cost_index;
                }
            }
        }
        return dis[end - 1];
    }
}