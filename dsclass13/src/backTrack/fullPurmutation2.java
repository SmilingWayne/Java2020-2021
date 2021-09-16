package backTrack;

import java.util.*;
public class fullPurmutation2 {
    /*
    All the numbers can be used for infinite times
    Another permutation problem
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int target = scan.nextInt();
        int[] list = new int[n];
        for(int i = 0 ; i < n ; i ++ ){
            list[i] = scan.nextInt();
        }
        scan.close();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> help = new ArrayList<>();
        dfs(list, help, res, 0, target);
        for(List<Integer> a : res){
            for(int i = 0 ; i < a.size(); i ++ ){
                System.out.print(a.get(i) + " ");
            }
            System.out.println("");
        }
    }
    public static void dfs(int[] list, List<Integer> help, List<List<Integer>> res, int start, int target){
        if(target == 0){
            res.add(new ArrayList<>(help));
            return;
        }
        for(int i = start ; i < list.length;  i ++ ){
            if(target < list[i]){
                continue;
            }
            help.add(list[i]);
            dfs(list, help, res, i, target - list[i]);
            help.remove(help.size() - 1);
        }

    }
}
