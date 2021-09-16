package homework;
import java.util.*;
public class homework4 {
    /*
    输入多组数据
    每一行a b 分别表示课程开始和结束的时间 0<= a < b <= 24
    求最少需要多少个讲师
    6
    1 5
    2 3
    3 4
    6 7
    8 9
    10 12
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int all = scan.nextInt();
        int[][] total = new int[all][2];
        for(int i = 0 ; i < all ; i++ ){
            total[i][0] = scan.nextInt();
            total[i][1] = scan.nextInt();
        }
        Arrays.sort(total, (a,b)-> a[0] < b[0] ? -1:1);
        /*
        for(int i = 0 ; i < all; i ++ ){
            System.out.println(total[i][0] + " " + total[i][1]);
        }
         */
        List<ListNode> res = new ArrayList<>();
        for(int i = 0 ; i < all ; i ++ ){
            if(i == 0){
                res.add(new ListNode(total[i][1]));
            }
            else{
                boolean judge = false;
                for(int j = 0 ; j < res.size() ; j ++ ){
                    if(res.get(j).value <= total[i][0]){
                        res.get(j).value = total[i][1];
                        judge = true;
                    }
                }
                if(!judge){
                    res.add(new ListNode(total[i][1]));
                }
            }
        }
        System.out.println(res.size());
    }
}
class ListNode{
    public int value;
    public ListNode(int value){
        this.value = value;
    }
}

