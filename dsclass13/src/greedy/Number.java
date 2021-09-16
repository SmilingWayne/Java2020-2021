//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package greedy;

import java.util.ArrayList;

public class Number {
    public Number() {
    }

    public static void main(String[] args) {
        String num = "5353431313258671678";
        int k = 10;
        ArrayList<Integer> numbers = new ArrayList();
        /*
        int i;
        for(i = 0; i < num.length(); ++i) {
            String str = num.substring(i, i + 1);
            numbers.add(Integer.parseInt(str));
        }

        int i;
        for(i = 0; i < k; ++i) {
            for(i = 0; i < numbers.size() - 1 && (Integer)numbers.get(i) < (Integer)numbers.get(i + 1); ++i) {
            }

            numbers.remove(i);
        }

        String result = "";

        for(i = 0; i < numbers.size(); ++i) {
            result = result + numbers.get(i);
        }

        System.out.println(result);

         */

        for(int i = 0; i < num.length(); i ++ ){
            String str = num.substring(i, i + 1);
            numbers.add(Integer.parseInt(str));
        }
        for(int i = 0 ; i < k; i ++ ){
            int j = 0;
            for(j = 0 ; j < numbers.size() - 1 && numbers.get(j) < numbers.get(j + 1); j ++){

            }
            numbers.remove(j);
        }
        String res = "";
        for(int i = 0 ; i < numbers.size(); i ++ ){
            res = res + numbers.get(i);
        }
        System.out.println(res);
    }
}
