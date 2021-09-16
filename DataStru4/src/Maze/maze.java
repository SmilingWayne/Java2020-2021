package Stack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class maze{

    public static void main(String[] args) throws Exception{
        /*File file = new File("src/data/input");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = scan.nextInt();
            }
        }
        boolean[][] visit = new boolean[n][m];

        int origin_x = scan.nextInt();
        int origin_y = scan.nextInt();
        int dest_x = scan.nextInt();
        int dest_y = scan.nextInt();
        SeqStack2 stack = new SeqStack2();
        stack.push(new SeqStack2.Coordinate(origin_x, origin_y));
        while(stack.is_empty() == false){
            SeqStack2.Coordinate cord = stack.get_top();
            if(cord.x == dest_x && cord.y == dest_y){
                break;
            }
            if(cord.direction >= 3){
                stack.pop();
                continue;
            }
            if(cord.direction == -1){
                if(cord.y + 1 < m && map[cord.x][cord.y + 1] == 0){
                    stack.push(new SeqStack2.Coordinate(cord.x, cord.y + 1));
                }
            }
            else if(cord.direction == 0){
                if(cord.x - 1 >= 0 && map[cord.x - 1][cord.y] == 0){
                    stack.push(new SeqStack2.Coordinate(cord.x - 1, cord.y));
                }
            }


        }*/
    }
}