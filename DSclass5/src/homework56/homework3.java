package homework56;
import java.util.*;
public class homework3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String x = scan.nextLine();

        scan.close();
        String res = "";
        for(int i = 0; i< x.length();i++){
            if(x.charAt(i)>='a'&&x.charAt(i)<='z'||(x.charAt(i)>='A'&&x.charAt(i)<='Z')){
                res =res + x.charAt(i)+"";
            }
        }
        System.out.println(res);
    }
}
