package JavaClass1;
import java.util.*;
public class JavaClass1 {
    public static void main(String[] args){
        SortedSet<Integer> sorter = new TreeSet<>();
        //数集是自带排序功能的？//
        sorter.add(65);
        sorter.add(88);
        sorter.add(9);
        for(Integer i :sorter){
            System.out.println(i);
        }
        List<String> staff = new LinkedList<>();

        staff.add("Bob");
        staff.add("Amy");
        staff.add("Carl");

        List<String> staffB = new LinkedList<>();
        staffB.add("Wallace");
        staffB.add("Jackson");
        staffB.add("Pelosi");
        ListIterator<String> aIter = staff.listIterator();
        Iterator<String> bIter = staffB.iterator();
        while(bIter.hasNext()){
            if(aIter.hasNext())
                aIter.next();
            aIter.add(bIter.next());
        }
        System.out.println(staff);
        while(bIter.hasNext()){
            bIter.next();
            if(bIter.hasNext()){
                bIter.next();
                bIter.remove();
            }
        }

    }
}
