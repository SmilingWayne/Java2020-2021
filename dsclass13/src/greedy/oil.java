package greedy;

import java.util.*;
public class oil {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int[] gas = new int[total];
        int[] cost = new int[total];
        for(int i = 0; i < total ;i ++ ){
            gas[i] = scan.nextInt();
        }
        for(int i = 0 ; i < total ; i ++ ){
            cost[i] = scan.nextInt();
        }
        SolutionOil soi = new SolutionOil();
        System.out.println(soi.canCompleteCircuit(gas, cost));
    }
}
class SolutionOil {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] rest = new int[gas.length];
        int total = 0;
        for(int i = 0; i < gas.length ; i ++ ){
            rest[i] = gas[i] - cost[i];

            total += rest[i];
        }
        if(total < 0){
            return -1;
        }
        int start = 0;
        int all_money = 0;
        for(int i = 0; i < gas.length; i ++ ){
            all_money += rest[i];
            if(all_money < 0){
                all_money = 0;
                start = i + 1;
            }
        }
        return start;

    }
}
