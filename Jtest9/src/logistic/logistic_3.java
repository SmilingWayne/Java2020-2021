package logistic;
import java.util.*;

/**
 * 贪婪取走启发式算法
 */
public class logistic_3 {
    public static void main(String[] args) {
        int[][] c = {{4,12,20,6},{2,10,25,10},{3,4,16,14},{6,5,9,2},{18,12,7,3},{14,4,4,9},{20,30,2,11},{24,12,6,22}};
        int[] d = {100,50,120,80,200,70,60,100};
        Set<Integer> choice = new HashSet<>();
        int[] supermarket = new int[c.length];
        for(int i = 0; i < c.length; i ++ ){
            int index = 0;
            for(int j =0 ; j < 4; j ++ ){
                if(c[i][j] < c[i][index]){
                    index = j;
                }
            }
            supermarket[i] = index + 1;
        }
        int totalcenter = 4;
        while(totalcenter > 2){
            int[] lost = new int[4];
            if(choice.size() > 0){
                for(int i : choice){
                    lost[i] = Integer.MAX_VALUE;
                }
            }
            for(int i = 0 ; i < c.length; i ++ ){
                int count = Integer.MAX_VALUE;
                for(int j = 0 ; j < c[0].length; j ++ ){
                    if(j != supermarket[i] - 1 && !choice.contains(j)){
                        if(c[i][j] - supermarket[i] - 1 < count){
                            count = c[i][j] - supermarket[i] - 1;
                        }
                    }
                }
                lost[supermarket[i] - 1] += count * d[i];
            }
            int current_index = 0;
            for(int i = 1 ; i < lost.length; i ++ ){
                if(lost[i] < lost[current_index]){
                    current_index = i;
                }
            }
            System.out.println("\t\t删除 " + (current_index+1) + " 物流中心");
            choice.add(current_index);
            for(int i = 0; i < c.length; i ++ ){
                int index = 0;
                for(int j = 0 ; j < 4; j ++ ){
                    if(c[i][j] < c[i][index] && !choice.contains(j)){
                        index = j;
                    }
                }
                supermarket[i] = index + 1;
            }
            totalcenter -- ;
        }
        Set<Integer> finalchoice = new HashSet<>();
        for(int i = 0 ; i < c[0].length; i ++ ){
            if(!choice.contains(i)){
                finalchoice.add(i + 1);
            }
        }
        int[] ans = new int[finalchoice.size()];
        int index = 0;
        for(int j : finalchoice){
            ans[index ++ ] = j;
        }
        int total = 0;
        for(int i = 0 ; i < c.length; i ++ ){
            if(c[i][ans[0] - 1] < c[i][ans[1] - 1]){
                System.out.println("\t\t超市 " + (i + 1) + " 由" + ans[0] + " 物流中心运输 " + d[i] + " 单位的货物");
                total += c[i][ans[0]  - 1] * d[i];
            }
            else{
                System.out.println("\t\t超市 " + (i + 1) + " 由" + ans[1] + " 物流中心运输 " + d[i] + " 单位的货物");
                total += c[i][ans[1]  - 1] * d[i];
            }
        }
        System.out.println("\t\t一共 " + total  +  " 成本");
    }
}
