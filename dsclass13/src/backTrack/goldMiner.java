package backTrack;

import java.util.*;

public class goldMiner {
    public static void main(String[] args) {
        /*
        Number shows the gold the miner can get in this position, 0 position can't be reached and you must find a root to
        get the maximum gold volume.
        Question: how to get the route?
        FIrst test : failed, reasons:
        * only applies to the first root be the start of route, because as the grid goes on , the arrayList would be replaced
        by following grid point.
        *
        Second test :SUCCEED! From the last time location , start dfs.

         */
        int[][] grid = {
                {7,0,7},
                {2,0,1},
                {5,4,2},
                {0,3,0},
                {9,1,20}
        };
        mine miner = new mine(grid);
        System.out.println(miner.find());
    }
}
class mine{
    public int[][] grid;
    public int length ;
    public int width;
    public mine(int[][] grid){
        this.grid = grid;
        this.length = grid.length;
        this.width = grid[0].length;
    }

    public int find(){
        int max = 0;
        int[] route = {0,0};
        for(int i = 0; i < length ; i ++ ){
            for(int j = 0 ; j < width; j ++ ){
                int temp = max;
                max = Math.max(max, dfs(i, j));
                if(temp != max){
                    route[0] = i;
                    route[1] = j;
                }
            }
        }
        getRoute(route, max);
        System.out.println("");
        return max;
    }
    public void getRoute(int[] route, int max){
        if(route[0] < 0 || route[0] >= length || route[1] < 0 || route[1] >= width || max <= 0){
            return;
        }
        System.out.print("(" + route[0] + " , " + route[1] + ")" + "->" );
        int a1 = dfs(route[0] + 1, route[1]);
        int a2 = dfs(route[0] - 1, route[1]);
        int a3 = dfs(route[0], route[1] + 1);
        int a4 = dfs(route[0], route[1] - 1);
        int past = Math.max(a1, Math.max(a2,Math.max(a3,a4)));
        past = Math.max(0, past);
        //System.out.print("[" + max +"]");
        int row = route[0];
        int col = route[1];
        if(past == a1){
            route[0] = row + 1;
            route[1] = col;
        }
        else if(past == a2){
            route[0] = row - 1;
            route[1] = col;
        }
        else if(past == a3){
            route[0] = row;
            route[1] = col + 1;
        }
        else{
            route[0] = row;
            route[1] = col - 1;
        }
        if(past == 0){
            System.out.println("End");
            return ;
        }
        else {
            grid[route[0]][route[1]] = 0;
            getRoute(route, max);
        }
    }
    public int dfs(int row, int col){
        if(row < 0 || row >= length || col < 0 || col >= width || grid[row][col] == 0){
            return 0;
        }
        int temp = grid[row][col];
        grid[row][col] = 0;
        int a1 = dfs(row + 1, col);
        int a2 = dfs(row - 1, col);
        int a3 = dfs(row, col + 1);
        int a4 = dfs(row, col - 1);
        int past = Math.max(a1, Math.max(a2,Math.max(a3,a4)));
        grid[row][col] = temp;
        return past + temp;

    }

}
