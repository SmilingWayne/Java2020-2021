package homework9;
import java.util.*;
public class homework9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        int destination = scan.nextInt();
        scan.close();
        int[] length = new int[destination + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] direction = { -1, 0, 1};
        int count = 0;
        queue.add(start);
        length[start] = 0;
        boolean flag = false;
        while(queue.size() > 0 || flag == false){
            int size = queue.size();
            count ++;
            for(int i = 0; i < size; i ++ ){
                int location = queue.poll();

                for(int j = 0; j < 3; j ++ ){
                    int target  = 0;
                    if(location + direction[j] < 0 || location + direction[j] > destination || location * 2 > destination){
                        continue;
                    }
                    else if(location + direction[j] == location){
                        target = location * 2;
                        if(length[target] == 0) {
                            length[target] = count;
                            if(target == destination){
                                flag = true;
                                break;
                            }
                        }
                        else {
                            continue;
                        }
                    }
                    else{
                        if(length[location + direction[j]] == 0)
                            length[location + direction[j]] = count;
                        if(location + direction[j] == destination ){
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag == true){
                    break;
                }
            }

        }
        System.out.println(length[destination]);
    }
}
