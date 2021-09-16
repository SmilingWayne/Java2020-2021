package homework2;
import java.util.*;
public class homework2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numbers = scan.nextInt();
        int lines = scan.nextInt();
        int[][] matrix = new int[numbers][numbers];
        for(int i = 0 ; i < lines; i ++ ){
            int a = scan.nextInt();
            int b = scan.nextInt();
            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }
        scan.close();
        boolean[] visited2 = new boolean[numbers];
        boolean[] visited1 = new boolean[numbers];

        dfs(matrix, visited1, 0);
        System.out.println("");
        bfs(matrix,visited2);
    }
    public static void dfs(int[][] matrix ,boolean[] visited1, int start){
        if(start == 0){
            visited1[0] = true;
            System.out.print(start + " ");

        }
        for(int i = 0 ; i < matrix[0].length; i ++ ){
            if(visited1[i] == false && matrix[start][i] == 1){
                visited1[i] = true;
                System.out.print(i + " ");
                dfs(matrix, visited1, i);
            }
        }
    }
    public static void bfs(int[][] matrix ,boolean[] visited2){
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        queue.add(matrix[0][0]);
        ans.add(matrix[0][0]);
        visited2[matrix[0][0]] = true;
        count ++;
        while(queue.size() > 0){
            int size = queue.size();
            for(int j = 0; j < size; j ++ ) {
                int target = queue.poll();
                for (int i = 0; i < matrix[0].length; i++) {
                    if (matrix[target][i] == 1 && visited2[i] == false) {
                        visited2[i] = true;
                        queue.add(i);
                        ans.add(i);
                        count++;
                    }
                }
            }
        }
        for(int i = 0; i < ans.size(); i ++ ){
            System.out.print(ans.get(i) + " ");
        }
    }

}
