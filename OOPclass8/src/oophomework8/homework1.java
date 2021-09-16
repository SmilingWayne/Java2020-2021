
import java.util.*;
public class homework1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int[] row = new int[total];
        for(int i = 0; i < total; i++){
            row[i] = scan.nextInt();
        }
        scan.close();
        String res = "";
        int example = 0;
        for(int i = 0; i < row.length; i++){
            example = getMax(row);
            res = res + example + "";
        }

        System.out.println(res);

    }
    public static int getMax(int[] row){
        int a = 0;
        for(int i = 0; i < row.length; i++){
            if(row[i] < 0){
                continue;
            }
            else {
                a = selectMax(a, row[i]);
            }
        }
        for(int i = 0; i < row.length; i++){
            if(row[i] == a){
                row[i] = -1;
                break;
            }
        }
        return a;
    }
    public static int selectMax(int a,int b){
        int i1 = 1;
        int helperA = a;
        int helperB = b;

        int i2 = 1;

        if(a == 0){
            return b;
        }
        while(helperA > 0){
            i1 = i1 * 10;
            helperA = helperA / 10;
        }
        i1 = i1/10;
        while(helperB > 0){
            i2 = i2 * 10;
            helperB = helperB / 10;
        }
        i2 = i2/10;
        int helper1 = a;
        int helper2 = b;
        while(i1 > 0 && i2 > 0){
            if(helper1 /i1 > helper2 /i2){
                return a;
            }
            else if(helper1 / i1 < helper2 / i2){
                return b;
            }
            else{

                helper1 =helper1 - (helper1/i1)*i1;
                helper2 = helper2 - (helper2/i2)*i2;
                i1 = i1/10;
                i2 = i2/10;
            }
        }
        if(i1 == 0 && i2 > 0){
            return a;
        }
        else if(i1 > 0 && i1 == 0){
            return b;
        }
        else{
            return a;
        }

    }
}
