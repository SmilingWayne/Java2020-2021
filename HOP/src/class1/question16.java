package class1;
import java.util.*;
import java.util.*;
public class question16 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        for(int i = 0 ; i < 10; i ++){
            a.add(i);
        }
        Iterator<Integer> itor = a.iterator();
        while(itor.hasNext()){
            if(itor.next() == 1 || itor.next() == 2 || itor.next() == 10){
                itor.remove();
                a.add(11);
            }
            itor = a.iterator();
        }
        System.out.println(a);


    }
}
