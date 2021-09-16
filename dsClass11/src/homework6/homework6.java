package homework6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class homework6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cities = scan.nextInt();
        int contents = scan.nextInt();
        ArrayList<city> total = new ArrayList<>();
        city start = new city();
        for(int i = 0 ; i < cities; i ++){
            city helper = new city();

            helper.xx = scan.nextInt();
            helper.yy = scan.nextInt();
            helper.demand = scan.nextInt();
            helper.visited = false;
            if(i == 0){
                helper.visited = true;
                start = helper;
            }
            total.add(helper);
        }
        scan.close();
        boolean[] judge = new boolean[cities];
        judge[0] = true;
        double res = getLength(total,judge,total.get(0),contents,total.get(0).demand);
        System.out.printf("%.2f",res);
    }
    public static class city{
        public int xx;
        public int yy;
        public int demand;
        public boolean visited;

    }
    public static double getLength(ArrayList<city> total, boolean[] judge, city start, int maxSize, int currentWeight){
        double[] count = new double[total.size()];
        Arrays.fill(count,Double.MAX_VALUE);
        int preCity = -1;
        int number = -1;
        int i = 0;
        for(i = 0 ; i < total.size(); i ++ ){
            if(judge[i] == false && total.get(i).demand + currentWeight >=0 && total.get(i).demand + currentWeight <= maxSize){
                if(number == -1){
                    number = 0;
                }
                count[number] = Math.sqrt((total.get(i).xx - start.xx) * (total.get(i).xx - start.xx) + (total.get(i).yy - start.yy)*
                        (total.get(i).yy - start.yy));

                judge[i] = true;
                preCity = i;
                count[number] += getLength(total, judge,total.get(i),maxSize, total.get(i).demand + currentWeight);
                number ++ ;
                judge[i] = false;
            }
        }
        int stay = 0;
        for(int k = 0 ; k < judge.length; k ++ ){
            if(judge[k] == false){
                stay ++ ;
            }
        }

        if(number == -1 && stay == 0){
            return Math.sqrt((start.xx - total.get(0).xx) * (start.xx - total.get(0).xx) + (start.yy - total.get(0).yy)*(start.yy - total.get(0).yy));
        }
        if(number == -1 && stay >= 1){
            return 10000;
        }
        double res = 2000;
        for(int k = 0 ; k < count.length; k ++ ){
            if(count[k] != Double.MAX_VALUE){
                res = Math.min(res,count[k]);
            }
        }
        return res;
    }
}