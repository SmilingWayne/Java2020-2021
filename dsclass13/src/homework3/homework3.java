package homework3;
import java.util.*;
public class homework3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int[][] matrix = new int[total][total];
        int[][] board = new int[total][2];
        for(int i = 0 ; i < total; i ++ ){
            board[i][0] = scan.nextInt();
            board[i][1] = scan.nextInt();
        }
        scan.close();
        for(int i = 0 ; i < total; i ++ ){
            for(int j = 0 ; j < total; j++ ){
                matrix[i][j] = (int)Math.sqrt((board[i][0]-board[j][0])*(board[i][0]-board[j][0]) + (board[i][1]-board[j][1])*(board[i][1]-board[j][1]));
            }
        }
        /*for(int i = 0 ; i < total ; i ++ ){
            for(int j = 0; j < 2 ; j ++ ){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
         */
        /*for(int i = 0 ; i < total; i ++ ){
            for(int j = 0; j < total; j ++ ){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

         */

        boolean[] visited = new boolean[total];

        ArrayList<Integer> help = new ArrayList<>();
        help.add(0);
        visited[0] = true;
        int res = 0;

        while(help.size() < total){
            Stack<Integer> stack = new Stack<>();
            int compare = Integer.MAX_VALUE;
            for(int i = 0 ; i < help.size(); i ++ ){
                for(int j = 0; j < total; j ++ ){
                    if(j != help.get(i) && visited[j] == false){
                        int ano = compare;
                        compare = Math.min(compare, matrix[help.get(i)][j]);
                        if(ano > compare){
                            if(stack.size() == 0){
                                stack.push(j);
                            }
                            else{
                                int clare = stack.pop();
                                visited[clare] = false;
                                stack.push(j);
                            }
                        }
                    }
                }


            }
            visited[stack.peek()] = true;
            //System.out.println(stack.peek());
            help.add(stack.pop());
            res += compare;

        }
        System.out.println(res);



    }
}
