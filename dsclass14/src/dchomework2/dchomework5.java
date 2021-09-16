//package dchomework2;
import java.util.*;

public class dchomework5 {
    static class Point{
        public int x;
        public int y;
    }

    public static void main(String[] args) {
        //Random rain = new Random(50000000);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Point[] points = new Point[n];

        for(int i = 0; i < n; i++){
            points[i] = new Point();
            points[i].x = sc.nextInt();
            points[i].y = sc.nextInt();
        }
        sc.close();
        /*
        Set<int[]> set = new HashSet<>();
        for(int i = 0 ; i < n; i ++ ){
            int[] help = new int[2];
            help[0] = rain.nextInt(9000000);
            help[1] = rain.nextInt(9000000);
            if(set.contains(help)){
                i --;
                continue;
            }
            else{
                set.add(help);
                points[i] = new Point();
                points[i].x = help[0];
                points[i].y = help[1];
            }
        }

         */
        //long startTime = System.nanoTime();

        mergesort(points,0,n);
        System.out.printf("%.2f", Min(points, 0, n));
        //long endTime = System.nanoTime();
        //System.out.println("Time : " + (endTime - startTime)/(1e9) + " s");
    }
    private static Double Min(Point[] points, int start, int end) {
        if(start + 2 == end){
            return distance(points[start], points[start + 1]);
        }
        else if(start + 3 == end){
            return Math.min(distance(points[start], points[start + 1]), Math.min(distance(points[start + 1], points[start + 2]), distance(points[start], points[start + 2])));
        }
        int n = (start + end) / 2;
        double d1 = Min(points, start, n), d2 = Min(points, n ,end);
        double min = Math.min(d1, d2);
        for(int i = n - 1; i >= start; i--){
            if(points[n].x - points[i].x >= min)
                break;
            for(int j = n; j < end; j++){
                if(points[j].x - points[i].x >= min)
                    break;
                if(Math.abs(points[i].y - points[j].y) >= min)
                    continue;
                min = Math.min(min, distance(points[i], points[j]));
            }
        }
        return min;
    }
    private static void mergesort(Point[] points, int start, int end) {
        if(start + 1 >= end)
            return;
        int n = (start + end) / 2;
        mergesort(points, start, n);
        mergesort(points, n, end);
        int i = 0, j = 0, k = start, p = n - start, q= end - n;
        Point[] points1 = new Point[p];
        Point[] points2 = new Point[q];
        System.arraycopy(points, start, points1, 0, p);
        System.arraycopy(points, n, points2, 0, q);
        while (i < p && j < q){
            if(points1[i].x < points2[j].x)
                points[k++] = points1[i++];
            else
                points[k++] = points2[j++];
        }
        while (i < p)
            points[k++] = points1[i++];
        while (j < q)
            points[k++] = points2[j++];
    }

    private static Double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y, 2));
    }
}