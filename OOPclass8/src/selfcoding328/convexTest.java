package selfcoding328;
import java.util.*;
public class convexTest {
    public static void main(String[] args) {

    }
    public static boolean judge(Point target, Point A, Point B, Point C, Point D){
        int a = (B.x - A.x)*(target.y - A.y) - (B.y - A.y)*(target.x - A.x);
        int b = (C.x - B.x)*(target.y - B.y) - (C.y - B.y)*(target.x - B.x);
        int c = (D.x - C.x)*(target.y - C.y) - (D.y - C.y)*(target.x - C.x);
        int d = (A.x - D.x)*(target.y - D.y) - (A.y - D.y)*(target.x - D.x);
        if((a > 0 && b > 0 && c > 0 && d > 0) || (a < 0 && b < 0 && c < 0 && d < 0)) {
            return true;
        }
        return false;
    }
}
class Point{
    public int x;
    public int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}