package homework;
import java.util.*;
public class homework14 {
    public static void main(String[] args) {
        /*
        闪现：可以选择三种操作：前进1，后退1，坐标乘2
        5->17
        答案：4
        广度优先搜索
         */
        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        int end = scan.nextInt();
        int[] board = new int[end + 1];
        Arrays.fill(board, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;
        while(true){
            int size = queue.size();
            for(int j = 0; j < size; j ++ ){
                int i = queue.poll();
                board[i] = count;
                if(i * 2 < end + 1 && i * 2 >= 0 && board[i * 2] == - 1){
                    queue.add(i * 2);
                }
                if(i + 1 < end + 1 && i + 1 >= 0 && board[i + 1] == - 1){
                    queue.add(i + 1);
                }
                if(i - 1 < end + 1 && i - 1 >= 0 && board[i - 1] == -1){
                    queue.add(i - 1);
                }
            }
            count ++ ;
            if(board[board.length - 1] != - 1){
                break;
            }
        }
        System.out.println(board[board.length - 1]);
    }
}
