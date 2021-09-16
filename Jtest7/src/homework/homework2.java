package homework;

import java.util.*;
public class homework2 {
    /*
    Question:
    Give a Integer arrays nums and a value target, plz find
    the two Integers whose sum equals to the target , and return there
    arrays index, Attention: the first index must be the smallest.
    You cant use the same element twice. If not exist, return double -1;
    e.g.
    9 4
    2 7 11 15
    Answer : 0 1
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();
        int length = scan.nextInt();
        if(length <= 1){
            System.out.println("-1" + " " + "-1");
        }
        else {
            int[] all = new int[length];
            for (int i = 0; i < length; i++) {
                all[i] = scan.nextInt();
            }
            scan.close();
            Map<Integer, Integer> map = new HashMap<>();
            boolean a = false;
            for(int i = 0 ; i < length; i ++ ){
                if(map.size() == 0){
                    map.put(all[i], i);
                }
                else{
                    if(map.containsKey(target - all[i])){
                        a = true;
                        System.out.println(map.get(target - all[i]) + " " + i );
                        break;
                    }
                    else{
                        if(map.containsKey(target - all[i])){
                            continue;
                        }
                        else{
                            map.put(all[i], i);
                        }
                    }
                }
            }
            if(a == false){
                System.out.println( "-1 -1");
            }

        }

    }
}
