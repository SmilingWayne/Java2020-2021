package hshomework7;
import java.util.*;
public class dshomework {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        int number = 1;
        int[][] matrix = new int[n][n];
        int x1 = 0,x2 = n - 1;
        int y1 = 0;
        while(x2 >= x1){
            insert(number,matrix,x1,x2,y1);
            number += (x2 - x1) * 4 ;
            x1 ++;
            x2 --;
            y1 ++;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

    }
    public static void insert(int x ,int[][] matrix,int startX, int endX,int startY){
        matrix[startX][startY] = x;
        x++;
        int maximum = (endX - startX) * 4;
        int fixedLength = endX - startX;
        boolean[] flag = new boolean[3];
        int count = 0;
        Arrays.fill(flag,false);
        for(int i = x; i < x + maximum - 1; i++){
            if( count/(fixedLength) == 1 && count % (fixedLength) == 0){
                flag[0] = true;
            }
            if( count/(fixedLength) == 2 && count % (fixedLength) == 0){
                flag[1] = true;
            }
            if( count/(fixedLength) == 3 && count % (fixedLength) == 0){
                flag[2] = true;
            }
            if(flag[0] == false){
                startX ++;
                matrix[startY][startX] = i;
                count ++;
            }
            else if(flag[0] == true && flag[1] == false){
                startY ++;
                matrix[startY][startX] = i;
                count ++;
            }
            else if(flag[0] == true && flag[1] == true && flag[2] == false){
                startX --;
                matrix[startY][startX] = i;
                count ++;
            }
            else if(flag[0]&& flag[1] && flag[2]){
                startY --;
                matrix[startY][startX] = i;
                count ++;
            }
        }
    }
}
