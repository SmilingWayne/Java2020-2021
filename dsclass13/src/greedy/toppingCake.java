package greedy;
import java.util.*;
public class toppingCake {
    public static void main(String[] args) {
        int[] toppingCosts = {74,28,20,22,2};
        List<Integer> list = new ArrayList<Integer>();
        backtrack(toppingCosts, 0,list, 0);
        //1 2 5 2 4 6
        for(int i = 0 ; i < list.size(); i ++ ){
            System.out.print(list.get(i) + " ");
        }



    }
    public static void backtrack(int[] toppingCosts, int index, List<Integer> list, int initial){
        if(index == toppingCosts.length){
            return ;
        }
        else{
            for(int i = index; i < toppingCosts.length; i ++ ){
                backtrack(toppingCosts, index + 1, list, initial);
                if(!list.contains(toppingCosts[index] + initial)){
                    list.add(toppingCosts[index] + initial);
                }
                backtrack(toppingCosts, index + 1, list, initial + toppingCosts[index]);
                if(!list.contains(toppingCosts[index] * 2 + initial)){
                    list.add(toppingCosts[index] * 2 + initial);
                }
                backtrack(toppingCosts, index + 1, list, initial + 2 * toppingCosts[index]);
            }
        }
    }
}
