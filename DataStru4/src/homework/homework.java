package homework;
import java.util.*;

public class homework {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int start_point = scan.nextInt();
        int end_point = scan.nextInt();
        int res = 0;
        int[] route = {0,1,-1};
        int[] visited = new int[23];
        SeqQueue queue = new SeqQueue(23);
        scan.close();

        visited[start_point]=1;
        queue.enqueue(start_point);
        while(queue.get_length()!=0)
        {
            int head=queue.getFront();
            if(head==end_point) {
                res = visited[head] -1;
                break;
            }
            int path = 0;
            queue.dequeue();
            for(int i=0;i<3;i++)
            {
                if(i==0)path=head*2;
                else path=head+route[i];
                if(path<0||path>20||visited[path]!=0)
                    continue;
                queue.enqueue(path);
                visited[path]=visited[head]+1;
            }
        }
        System.out.println(res);
    }
}
class SeqQueue{

    public int[] base;
    public int front = 0;
    public int rear = 0;
    public SeqQueue(int size){
        base = new int[size];
        front = 0;
        rear = 0;
    }
    public boolean is_empty(){
        if(front == rear)
            return true;
        else{
            return false;
        }
    }
    public int get_length(){
        return (rear - front + base.length)%base.length;
    }
    public void enqueue(int n ){
        base[rear] = n;
        rear = (rear+1)%base.length;
    }
    public int dequeue(){
        int temp = base[front];
        front = (front + 1) % base.length;
        return temp;

    }
    public int getFront(){
        return base[front];
    }
    public void clearQueue(){
        rear = 0;
        front = 0;
        base[0] = 0;
    }
    public int getHead(){
        return base[front];

    }
}