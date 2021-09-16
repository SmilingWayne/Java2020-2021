package homework;
import java.util.*;
public class homework30 {
    /*
    螺旋矩阵√
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int[][] board = new int[len][len];
        rotateMatrix(board, 1, 0, 0, len );
        for(int i = 0; i < len; i ++ ){
            for(int j = 0 ; j < len; j ++ ){
                System.out.print(board[i][j] +  " ");
            }
            System.out.println("");
        }
    }
    public static void rotateMatrix(int[][] board, int number, int x ,int y, int length){
        if(length < 1) {
            return;
        }
        for(int i = x; i < x + length ; i ++ ){
            board[y][i] = number;
            number ++ ;
        }
        for(int i = y + 1; i < y + length; i ++ ){
            board[i][x + length - 1] = number;
            number ++ ;
        }
        for(int i = x + length - 2; i >= x; i -- ){
            board[y + length - 1][i] = number;
            number ++ ;
        }
        for(int i = y + length - 2; i > y; i --  ){
            board[i][x] = number;
            number ++ ;
        }
        rotateMatrix(board, number, x + 1, y + 1, length -2 );
    }
}
