package homework;

import java.util.*;

public class homework10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        int col = scan.nextInt();
        int[][] grid = new int[row][col];
        for(int i = 0 ; i < row; i ++ ){
            for(int j = 0 ; j < col ; j ++ ){
                grid[i][j] = scan.nextInt();
            }
        }
        int startx = scan.nextInt();
        int starty = scan.nextInt();
        int endx = scan.nextInt();
        int endy = scan.nextInt();
        if(endx < 0 || endx >= row || endy < 0 || endy >= col){
            System.out.println(false);
        }
        else {
            dfs(grid, startx, starty);
            System.out.println(grid[endx][endy] == 2);
        }
    }
    public static void dfs(int[][] grid, int startx, int starty){
        if(startx < 0 || startx >= grid.length || starty < 0
                || starty > grid[0].length || grid[startx][starty] != 0){
            return;
        }
        grid[startx][starty] = 2;
        dfs(grid, startx + 1, starty);
        dfs(grid ,startx - 1, starty);
        dfs(grid , startx , starty + 1);
        dfs(grid , startx ,starty - 1);
    }
}
