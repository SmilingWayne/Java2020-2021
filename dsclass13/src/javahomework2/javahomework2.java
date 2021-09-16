package javahomework2;
import java.util.*;
public class javahomework2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int all = scan.nextInt();
        int restrict = scan.nextInt();
        int[][] total = new int[restrict][2];
        for(int i = 0 ; i < restrict; i ++){
            total[i][0] = scan.nextInt();
            total[i][1] = scan.nextInt();
        }
        scan.close();
        System.out.println(judge(total, all));
    }
    public static boolean judge(int[][] total, int all){
        List<List<Integer>> edges = new LinkedList<>();
        for(int i = 0 ; i < all; i ++ ){
            edges.add(new LinkedList<Integer>());
        }
        int[] indeg = new int[all];
        for(int[] helper : total){
            edges.get(helper[1]).add(helper[0]);
            indeg[helper[0]] ++ ;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ;i < all; i ++ ){
            if(indeg[i] == 0){
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v: edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == all;
    }

}