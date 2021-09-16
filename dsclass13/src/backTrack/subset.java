package backTrack;

import java.util.*;

public class subset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] all = new int[n];
        for(int i = 0 ; i < n; i++ ){
            all[i] = scan.nextInt();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(res, list, 0, all);
        for(List<Integer> a : res){
            for(int i = 0 ; i < a.size(); i ++ ){
                System.out.print(a.get(i) + ",");
            }
            System.out.println("");
        }
    }
    public static void dfs(List<List<Integer>> res, List<Integer> list, int index, int[] all){
        if(list.size() != 0 && !res.contains(list)){
            res.add(new ArrayList<Integer>(list));
        }
        for(int i = index; i < all.length ; i ++ ){
            list.add(all[i]);
            dfs(res, list, i + 1, all);
            list.remove(list.size() - 1);
        }
    }
}
