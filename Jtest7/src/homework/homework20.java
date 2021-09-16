package homework;
import java.util.*;
public class homework20 {
    public static void main(String[] args) {
        /*
        数塔问题：
        从上到下，可以走左或者右
        5
        9
        12 15
        10 6 8
        21 8 9 5
        19 7 10 4 16
        Answer: 71
         */
        Scanner scan = new Scanner(System.in);
        int all = scan.nextInt();
        int[][] tower = new int[all][];
        for(int i = 0 ; i < all ; i ++ ){
            tower[i] = new int[i + 1];
            for(int j = 0; j < i + 1; j ++ ){
                tower[i][j] = scan.nextInt();
            }
        }
        if( all == 1){
            System.out.println(tower[0][0]);
        }
        else {
            for (int i = all - 2; i >= 0; i--) {
                for(int j = 0 ; j < i + 1; j ++ ){
                    tower[i][j] = Math.max(tower[i + 1][j], tower[i + 1][j + 1]) + tower[i][j];
                }
            }
            System.out.println(tower[0][0]);
        }

    }

}
