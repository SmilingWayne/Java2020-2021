

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class homework5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalWeight = scan.nextInt();
        int numbers = scan.nextInt();
        sack[] total = new sack[numbers];
        for(int i = 0 ; i < numbers; i ++){
            sack helper = new sack(scan.nextDouble(),scan.nextInt());
            total[i] = helper;
        }
        scan.close();
        Arrays.sort(total);
        getMuch(total,totalWeight);



    }
    public static void getMuch(sack[] total, int totalweight){
        double maxValue = 0;
        int weight = 0;
        for(int i = 0; i < total.length; i ++){
            double value = total[i].value;
            int heavy = total[i].weight;
            if((weight + heavy) <= totalweight){
                maxValue += value;
                weight += heavy;
            }
            else{
                double p = total[i].avg;
                maxValue += (totalweight - weight) * p;
                break;
            }
        }
        System.out.printf("%.2f",maxValue);
    }

}
class sack implements Comparable<sack>{
    public double value;
    public int weight;
    public double avg;
    public sack(double value, int weight){
        this.value = value;
        this.weight = weight;
        this.avg = value/weight;
    }
    public int compareTo(sack sack2){
        if(this.avg > sack2.avg){
            return -1;
        }
        else if(this.avg == sack2.avg){
            return 0;
        }
        else{
            return 1;
        }
    }
}
