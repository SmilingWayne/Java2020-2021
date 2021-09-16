package class1;
import java.util.*;
public class question15 {
    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for(int i = 0; i < 10; i++ ){
            ans.add(i);
        }
        second.add(2);
        second.add(7);
        second.add(3);
        Iterator<Integer> it = ans.iterator();
        while (it.hasNext()){
             int temp = it.next();
             if(second.contains(temp)){
                 it.remove();
             }
        }
        for(int i = 0 ; i < ans.size(); i ++ ){
            System.out.println(ans.get(i));
        }
    }
}
