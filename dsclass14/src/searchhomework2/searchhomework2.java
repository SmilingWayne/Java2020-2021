package searchhomework2;
import java.util.*;
public class searchhomework2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numbers = scan.nextInt();
        int length = scan.nextInt();
        ArrayList<Integer> helper = new ArrayList<>();

        for(int i = 0 ; i < numbers; i ++ ){
            helper.add(scan.nextInt());
        }
        scan.close();
        double x = (double)doubleMethod(helper, length) / numbers;
        double y = (double)linearMethod(helper, length) / numbers;
        System.out.printf("%.2f %.2f",y,x);
    }
    public static int doubleMethod(ArrayList<Integer> helper, int length){
        int total = 0;
        int[] count = new int[length];
        Arrays.fill(count,0);
        boolean[] visited = new boolean[length];
        for(int i = 0 ; i < helper.size(); i ++ ){
            int rest = helper.get(i) %length;
            int temp = 1;
            if(visited[rest] == false){
                count[rest] = 1;
                visited[rest] = true;
            }
            else{
                int flag = 1;
                while(true){

                    temp ++;
                    if(visited[(rest + flag * flag)%(length)] == false){
                        visited[(rest + flag * flag)%(length)] = true;
                        count[(rest + flag * flag)%(length)] = temp;
                        break;
                    }
                    int ai = 0;
                    temp ++;
                    if(rest - flag * flag < 0){
                        ai = length - flag * flag + rest;

                    }
                    else{
                        ai = rest - flag * flag;

                    }
                    if(visited[ai % (length)] == false){
                        visited[ai % (length)] = true;
                        count[ai % (length)] = temp;
                        break;
                    }
                    flag ++;
                }
            }
        }
        for(int i = 0 ; i < count.length; i ++ ) {
            total += count[i];
        }
        return total;
    }
    public static int linearMethod(ArrayList<Integer> helper, int length){
        int total = 0;
        int[] count = new int[length];

        boolean[] visited = new boolean[length];
        for(int i = 0 ; i < helper.size(); i ++ ){
            int rest = helper.get(i)% length;
            int tempCount = 1;
            if(visited[rest] == false){
                count[rest] = tempCount;
                visited[rest] = true;
            }
            else{
                tempCount = 1 ;
                while(visited[rest % length] == true){
                    rest ++ ;
                    tempCount ++ ;
                }
                count[rest % length] = tempCount ;
                visited[rest % length] = true;
            }
        }
        for(int i = 0 ; i < count.length; i ++ ){
            total += count[i];
        }

        return total;

    }
}
