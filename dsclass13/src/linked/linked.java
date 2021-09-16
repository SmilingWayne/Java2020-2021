package linked;

public class linked {
    public static void main(String[] args) {
        int[] a = {1,3,5,7,9};
        int[] b = {2,4,6,8,10,11,12};
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(0);
        ListNode c1 = c;
        ListNode d1 = d;
        for(int i = 0 ; i < a.length; i ++ ){
            ListNode help = new ListNode(a[i]);
            c.next = help;
            c = c.next;
        }
        for(int i = 0 ; i < b.length; i ++ ){
            ListNode help = new ListNode(b[i]);
            d.next = help;
            d = d.next;
        }
        ListNode res = combine(c1.next , d1.next);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode combine(ListNode a, ListNode b){
        ListNode c = new ListNode(1);
        ListNode res = c;

        while(a != null && b != null){
            if(a.val <= b.val){
                ListNode x = new ListNode(a.val);
                c.next = x;
                a = a.next;
                c = c.next;
            }
            else if(a.val > b.val){
                ListNode x = new ListNode(b.val);
                c.next = x;
                b = b.next;
                c = c.next;
            }
        }
        if(a != null){
            c.next = a;
        }
        else if(b != null){
            c.next = b;
        }
        return res.next;

    }
}

class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int x){
        this.val = x;
    }
}