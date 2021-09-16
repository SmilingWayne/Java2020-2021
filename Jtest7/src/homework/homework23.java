package homework;

import java.util.*;
public class homework23 {
    /*
    Floyd算法：
    输入数值：

    考虑问题：如何输出路径？

     */
    public static void main(String[] args) {
        int[][] data = {
                {0,27,44,17},
                {27,0,31,27},
                {44,31,0,19},
                {17,27,19,0},
        };
        Floyd a = new Floyd(data,1,3);
        System.out.println(a.solve());
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] grid = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            grid[x][y] = z;
            grid[y][x] = z;
        }
        int start = scan.nextInt();
        int end = scan.nextInt();
        Floyd fd = new Floyd(grid, start, end);


    }
}
class Floyd{
    public int[][] grid;
    public int start;
    public int end;
    public Floyd(int[][] grid, int start, int end){
        this.end = end;
        this.grid = grid;
        this.start = start;

    }
    public int solve(){

        int n = grid.length;
        for(int i = 0 ; i < n; i ++ ){
            for(int j = 0; j < n ; j ++ ){
                for(int k = 0 ; k < n ; k ++ ){
                    if(grid[j][i] + grid[i][k] < grid[j][k]){
                        grid[j][k] =  grid[j][i] + grid[i][k];
                    }
                }
            }
        }

        return grid[start - 1][end - 1];
    }


}
