package backTrack;

import java.beans.Visibility;
import java.util.*;
public class findValGrid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String target = scan.next();
        char[][] grid = {
                {'A','B','E','D'},
                {'S','F','C','E'},
                {'A','D','E','E'}
        };
        Grid board = new Grid(grid, target);
        System.out.println(board.exist());
    }
}
class Grid{
    public char[][] grid;
    public int length ;
    public int depth;
    public String target;
    public Grid(char[][] grid, String target){
        this.grid = grid;
        this.length = grid.length;
        this.depth = grid[0].length;
        this.target = target;
    }
    public boolean exist(){
        for(int i = 0 ; i < length; i ++ ){
            for(int j = 0 ; j < depth ;j ++ ){
                if(dfs(0, i , j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int index ,int row, int col){
        if(index == target.length()){
            return true;
        }
        if(row < 0 || row >= length || col < 0 || col >= depth || grid[row][col] != target.charAt(index)){
            return false;
        }
        char a = grid[row][col];
        grid[row][col] = '.';
        /*
        boolean a1 = dfs(index + 1, row + 1, col);
        if(a1){
            return true;
        }
        boolean a2 = dfs(index + 1, row - 1, col);
        if(a2){
            return true;
        }
        boolean a3 = dfs(index + 1, row, col + 1);
        if(a3){
            return true;
        }
        boolean a4 = dfs(index + 1, row, col  - 1);
        if(a4){
            return true;
        }

         */
        boolean res = dfs(index + 1, row + 1, col) ||
                dfs(index + 1, row, col  - 1)||
                dfs(index + 1, row, col + 1)||
                dfs(index + 1, row - 1, col);
        grid[row][col] = a;
        return res;
    }

}

