package test;
import java.util.*;
public class test417 {
    public static void main(String[] args) {
        Solution a = new Solution();
        int[][] tasks = new int[][]{{1,2},{2,4},{3,2},{4,1}};
        int[] b = a.getOrder(tasks);
        /*
        已完成！
         */
    }
}
class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] ans = new int[tasks.length];
        int[][] help = new int[tasks.length][3];
        for(int i = 0 ; i < tasks.length; i ++ ){
            help[i][0] = tasks[i][0];
            help[i][1] = tasks[i][1];
            help[i][2] = i;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2){
                if(a1[0] > a2[0]){
                    return 1;
                }
                if(a1[0] == a2[0]){
                    if(a1[1] > a2[1]){
                        return 1;
                    }
                }
                return 0;
            }
        });
        Arrays.sort(help, (a,b) ->{
            if(a[0] > b[0]){
                return 1;
            }
            else if(a[0] == b[0]){
                if(a[1] > b[1]){
                    return 1;
                }
                if(a[1] == b[1]){
                    if(a[2] > b[2]){
                        return 1;
                    }
                }
            }
            return -1;
        });
        int index = 0;
        int next = 1;
        int time = help[0][0];
        //System.out.println("time =" + time);
        pq.add(new int[]{help[0][1], help[0][2]});
        //System.out.println("the first " + pq.peek()[0] + " " + pq.peek()[1]);
        while(pq.size() > 0){
            int[] z = pq.poll();
            time += z[0];
            for(int i = next ; i < help.length; i ++ ){
                if(help[i][0] <= time){
                    pq.add(new int[]{help[i][1], help[i][2]});

                    if(i == help.length - 1){
                        next = help.length;
                    }
                }
                else{
                    next = i;
                    break;
                }
            }
            while(pq.size() > 0){
                System.out.println(pq.peek()[0] + " " + pq.peek()[1]);
                pq.poll();
            }
            ans[index ++] = z[1];
            System.out.println(ans[index - 1]);
        }
        return ans;


    }
}