package homework;
import java.util.*;
public class homework9 {
    /*
    约瑟夫环问题的链表解法，输入数据：
    20 7
    3 1 7 2 4 8 4
    每个人持有一个数据，如果这个人出列，则下一个终止条件就是这个人持有的数据
    结果：
    6 1 4 7 2 3 5
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        int total = scan.nextInt();
        node head = new node(1, 0);
        node a = head;
        for(int i = 0 ; i < total; i ++ ){
            if(i == 0){
                head.val = scan.nextInt();
            }
            else{
                node help = new node(i + 1, scan.nextInt());
                a.next = help;
                a = a.next;
            }
        }
        a.next = head;
        node b = head;
        node assist = head;
        int flag = 0;
        List<Integer> res = new ArrayList<>();
        while(true){
            int count = 1;
            while(count < start){
                count ++;
                assist = b;
                b = b.next;
            }
            start = b.val;
            res.add(b.num);
            flag ++;
            if(flag == total){
                break;
            }
            assist.next = b.next;
            b = b.next;
        }
        for(int i = 0 ; i < total;  i++ ){
            System.out.println(res.get(i));
        }
    }
}
class node{
    public int num;
    public int val;
    public node next;
    public node(int nums, int val){
        this.num = nums;
        this.val = val;
    }
}
