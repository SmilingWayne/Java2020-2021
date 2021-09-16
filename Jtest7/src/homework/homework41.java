package homework;
import java.util.*;
public class homework41 {
    public int[][] flowgraph= null;
    public int[][] residentgraph = null;
    public int[] parent = null;
    /*
    Ford_Folkerson 算法的EK实现
    尚未完成，今天主要看了一下实现手段并手写实现
    具体问题：只看了augment实现：关键是先要找到回路，找到回路之后需要利用parent数组回溯
    parent记录自己的上一个节点
    /*
    完成啦！！
    求解网络最大流
     */


     /*
    测试数据:
    6 10
0 1 16
0 2 13
1 2 10
1 3 12
2 1 4
3 2 9
2 4 14
4 3 7
4 5 4
3 5 20
    参考内容：
    https://blog.csdn.net/The_sam/article/details/71456465?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-10.control&dist_request_id=1328740.42022.16170307299303181&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-10.control
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
        homework41 ford_Fulkerson = new homework41();
        ford_Fulkerson.parent = new int[m];
        System.out.println(ford_Fulkerson.edmondsKarpMaxFlow(graph, 0, 5));

    }

    public int edmondsKarpMaxFlow(int[][] graph, int s , int t){
        int length = graph.length;
        this.parent = new int[length];
        int[][] f = new int[length][length];
        for(int i = 0 ; i < length ; i ++ ){
            Arrays.fill(f[i] , 0);
        }
        int[][] r = residualgraph(graph, f);
        int result = augmentPath(r, s, t);
        int sum = 0;
        while(result != -1){
            int cur = t;
            while(cur != s){
                f[parent[cur]][cur] += result;
                f[cur][parent[cur]] = -f[parent[cur]][cur];
                r[parent[cur]][cur] -= result;
                r[cur][parent[cur]] += result;
                cur = parent[cur];
            }
            sum += result;
            result = augmentPath(r, s, t);
        }
        this.residentgraph = r;
        this.flowgraph = f;
        return sum;
    }


    /*
    augment就是寻找增广路的过程
     */
    public int augmentPath(int[][] graph, int s, int t){
        int maxlength = Integer.MAX_VALUE;
        Arrays.fill(this.parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        parent[s] = s;
        while(!queue.isEmpty()){
            int p = queue.poll();
            if(p == t){
                while(p != s){
                    if(maxlength > graph[parent[p]][p]){
                        maxlength = graph[parent[p]][p];
                    }
                    p = parent[p];
                }
            }
            else {
                for(int i = 0 ; i < graph.length; i ++ ){
                    if(parent[i] == -1 && i != p && graph[p][i] > 0 ){
                        parent[i] = p;
                        queue.add(i);
                    }
                }
            }
        }
        if(parent[t] == -1){
            return -1;
        }
        return maxlength;

    }
    /*
        寻找剩余路线图的，需要建筑在一个层次上
     */
    public int[][] residualgraph(int[][] cost, int[][] f){
        int length = cost.length;
        int[][] r = new int[length][length];
        for(int i = 0 ; i < length; i ++ ){
            for(int j = 0; j < length ; j ++ ){
                r[i][j] = cost[i][j] - f[i][j];
            }
        }
        return r;
    }
}
