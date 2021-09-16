package homework;

import java.util.*;
public class homework3 {
    /*
     Exchange the pre-mth element and post-nth
     element in a sequential linear table.
     e.g.
     10
     1 2 3 4 5 6 7 8 9 10
     3 4
     outcome:
     7 8 9 10 4 5 6 1 2 3
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        Node head = new Node(0);
        Node a = new Node(0);
        for(int i = 0 ; i < total; i ++ ){
            if(i == 0){
                head = new Node(scan.nextInt());
                a = head;
            }
            else{
                Node help = new Node(scan.nextInt());
                a.next = help;
                help.next = null;
                a = a.next;
            }
        }
        int pre = scan.nextInt();
        int post = scan.nextInt();
        Node b = head;
        Node c = new Node(0);
        Node e = c;
        for(int i = 0 ; i < pre ; i ++ ){
            Node d = new Node(b.value);
            e.next = d;
            b = b.next;
            e = e.next;
        }
        for(int i = 0; i < total - pre - post ; i ++ ){
            a.next = new Node(b.value);
            a = a.next;
            b = b.next;
        }
        a.next = c.next;
        while(b != null){
            System.out.print(b.value + " ");
            b = b.next;
        }
    }
}
class Node{
    public int value;
    public Node next;
    public Node(int value){
        this.value = value;
    }
}