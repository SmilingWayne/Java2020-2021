package RecursionPra1;
import java.util.*;
//最短路径和程序设定的走路策略有关系//

//篮子和球的问题//
//八皇后问题//
//扑克牌解决//
//排序算法//
//分治算法//
//最短路径//
//最小生成树//

//注意事项：有栈空间的生成;方法的局部变量是独立的，不会相互影响
// 共享引用类型的变量//
//迷宫问题//
//必须要退出递归的条件靠近//
//StackOverflowError表示无限递归//

public class recursionpra1 {
    public static void main(String[] args){
        int[][] maze = new int[8][7];
        for(int i = 0 ; i < 7 ; i++){
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        for(int i = 0; i < 8 ; i++){
            maze[i][0] = 1;
            maze[i][6] = 1;
        }
        maze[3][1] = 1;
        maze[3][2] = 1;

        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
        setWay2(maze,1,1,6,5);
        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean setWay(int[][] map, int i ,int j,int destination_X,int destination_Y){
        if(map[destination_X][destination_Y] == 2){
            return true;
        }
        else{
            if(map[i][j] == 0){
                map[i][j] = 2;
                if(setWay(map,i+1,j,destination_X,destination_Y)) {
                    return true;
                }
                else if(setWay(map,i,j+1,destination_X,destination_Y)) {
                    return true;
                }
                else if(setWay(map,i-1,j,destination_X,destination_Y)) {
                    return true;
                }
                else if(setWay(map,i,j-1,destination_X,destination_Y)){
                    return true;
                }
                else {
                    map[i][j] = 3;
                    return false;
                }

            }
            else{
                return false;
            }
        }
    }
    public static boolean setWay2(int[][] map, int i ,int j,int destination_X,int destination_Y){
        if(map[destination_X][destination_Y] == 2){
            return true;
        }
        else{
            if(map[i][j] == 0){
                map[i][j] = 2;
                if(setWay2(map,i-1,j,destination_X,destination_Y)) {
                    return true;
                }
                else if(setWay2(map,i,j+1,destination_X,destination_Y)) {
                    return true;
                }
                else if(setWay2(map,i+1,j,destination_X,destination_Y)) {
                    return true;
                }
                else if(setWay2(map,i,j-1,destination_X,destination_Y)){
                    return true;
                }
                else {
                    map[i][j] = 3;
                    return false;
                }

            }
            else{
                return false;
            }
        }
    }
}
