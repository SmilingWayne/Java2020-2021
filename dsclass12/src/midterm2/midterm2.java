package midterm2;
import java.util.*;
public class midterm2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        String s2 = scan.next();
        scan.close();
        if(s1.length() > s2.length()){
            int k = s1.length() - s2.length();
            for(int i = 0; i < k; i ++ ){
                s2 = "0" + s2 + "";
            }
        }
        if(s1.length() < s2.length()){

            int k = s2.length() - s1.length();
            for(int i = 0 ; i < k; i ++ ){
                s1 = "0" + s1 + "";
            }
        }
        //System.out.println(s1);
        String ans = calculate(s1,s2,s1.length() - 1,0);
        System.out.println(ans);
    }
    public static String calculate(String s1, String s2,int i ,int add){
        if(i < 0){
            return "";
        }
        int helper = 0;
        helper = (Integer.parseInt(s1.substring(i,i + 1)) + Integer.parseInt(s2.substring(i,i + 1)) + add) % 10;
        int another = (Integer.parseInt(s1.substring(i,i + 1)) + Integer.parseInt(s2.substring(i,i + 1)) + add) / 10;
        if(i == 0 && another > 0){
            return another + calculate(s1,s2,i - 1, another) + helper + "";
        }
        return calculate(s1,s2,i - 1,another) + helper + "";
    }
}
