package OOPclass11;

import java.util.ArrayList;

public class question2 {
    public static void main(String[] args) {
        String total = "1234567";
        String res = "";
        int all = 4;
        int count = 0;
        ArrayList<Integer> number = new ArrayList<>();
        for(int i = 0; i < total.length(); i++){
            String helper = total.substring(i, i+1);
            number.add(Integer.parseInt(helper));
        }
        while(count < 4){
            int p = 0;
            while( p < number.size() -1 && number.get(p) < number.get(p + 1)) {
                p ++;
            }
            number.remove(p);
            count ++;
        }
        for(int i = 0 ; i < number.size(); i++){
            res += number.get(i);
        }
        System.out.println(res);
    }
}
