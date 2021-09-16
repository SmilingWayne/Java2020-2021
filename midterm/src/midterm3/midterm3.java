package midterm3;
import java.util.*;

/**
 * 数据结构期中考试第三问
 */
public class midterm3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String target = scan.next();
        scan.close();
        String a = target.substring(0,1);
        char infi = a.charAt(0);
        String total = target.substring(3,target.length() - 1);
        int res = countNumber(total);
        if(total.equals("")){
            System.out.println(1);
        }
        else{
            System.out.println(res);
        }
    }
    public static int countNumber(String s){
        int selfLength = 0;
        int start = 0;
        int countOthers = 0;
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == ','){
                selfLength ++;
            }
            else if(s.charAt(i)!='(' && s.charAt(i) != ')'){
                continue;
            }
            if(s.charAt(i) == '('){
                int balance = 0;
                start = i + 1;
                while(!(s.charAt(i)==')' && balance ==0 ) && i < s.length()){
                    if(s.charAt(i) == '('){
                        balance++;
                    }
                    if(s.charAt(i) == ')'){
                        balance --;
                    }
                    if(s.charAt(i) ==')' && balance == 0){
                        break;
                    }
                    i++;
                }
                int helper = countNumber(s.substring(start + 1,i));
                if(start - 1 == 0 && s.charAt(s.length() -1) == ')'){
                    helper--;
                }
                countOthers = Math.max(countOthers,helper);

            }
        }
        return Math.max(selfLength,countOthers) + 1;
    }


}
