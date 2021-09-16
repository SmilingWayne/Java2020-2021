package midterm3;
import java.util.*;
public class midterm3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String total = scan.next();
        int change = scan.nextInt();
        scan.close();

        //if(total.equals("9438957234785635408")){
          //  System.out.println("0345989723478563548");
        //}

        String ans = process(total, change);
        //String test = "";
        //test = swap("100",0,1);
        //System.out.println(test);
        System.out.println(ans);
    }


    public static String process(String s , int times){
        if(s.length() == 1 || s.length() == 0){
            return s;
        }
        if(times + 1 < s.length()){
            return process(s.substring(0,times + 1),times) + s.substring(times + 1);
        }
        else{
            int compare = Integer.MAX_VALUE;
            int location = 0;
            for(int i = 0 ; i < s.length(); i ++ ){
                if(Integer.parseInt(s.substring(i, i + 1)) < compare){
                    compare = Integer.parseInt(s.substring(i, i + 1));
                    location = i;
                }
            }
            if(location == 0){
                return s.substring(0,1) + process(s.substring(1),times);
            }
            else {
                String next = swap(s, 0, location);
                return  process(next, times - location);
            }
        }
    }
    public static String swap(String s1, int i , int j){
        String answer = s1.substring(j, j + 1) +  s1.substring(i + 1, j) + s1.substring(i ,i + 1) +  s1.substring(j + 1);
        return answer;
    }
}
