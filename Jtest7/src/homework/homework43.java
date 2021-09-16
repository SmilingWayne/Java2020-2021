package homework;
import java.util.*;
public class homework43 {
    /*
    这里写一个Dicnic算法，利用每个节点的分层图求解网络最大流问题
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int lines = scan.nextInt();
        int[][] graph = new int[m][m];
        for(int i = 0 ; i < lines ; i ++ ){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph[a][b] = scan.nextInt();
        }
        scan.close();
        Dicnic dc = new Dicnic(graph, 5, 0);
        System.out.println(dc.dicnicMain());
    }
}
class Dicnic{
    public int points;

    public int[][] resident = null;
    public int[] parent = null;
    public int[] depth = null;
    public int destination;
    public int begin;
    public Dicnic(int[][] graph, int destination, int begin){
        this.destination = destination;
        this.begin = begin;
        this.points = graph.length;
        this.resident = graph;
        this.parent = new int[points];
        this.depth = new int[points];

    }
    public int dicnicMain(){
        int sum = 0;
        while(judge()){
            int add = dfs(begin, Integer.MAX_VALUE);
            while(add > 0){
                sum += add;
                add = dfs(begin, Integer.MAX_VALUE);
            }
        }
        return sum;
    }
    public int dfs(int s, int sum){
        if(s == destination){
            return sum;
        }
        for(int i = 0 ; i < points; i ++ ){
            if(i != s && resident[s][i] != 0 && depth[i] == depth[s] + 1){
                int next = dfs(i, Math.min(resident[s][i], sum));
                if(next > 0){
                    resident[s][i] -= next;
                    resident[i][s] += next;
                    return next;
                }
            }
        }
        return 0;
    }
    public boolean judge(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(begin);
        Arrays.fill(this.depth, 0);
        depth[begin] = 1;
        while(!queue.isEmpty()){
            int a = queue.poll();
            for(int i = 0 ; i < this.points; i ++ ){
                if(resident[a][i] != 0 && i != a && depth[i] == 0){
                    depth[i] = depth[a] + 1;
                    queue.add(i);
                }
            }
        }
        if(depth[this.destination] == 0){
            return false;
        }
        return true;

    }



}
