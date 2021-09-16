package hungary;
import java.util.*;
public class hungary {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int max = scan.nextInt();
        System.out.println("Input " + max*max +" numbers ： ");
        int[][] total = new int[max][max];
        for(int i = 0; i < max*max; i++){
            total[i/max][i%max] = scan.nextInt();
        }
        scan.close();
        int[][] helper = new int[max][max];
        for(int i = 0 ; i < max; i ++){
            for(int j = 0 ; j < max; j++){
                helper[i][j] = total[i][j];
            }
        }
        for(int i = 0; i < max; i++){
            int min = total[i][0];
            for(int j = 0; j < max; j++){
                min = Math.min(min,total[i][j]);
            }
            for(int j = 0; j < max; j++){
                total[i][j] = total[i][j] - min;
            }
        }
        for(int i = 0; i < max; i++){
            boolean flag = false;
            int min = total[0][i];
            for(int j = 0; j < max; j++){
                min = Math.min(min,total[j][i]);
                if(total[j][i] == 0){
                    flag = true;
                    break;
                }
            }
            if(flag){
                continue;
            }
            else{
                for(int j = 0; j < max; j++){
                    total[j][i] = total[j][i] - min;
                }
            }
        }

    }
}
