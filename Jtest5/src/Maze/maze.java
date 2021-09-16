package Maze;
import java.util.*;

import static java.lang.Integer.parseInt;

public class maze {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int width = scan.nextInt();
        int depth = scan.nextInt();
        int[][] originalMaze = new int[width+2][depth+2];
        boolean[][] judgeRoute = new boolean[width+2][depth+2];
        for(int i = 0; i < width+2; i++){
            for(int j = 0; j< depth+2 ; j++){
                if(i==0||i==width+1||j==0||j==depth+1){
                    originalMaze[i][j] = 1;
                    judgeRoute[i][j] = true;
                }
                else
                {
                    originalMaze[i][j] = scan.nextInt();
                }
            }
        }
        int start_pointX = scan.nextInt();
        int start_pointY = scan.nextInt();
        int end_pointX = scan.nextInt();
        int end_pointY = scan.nextInt();
        scan.close();
        /*for(int i = 0 ;i<width +2;i++)
        {
            for(int j =0;j < depth +2;j++){
                System.out.print(originalMaze[i][j]+" ");
            }
            System.out.println(" ");
        }*/
        walkMaze stack = new walkMaze();
        /*System.out.println(start_pointX);
        System.out.println(start_pointY);
        System.out.println(end_pointX);
        System.out.println(end_pointY);*/

        if(start_pointX==end_pointX&&start_pointY==end_pointY)
            System.out.println("Yes");
        else{
            int next_pointX = start_pointX + 1;
            int next_pointY = start_pointY + 1;
            judgeRoute[next_pointX][next_pointY] = true;
            int formal_pointX = start_pointX + 1;
            int formal_pointY = start_pointY + 1;
            String temp = next_pointX+" "+next_pointY;
            stack.push(temp);
            while(!stack.is_empty()){
                if(originalMaze[next_pointX][next_pointY]==1||originalMaze[end_pointX+1][end_pointY+1]==1) {
                    System.out.println("No");
                    break;
                }
                if(next_pointX == end_pointX +1 && next_pointY == end_pointY +1) {
                    System.out.println("Yes");
                    break;
                }
                if(originalMaze[next_pointX+1][next_pointY]==0
                        &&next_pointX+1!=formal_pointX&&judgeRoute[next_pointX+1][next_pointY]!=true){
                    formal_pointX = next_pointX;
                    formal_pointY = next_pointY;
                    next_pointX = next_pointX + 1;
                    if(next_pointX == end_pointX +1 && next_pointY == end_pointY +1) {
                        System.out.println("Yes");
                        break;
                    }
                    judgeRoute[next_pointX][next_pointY] = true;
                    String temp1 = next_pointX + " " + next_pointY;
                    stack.push(temp1);
                    continue;
                }
                else if(originalMaze[next_pointX-1][next_pointY]==0
                        &&next_pointX-1!=formal_pointX&&judgeRoute[next_pointX-1][next_pointY]!=true){
                    formal_pointX = next_pointX ;
                    formal_pointY = next_pointY;
                    next_pointX = next_pointX - 1;
                    if(next_pointX == end_pointX +1 && next_pointY == end_pointY +1) {
                        System.out.println("Yes");
                        break;
                    }
                    judgeRoute[next_pointX][next_pointY] = true;
                    String temp2 = next_pointX + " " + next_pointY;
                    stack.push(temp2);
                    continue;
                }
                else if(originalMaze[next_pointX][next_pointY+1]==0&&
                        next_pointY+1!=formal_pointY&&judgeRoute[next_pointX][next_pointY+1]!=true) {
                    formal_pointX = next_pointX;
                    formal_pointY = next_pointY;
                    next_pointY = next_pointY + 1;
                    if(next_pointX == end_pointX +1 && next_pointY == end_pointY +1) {
                        System.out.println("Yes");
                        break;
                    }
                    judgeRoute[next_pointX][next_pointY] = true;
                    String temp3 = next_pointX + " " + next_pointY;
                    stack.push(temp3);
                    continue;
                }
                else if(originalMaze[next_pointX][next_pointY-1]==0
                        &&next_pointY-1!=formal_pointY&&judgeRoute[next_pointX][next_pointY-1]!=true){
                    formal_pointX = next_pointX;
                    formal_pointY = next_pointY;
                    next_pointY = next_pointY - 1;
                    if(next_pointX == end_pointX +1 && next_pointY == end_pointY +1) {
                        System.out.println("Yes");
                        break;
                    }
                    judgeRoute[next_pointX][next_pointY] = true;
                    String temp4 = next_pointX + " " + next_pointY;
                    stack.push(temp4);
                    continue;
                }
                else{
                    if(stack.get_top().equals("false")) {
                        System.out.println("No");
                        break;
                    }
                    else{
                        String temp5 = stack.pop();
                        String[] temp6 = temp5.split(" ");
                        int delete_pointX =Integer.parseInt(temp6[0]);
                        int delete_pointY =Integer.parseInt(temp6[1]);
                        originalMaze[delete_pointX][delete_pointY] = 1;
                        String temp7 = stack.get_top();
                        if(temp7.equals("false")){
                            System.out.println("No");
                            break;
                        }
                        else {
                            String[] temp8 = temp7.split(" ");
                            next_pointX =Integer.parseInt(temp8[0]);
                            next_pointY = Integer.parseInt(temp8[1]);
                            formal_pointX = next_pointX;
                            formal_pointY = next_pointY;
                            judgeRoute[next_pointX][next_pointY] = true;
                        }
                    }
                }
            }
        }

    }
    public static class walkMaze{
        public final int INITIAL_STACK_SIZE = 1000;
        public String[] base;
        public int top;
        public walkMaze(){
            base = new String[INITIAL_STACK_SIZE];
            top = 0;
        }
        public boolean is_empty(){
            if(top==0)
                return true;
            else{
                return false;
            }
        }
        public void push(String a){
            if(top == base.length)
                return;
            base[top++] = a;
        }
        public String pop(){
            if(top==0){
                return "false";
            }
            top--;
            return base[top];
        }
        public String get_top(){
            if(top == 0){
                return "false";
            }
            return base[top-1];
        }

    }
}
