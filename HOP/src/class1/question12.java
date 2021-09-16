//package class1;
import java.util.*;
public class question12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] board = new int[n];
        boolean[] used = new boolean[n + 1];
        boolean ok = false;
        backTrack(board, used, 0);
    }
    public static boolean backTrack(int[] board, boolean[] used, int row){
        int n = board.length;
        if(row == n ){
            for(int i = 0; i < board.length; i ++ ){
                System.out.print(board[i] + " ");
            }
            System.out.println("");

            return true;
        }
        for(int i = 1; i <= n; i ++ ){
            if(used[i] == false && judge(board, row, i)){
                used[i] = true;
                board[row] = i;
                if(backTrack(board, used, row + 1)){
                    return true;
                }
            }
            used[i] = false;
        }
        return false;
    }
    public static boolean judge(int[] board, int len, int cur){
        for(int i = 0; i < len; i ++ ){
            if(board[i] == cur || cur == board[i] - (len - i) || cur == board[i] + (len - i)){
                return false;
            }
        }
        return true;
    }
}
