package polynomial;

public class Poly {
    public static class Node{
        public double coef;
        public int exp;
        public Node next;
    }
    public Node head;
    public Poly(double[] coefs,int[] exps){
        //建立链表//
        head=new Node();
        head.next=null;
        Node p=head;
        for(int i=0;i<coefs.length;i++){
            Node q=new Node();
            q.coef=coefs[i];
            q.exp=exps[i];
            q.next=null;
            p.next=q;
            p=q;
        }
    }
    public void add(Poly poly){
        Node p = head.next;
        Node q = poly.head.next;
        head.next=null;
        Node r = head;
        while(p !=null&&q!=null){
            if(p.exp<q.exp){
                r.next=p;
                r=p;
                p=p.next;
            }
            else if(q.exp<p.exp){
                r.next=q;
                r=q;
                q=q.next;
            }
            else{
                double new_coef = p.coef+q.coef;
                if(Math.abs(new_coef)>1e-6){
                    p.coef= new_coef;
                    r.next=p;
                    r=p;
                }
                p=p.next;
                q=q.next;
            }
            if(q!=null){
                r.next=q;

            }
            else if(p!=null)
                r.next=p;
        }
    }
    @Override
    public String toString(){
        String str="";
        Node p = head.next;
        while(p!=null){
            str+="(" + p.coef + "," + p.exp + ") ";
            p=p.next;
        }
        return str;
    }
}
