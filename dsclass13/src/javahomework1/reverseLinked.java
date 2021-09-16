package javahomework1;
import java.util.*;
public class reverseLinked {
    public static void main(String[] args) {
        int[] add = {1,2,3,4,5};
        ListNode head = null;
        ListNode start = null;
        for(int i = 0; i < 5; i ++ ){
            if(i == 0){
                head = new ListNode(add[i]);
                start = head;
            }
            else{
                ListNode help = new ListNode(add[i]);
                start.next = help;
                start = start.next;
            }
        }
        ListNode h = reverse(head);
        for(int i = 0; i < 5; i ++ ){
            System.out.println(h.val);
            h = h.next;
        }
        /*
        for(int i = 0; i < 5; i ++ ){
            System.out.println(head.val);
            head = head.next;
        }
         */

    }
    public static ListNode reverse(ListNode node){
        if(node == null){
            return node;
        }
        ListNode cur = node;
        ListNode pre = null;
        ListNode nnext  = null;
        while(cur != null){
            nnext = cur.next;
            cur.next =  pre;
            pre = pre.next;
            pre.next = nnext;
        }
        return pre;
    }
}

class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int x){
        this.val = x;
    }


}