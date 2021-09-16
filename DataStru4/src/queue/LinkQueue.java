package queue;

public class LinkQueue {
    public Node head;
    public Node rear;
    public int n;
    //尾节点//
    public LinkQueue(){
        head = new Node();  //新建头节点//
        rear = head;
        n = 0;
    }
    public void clear(){
        head.next = null;
        rear.next = head;
        n = 0;
    }
    public boolean isEmpty(){
        if(n == 0)
            return true;
        else{
            return false;
        }
    }
    public int length(){
        return n;
    }
    public String get_head() throws Exception{
        if(n == 0){
            throw new Exception("获取队首首元素异常:空队列");
        }
        else{
            return head.next.data;
        }
    }
    public void enqueue(String a){
        Node node = new Node();
        node.data = a;
        rear.next = node;
        node = rear;
        n++;
    }
    public String dequeue() throws Exception{
        if(n == 0){
            throw new Exception("出对异常");
        }
        String a = head.next.data;
        head.next = head.next.next;
        n--;
        if(n ==0)
            rear = head;
        return a;
    }
}
