
import java.util.*;
public class homeworkFinal {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String helper = scan.nextLine();
        helper = helper.toLowerCase();
        scan.close();
        String[] res = helper.split(" ");
        int count = res.length;
        for(int i = 0 ; i < res.length; i++){
            if(res[i].equals("")||res[i].equals("")){
                count--;
            }
        }
        System.out.println(count);

    }
}
