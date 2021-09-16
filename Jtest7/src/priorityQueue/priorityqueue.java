package priorityQueue;

import java.time.*;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

public class priorityqueue {
    public static void main(String[] args){
        PriorityQueue<LocalDate> pq= new PriorityQueue<>();
        pq.add(LocalDate.of(1908,12,9));
        pq.add(LocalDate.of(1816,2,12));
        pq.add(LocalDate.of(1905,1,4));
        pq.add(LocalDate.of(1910,7,11));
        for(LocalDate date:pq){
            System.out.println(date);
        }
        System.out.println("");
        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }
        //注意了，是按照排序的优先级进行删减，最优先的会最先被删除，也就是最顶上的那个会最先被删除//

    }
}
