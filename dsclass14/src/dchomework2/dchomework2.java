package dchomework2;
import java.util.*;
public class dchomework2 {
    public static void main(String[] args) {
        //Random rain = new Random(50000000);
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        point[] map = new point[total];
        point[] map2 = new point[total];
        //Set<int[]> set = new HashSet<>();
        /*
        for(int i = 0 ; i < total; i ++ ){
            int[] help = new int[2];
            help[0] = rain.nextInt(9000000);
            help[1] = rain.nextInt(9000000);
            if(set.contains(help)){
                i --;
            }
            else{
                set.add(help);
                map[i] = new point(help[0],help[1]);
            }
        }

         */
        /*
        for(int i = 0; i < total ; i ++ ){
            System.out.println(map[i].x + "  " + map[i].y);
        }

         */

        for(int i = 0; i < total; i ++ ){
            int r = scan.nextInt();
            int t = scan.nextInt();
            point helper = new point(r,t);
            map[i] = helper;
            //System.out.println(map[i].x + " " + map[i].y);
        }
        //long startTime = System.nanoTime();
        Arrays.sort(map, (a,b) ->(a.x - b.x));
        double ans = divide(0, total - 1, map, map2);
        System.out.printf("%.2f", Math.sqrt(ans));
        /*for(int i = 0; i < total; i ++){
            System.out.println(board[i][0] + " " + board[i][1]);
        }
         */
        //long endTime = System.nanoTime();
        //System.out.println("Time : " + (endTime - startTime)/(1e9) + " s");
    }
    public static void merge(point[] map, point[] map2, int left , int right){
        int mid = (left + right)/2;
        int i = left;
        int j = mid + 1;
        int id2 = i;
        while(i <= mid && j <= right){
            if(map[i].y < map[j].y){
                map2[id2 ++ ] = map[i ++];
            }
            else{
                map2[id2 ++ ] = map[j ++ ];
            }
        }
        while(i <= mid){
            map2[id2 ++] = map[i ++ ];
        }
        while(j <= right){
            map2[id2 ++ ] = map[j ++ ];
        }
        for(int k = left ; k <= right; k ++ ){
            map[k] = map2[k];
        }
    }
    public static double divide(int left , int right, point[] map, point[] map2){
        double maxLength = Double.MAX_VALUE;
        if(left == right){
            return maxLength;
        }
        if(left + 1 == right){
            merge(map, map2, left, right);
            return distance(map[left], map[right]);
        }
        int middle = (left + right) /2;
        double leftMax = divide(left, middle,map, map2);
        double rightMax = divide(middle + 1, right, map, map2);
        maxLength = (leftMax <= rightMax) ? leftMax : rightMax;
        double midLength = map[middle].x;
        merge(map,map2, left, right);
        //System.out.println("midLength = " + midLength);
        List<point> remaining = new ArrayList<>();
        for(int i = left; i <= right; i ++ ){
            if(Math.abs(map[i].x - midLength) < maxLength){
                remaining.add(map[i]);
            }
        }
        int l = remaining.size();
        if(remaining.size() < 2){
            return maxLength;
        }
        if(remaining.size() == 2){
            maxLength = Math.min(maxLength, distance(remaining.get(0), remaining.get(1)));
            return maxLength;
        }
        else{
            for(int i = 0; i < l ; i ++ ){
                for(int j = i + 1; j < i + 1 + 4 && j < l; j ++ ){
                    if(Math.abs(remaining.get(i).y - remaining.get(j).y) >= maxLength ){
                        break;
                    }
                    if(Math.abs(i - j) >= maxLength){
                        break;
                    }
                    double help = distance(remaining.get(i), remaining.get(j));
                    maxLength = Math.min(help, maxLength);
                }
            }
        }
        for(int i = 0; i <= l ; i ++ ){
            for(int j = i + 1; j < i + 1 + 4 && j < l; j ++ ){
                double help = distance(remaining.get(i), remaining.get(j));
                maxLength = Math.min(help, maxLength);
            }
        }
        return maxLength;
        /*
        If sorting during the recurrence, O(nlognlongn)
         */

    }
    public static double distance(point a , point b){
        double s = 0;
        s = Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y,2);
        return s;
    }
}
class point{
    public int x;
    public int y;
    public point(int x ,int y){
        this.x = x;
        this.y = y;
    }
}