package javahomework1;
import java.util.*;
public class javahomework1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[][] board = new int[length + 2][length + 2];
        boolean exist = false;
        int res = 0;
        for(int i = 0; i < length + 2; i ++ ){
            for(int j = 0 ; j < length + 2; j ++ ){
                if(i == 0 || j == 0 || i == length + 1 || j == length + 1){
                    board[i][j] = 0;
                }
                else{
                    board[i][j] = scan.nextInt();
                    if(board[i][j] == 1){
                        exist = true;
                    }
                }
            }
        }
        if(exist == false){
            System.out.println("0");
        }
        else{
            int count = 2;
            for(int i = 0; i < length + 2; i ++ ){
                for(int j = 0; j < length + 2; j ++ ){
                    if(board[i][j] == 1){
                        dfs(board,i,j,count);
                        count ++;
                    }
                }
            }
            int[] judge = new int[count - 2];
            for(int i = 0; i < length + 2; i ++){
                for(int j = 0 ; j < length + 2; j ++ ){
                    if(board[i][j] > 1){
                        judge[board[i][j] - 2] ++;
                    }
                }
            }
            for(int i = 0; i < judge.length; i ++ ){
                res = Math.max(judge[i],res);
            }
            System.out.println(res);

        }

    }
    public static void dfs(int[][] total, int x, int y, int given){
        if(x < 0 || y < 0 || x >= total.length || y >= total.length || total[x][y] != 1){
            return;
        }
        if(total[x][y] == 1) {
            total[x][y] = given;
        }
        dfs(total, x - 1, y, given);
        dfs(total, x + 1, y, given);
        dfs(total, x, y + 1, given);
        dfs(total, x ,y - 1, given);
    }
}
