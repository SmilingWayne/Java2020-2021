package Main;
import java.util.Scanner;

public class Main {
    public static String path = "";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int life = in.nextInt();
        int[][] board = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] = in.nextInt();
            }
        }
        dfs(board,0,0,visited,"",life);
        System.out.println(path);
    }
    public static void dfs(int[][] grid,int i,int j, boolean[][] visited,String res,int p) {
        if(i == 0 && j == grid[0].length-1 && grid[i][j] == 1){
            if(p >=0 ){
                path = res + "["+i+", "+j+"]";
            }else{
                path =  "Can not escape!";
            }
            return;
        }
        if(i >=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]==1 && !visited[i][j]){
            visited[i][j] = true;
            res += "["+i+", "+j+"], ";
            dfs(grid,i,j+1,visited,res,p-1);
            dfs(grid,i+1,j,visited,res,p);
            dfs(grid,i,j-1,visited,res,p-1);
            dfs(grid,i-1,j,visited,res,p-3);
        }
    }
}

