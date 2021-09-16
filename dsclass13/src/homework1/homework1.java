package homework1;
import java.util.*;
public class homework1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numbers = scan.nextInt();
        int restrictions = scan.nextInt();
        int[][] matrix = new int[numbers][numbers];
        for(int i = 0; i < restrictions; i ++ ){
            int a = scan.nextInt();
            int b = scan.nextInt();
            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }
        scan.close();
        boolean[] visited = new boolean[numbers];
        int result = 0;
        int helpCompare = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < numbers; i ++ ){
            helpCompare = 0;
            if(visited[i] == false){
                queue.offer(i);
                visited[i] = true;
                helpCompare++;
                while(queue.size() > 0) {
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        int xlocation = queue.poll();
                        for (int j = 0; j < numbers; j++) {
                            if (visited[j] == false && matrix[xlocation][j] == 1) {
                                visited[j] = true;
                                queue.offer(j);
                                helpCompare++;
                            }
                        }
                    }
                }
                result = Math.max(result, helpCompare);
            }

        }
        System.out.println(result);

    }

}
