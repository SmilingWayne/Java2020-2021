package BFS;
import java.util.*;
public class BFStest1 {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        int destination = scan.nextInt();
        scan.close();
        int[] route = {0,1,-1};
        int[] visited = new int[31];
        int res = 0;
        visited[start] = 1;
        queue.add(start);
        while(!queue.isEmpty()){
            int head = queue.peek();
            int next = 0;
            queue.poll();
            if(head == destination){
                res = visited[head] - 1;
            }
            else{
                for(int i = 0; i < 3; i++){
                    if(i == 0){
                        next = head * 2;
                    }
                    else{
                        next = head + route[i];
                    }
                    if(next < 0 || next > 30 || visited[next]!=0){
                        continue;
                    }
                    else{
                        queue.add(next);
                        visited[next] = visited[head] + 1;
                    }
                }
            }

        }
        System.out.println(res);

    }
}
