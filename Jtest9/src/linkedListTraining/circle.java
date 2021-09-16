package linkedListTraining;

import java.util.Scanner;

public class circle {
    public static void main(String[] args){
        circleArray arrayQueue = new circleArray(4);
        char key = ' ';
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("s:输出队列");
            System.out.println("e:退出程序");
            System.out.println("g:添加数据到队列");
            System.out.println("h:查看队列头的数据");
            key = scan.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scan.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("%d", res);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 'e':
                    scan.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }
        System.out.println("程序");
    }
}
class circleArray {
    private int MAX_SIZE;
    private int front;
    private int rear;
    private int[] arr;//用于存放数据/

    public circleArray(int array_maxsize) {
        MAX_SIZE = array_maxsize;
        arr = new int[array_maxsize];
        rear = 0;
        front = 0;

    }

    public boolean isFull() {
        return front == (rear+1)%MAX_SIZE;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("man");
            return;
        }
        arr[rear] = n;
        rear=(rear+1)%MAX_SIZE;
    }
    public int getQueue(){
        if(isEmpty())
            throw new RuntimeException(" kong");
        else {
            int value = arr[front];
            front = (front+1) % MAX_SIZE;
            return value;
        }
    }
    public void showQueue(){
        if(isEmpty()) {
            System.out.println("Kong");
            return;
        }
        for(int i = front ;i<size()+front;i++){
            System.out.printf("arr[%d]=%d\n",i%MAX_SIZE,arr[i%MAX_SIZE]);
        }
    }
    public int size(){
        return (rear+MAX_SIZE-front)%MAX_SIZE;
    }
    public int headQueue()
    {
        if(isEmpty()){
            System.out.println("kong");
            throw new RuntimeException("no");
        }
        else{
            return arr[front];
        }
    }

}
