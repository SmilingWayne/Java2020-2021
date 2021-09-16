package linked2;

public class linked2 {
    public static void main(String[] args) {
        int[] h = {1,2,3};

        circulateNode n = new circulateNode(1);
        for(int i = 1; i < 3; i ++ ){
            n.addNode(h[i]);
        }
        ListNode q = n.head;
        for(int i = 0; i < 7; i ++ ){

            System.out.println(q.val);
            q = q.next;

        }
    }
}
class circulateNode{
    public ListNode head;
    public circulateNode(int x){

        head = new ListNode(x);
        head.next = head;
    }
    public ListNode getLast(){
        if(head == null || head.next == head){
            return head;
        }
        ListNode help = head;
        while(help.next != head){
            help = help.next;
        }
        return help;
    }
    public void addNode(int x){
        ListNode last = getLast();
        ListNode a = new ListNode(x);
        last.next = a;
        a.next = head;
    }
}
class ListNode{
    public int val ;
    public ListNode next;
    public ListNode(int x){
        this.val = x;
    }




}