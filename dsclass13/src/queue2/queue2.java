package queue2;

import java.io.File;
import java.util.*;
public class queue2 {
    public static void main(String[] args) {
        File file = new File("src/queue2/data");
        try {
            Scanner scan = new Scanner(file);
            int start = scan.nextInt();
            int dest = scan.nextInt();
            int[] b = new int[dest + 1];
            Arrays.fill(b, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            int count = -1;
            while(queue.size() != 0){
                count ++;
                int size = queue.size();
                for(int i = 0 ; i < size; i ++ ){
                    int x = queue.poll();
                    b[x] = count;
                    if(x + 1 <= dest && b[x + 1] == -1){
                        queue.add(x + 1);
                        b[x + 1] = count + 1;
                    }
                    if(x - 1 >= 0 && b[x - 1] == -1){
                        queue.add(x - 1);
                        b[x - 1] = count + 1;
                    }
                    if(x * 2 <= dest && b[2 * x] == -1){
                        queue.add(x * 2);
                        b[2 * x] = count + 1;
                    }
                }
            }
            System.out.println(b[dest]);

        }
        catch(Exception x){
            System.out.println("无法读取文件");
        }
    }
}
