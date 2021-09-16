package midterm1;
import java.util.*;
public class midterm1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int number = scan.nextInt();

        scan.close();
        int[] count = new int[total];
        for(int i = 0 ; i < total ; i ++ ){
            count[i] = i + 1;
        }
        int outPeople = 0;

        int i = 0;
        int ready = 0;
        if(total == 1){
            System.out.println("0");
        }
        else {
            while (true) {

                if (count[i % total] != 0) {
                    if (ready == number) {
                        //System.out.println(count[i % total]);
                        count[i % total] = 0;

                        ready = 0;
                        outPeople++;
                        if (outPeople == total - 1) {
                            break;
                        }
                    }
                    i++;
                    ready++;
                } else {
                    i++;
                }
            }

            int res = 0;
            for (int j = 0; j < total; j++) {
                if (count[j] != 0) {
                    res = count[j] - 1;
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
