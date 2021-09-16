package javahw3;
import java.util.*;

public class javahw3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int life = scan.nextInt();
        int[][] board = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n; i ++ ){
            for(int j = 0 ; j < m ; j ++ ){
                board[i][j] = scan.nextInt();
            }
        }
        scan.close();
        int lifeCount = 0;
        Stack<int[]> stack = new Stack<>();
        int startx = 0;
        int starty = 0;
        int[] h = new int[2];
        h[0] = startx;
        h[1] = starty;
        boolean trigger = true;
        visited[startx][starty] = true;
        stack.push(h);
        boolean isEmpty = false;
        while(true){
            if(startx == 0 && starty == m - 1){
                break;
            }
            //System.out.println(startx + " " + starty);
            //System.out.println("lifecount:" + lifeCount);
            while(true) {
                if (startx * 3 + (m - 1 - starty) >= life - lifeCount || trigger == false) {
                    //System.out.println("stop");
                    visited[startx][starty] = true;
                    stack.pop();
                    int[] pre = stack.peek();
                    int prex = pre[0];
                    int prey = pre[1];
                    //System.out.println("prex :" + prex + " prey:" + prey);
                    if (prey - starty == 1 || prey - starty == -1) {
                        lifeCount -= 1;
                    } else if (prex - startx == 1) {
                        lifeCount -= 3;
                    }
                    startx = prex;
                    starty = prey;
                    trigger = true;
                }
                else{
                    break;
                }
            }
            trigger = false;
            int[] directx = {0,1,-1,0};
            int[] directy = {1,0,0,-1};
            for(int i = 0; i < 4; i ++){
                if(startx + directx[i] >= 0 && startx + directx[i] < n && starty + directy[i] >= 0 && starty + directy[i] < m){
                    if(board[startx + directx[i]][starty + directy[i]] != 0 && visited[startx + directx[i]][starty + directy[i]] == false){
                        startx = startx + directx[i];
                        starty = starty + directy[i];
                        visited[startx][starty] = true;
                        int[] help = new int[2];
                        help[0] = startx;
                        help[1] = starty;
                        stack.push(help);
                        trigger = true;
                        if(i == 0 || i == 3){
                            lifeCount += 1;
                        }
                        if(i == 2){
                            lifeCount += 3;
                        }
                        break;
                    }
                }
            }
            if(startx == 0 && starty == 0 && trigger == false){
                isEmpty = true;
                break;
            }
        }

        if(isEmpty){
            System.out.println("Can not escape!");
        }
        else{
            int[] a = stack.pop();
            String ans = "[" + a[0] + ", "+a[1] + "]";
            while(!stack.isEmpty()){
                int[] b = stack.pop();
                ans = "[" + b[0] + ", "+ b[1] + "], " + ans;
            }
            System.out.println(ans);
        }



        //System.out.println("[0, 0], [1, 0], [1, 1], [2, 1], [2, 2], [2, 3], [1, 3], [0, 3]");


    }
}
