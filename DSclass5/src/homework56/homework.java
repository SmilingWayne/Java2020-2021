package homework56;
import java.util.*;
public class homework {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String x = scan.nextLine();
        x = x.toLowerCase();
        int countVal = 0;
        int countNum = 0;
        int countSpace = 0;
        int countOther = 0;
        for(int i = 0; i < x.length();i++){
            if(x.charAt(i) == '0'||x.charAt(i)=='1'||x.charAt(i) == '2'||x.charAt(i)=='3'||x.charAt(i) == '4'||
            x.charAt(i)=='5'||x.charAt(i) == '6'||x.charAt(i) == '7'||x.charAt(i)=='8'||x.charAt(i)=='9'){
                countNum++;
            }
            else if(x.charAt(i)>='a'&&x.charAt(i)<='z'){
                countVal++;
            }
            else if(x.charAt(i) == ' '){
                countSpace++;
            }
            else{
                countOther++;
            }
        }
        System.out.printf("%d %d %d %d",countVal,countNum,countSpace,countOther);

    }
}
