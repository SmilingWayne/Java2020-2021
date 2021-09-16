package backTrack;

import java.util.*;
public class fullPermutation {
    /*
    Every number can be used once
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] all = new int[n];
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < n; i ++ ){
            all[i] = scan.nextInt();
        }
        List<Integer> list = new ArrayList<>();

        dfs(res, list, n,all);

        for(int i = 0 ; i < res.size() ; i++ ){
            for(int j = 0 ; j < res.get(i).size(); j ++ ){
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.println("");
        }
    }
    public static void dfs(List<List<Integer>> res , List<Integer> list, int n,int[] all){
        if(list.size() == n){
            res.add(new ArrayList<Integer>(list));
            return ;
        }
        for(int i = 0; i < n ; i ++ ){
            if(list.contains(all[i])){
                continue;
            }
            list.add(all[i]);
            dfs(res, list, n , all);
            list.remove(list.size() - 1);
        }
    }
}
