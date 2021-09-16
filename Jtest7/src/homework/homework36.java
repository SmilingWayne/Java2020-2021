package homework;
import java.util.*;
public class homework36 {
    public static void main(String[] args) {
        /*
        判断是否为小顶堆：
        测试案例:
        判断方式：s[i * 2 + 1] > s[i] && s[i * 2 + 2] > s[i] 成立就是小顶堆
        11
        12 36 27 65 40 34 98 81 73 55 49
         */
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int[] s = new int[total];
        for(int i = 0 ; i < total; i ++ ){
            s[i] = scan.nextInt();
        }
        scan.close();
        boolean flag = true;
        for(int i = 0 ; i < total/2; i ++ ){
            if(i * 2 + 1 < total){
                if(s[i * 2 + 1] <= s[i]){
                    flag = false;
                    break;
                }
            }
            if(i * 2 + 2 < total){
                if(s[i * 2 + 2] <= s[i]){
                    flag = false;
                    break;
                }
            }
        }
        if(flag){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }
    }
}
