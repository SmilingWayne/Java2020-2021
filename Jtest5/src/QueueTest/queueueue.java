package QueueTest;

import java.util.LinkedList;
import java.util.Queue;

public class queueueue {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < 6; i ++){
            queue.add(i);
        }
        System.out.println(queue.element());
        for(int i = 0 ; i < 6; i++){
            System.out.println(queue.poll());
        }
    }
}
