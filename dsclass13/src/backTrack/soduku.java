package backTrack;

import java.util.*;

public class soduku {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        SDK test = new SDK(board);
        test.dfs(0,0);

    }
}
class SDK{
    public char[][] board;
    public int length ;
    public int depth;
    public boolean[][] visited;
    public SDK(char[][] board){
        this.board = board;
        this.length = board.length;
        this.depth = board[0].length;
        visited = new boolean[length][depth];
        for(int i = 0; i < length; i ++ ){
            for(int j = 0 ; j < depth; j ++ ){
                visited[i][j] = false;
            }
        }
        for(int i = 0 ; i < length; i ++ ){
            for(int j = 0 ; j < depth; j ++ ){
                if(board[i][j] != '.'){
                    visited[i][j] = true;
                }
            }
        }
    }
    public boolean dfs(int row, int col){
        if(row == length){
            display();
            return true;
        }
        if(col == depth){
            return dfs(row + 1, 0);
        }
        if(visited[row][col] == true){
            return dfs(row, col + 1);
        }
        if(board[row][col] != '.'){
            return dfs(row, col + 1);
        }
        for(char i = '1' ; i <= '9' ; i ++ ){
            if(!isValid(row, col, i)){
                continue;
            }
            board[row][col] = i;
            if(dfs(row, col)){
                return true;
            }
            board[row][col] = '.';
        }
        return false;

    }
    public void display(){
        for(int i = 0; i < length; i ++ ){
            for(int j = 0 ; j < depth; j ++ ){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public boolean isValid(int row, int col ,char value){
        if(visited[row][col]){
            return false;
        }
        for(int i = 0; i < 9; i ++){
            if(board[i][col] != '.' && board[i][col] == value){
                return false;
            }
            if(board[row][i] != '.' && board[row][i] == value){
                return false;
            }
            if(board[3 * (row / 3) + i /3][3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i /3][3 * (col / 3) + i % 3] == value){
                return false;
            }
        }
        return true;
    }
}
