
package dchomework4;



import java.util.*;

public class dchomework4 {
    static class Point{
        public int x;
        public int y;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Point[] points = new Point[n];
        /*
        for(int i = 0; i < n; i++){
            points[i] = new Point();
            points[i].x = scan.nextInt();
            points[i].y = scan.nextInt();
        }
        scan.close();

         */

        mergesort(points, 0, n);
        System.out.printf("%.2f", Min(points, 0, n));

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

        return Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y));
    }
}