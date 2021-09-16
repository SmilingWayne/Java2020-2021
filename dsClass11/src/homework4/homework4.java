package homework4;
import java.util.*;
public class homework4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double res = 0;
        int max = -1;
        int maxNumber = -1;
        double maxValue = -1;
        int totalWeight = scan.nextInt();
        int numbers = scan.nextInt();
        ArrayList<Double> values = new ArrayList<>();
        ArrayList<Integer> weight = new ArrayList<>();
        for(int i = 0 ; i < numbers; i ++){
            values.add(scan.nextDouble());
            weight.add(scan.nextInt());

        }
        scan.close();
        while(true) {
            max = -1;
            maxValue = -1;
            for (int i = 0; i < values.size(); i++) {
                if(weight.get(i) <= totalWeight && values.get(i) > maxValue){
                    max = i;
                    maxValue = values.get(i);
                }
            }
            if(max == -1){
                break;
            }
            totalWeight = totalWeight - weight.get(max);
            res += values.get(max);
            values.remove(max);
            weight.remove(max);
        }
        System.out.printf("%.2f",res);

    }
}
