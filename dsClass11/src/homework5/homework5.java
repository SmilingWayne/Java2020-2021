package homework5;
import java.util.*;
public class homework5 {
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


        double count = 0;
        //print(total);
        count = getRoute(total,start.demand,start,contents);

        System.out.printf("%.2f",count);

    }
    public static class city{
        public int xx;
        public int yy;
        public int demand;
        public boolean visited;

    }

    public static void print(ArrayList<city> total){
        for(int i = 0; i < total.size(); i ++ ){
            System.out.println(total.get(i).xx + " "+ total.get(i).yy  + " " + total.get(i).demand);
        }
    }
    public static double getRoute(ArrayList<city> total,  int content , city current, int maxSize){
        double compare = Integer.MAX_VALUE;
        int nextCity = -1;
        int preCity = -1;
        for(int i = 1 ; i < total.size(); i ++ ){
            if(total.get(i).visited == false && content + total.get(i).demand >=0 && content + total.get(i).demand <= maxSize ){
                double distance = Math.sqrt((current.xx - total.get(i).xx)*(current.xx - total.get(i).xx) + (current.yy - total.get(i).yy)*
                        (current.yy - total.get(i).yy));
                double original = compare;
                compare = Math.min(distance , compare);
                if(original > compare){
                    if(preCity > 0){
                        total.get(preCity).visited = false;
                    }
                    preCity = i;
                    nextCity = i;
                    total.get(i).visited = true;

                }
            }
        }
        if(nextCity == -1){

            return Math.sqrt((current.xx - total.get(0).xx)* (current.xx - total.get(0).xx)+ (current.yy - total.get(0).yy )*( current.yy - total.get(0).yy));
        }
        else{
            content = content + total.get(nextCity).demand;
            return getRoute(total,content,total.get(nextCity),maxSize) + compare;
        }

    }
}
