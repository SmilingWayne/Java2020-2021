package OOdhomework5;
import java.util.*;
public class oodhomework5 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String x = scan.nextLine();
        scan.close();
        x = x.trim();
        x = x.toLowerCase();
        boolean flag = true;
        int count = 0;
        for(int i = 0; i < x.length(); i++){
            if(x.charAt(i)>='a'&&x.charAt(i)<='z'){
                while( i < x.length() && x.charAt(i)!=' '){
                    if(!(x.charAt(i)>='a'&&x.charAt(i)<='z')){
                        i++;
                        flag = false;
                    }
                    else{
                        i++;
                    }
                }
                if(flag == true){
                    count++;

                }
                else{
                    flag = true;
                }
            }
        }
        System.out.println(count);
    }
}
