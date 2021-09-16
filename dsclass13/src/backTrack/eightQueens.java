package backTrack;
import java.util.*;
public class eightQueens {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        char[][] board = new char[N][N];
        for(int i = 0 ; i < N ; i ++ ){
            for(int j = 0 ; j < N ; j ++ ){
                board[i][j] = '.';
            }
        }
        int count = 0;
        solve(board, 0, count, N);
        System.out.println(count);
    }
    public static void solve(char[][] board, int x, int count, int N){
        if(x == N){
            display(board);
            count ++;
            return ;
        }
        for(int i = 0; i < board[0].length; i ++ ){
            if(check(board, i, x) == true){
                board[x][i] = 'Q';
                solve(board, x + 1, count, N);
                board[x][i] = '.';
            }
        }
    }
    public static boolean check(char[][] board, int x, int y){
        for(int i = 0 ; i < board.length ; i ++ ){
            if(i!= y && board[i][x] == 'Q'){
                return false;
            }
        }
        for(int i = 0; i < board[0].length; i ++ ){
            if(i !=x && board[y][i] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void display(char[][] board){
        for(int i = 0 ; i < board.length; i ++ ){
            for(int j = 0; j < board[0].length; j ++ ){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
