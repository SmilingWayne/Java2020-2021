package backTrack;
import java.util.*;
public class BT1 {

    public static void main(String[] args) {
        //Q1：找到所有相加等于n的k个数的集合，数字在1到9之间选取，每个组合不存在重复的数字//
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, n , 1, k);

        for(List<Integer> p: res ){
            for(int i = 0; i < p.size(); i ++ ){
                System.out.print(p.get(i) + ",");
            }
            System.out.println("");
        }

    }
    public static void dfs(List<List<Integer>> res, List<Integer> list, int n , int start, int k){
        if(list.size() == k || n <= 0){
            if(list.size() == k && n == 0){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i = start; i < 10; i ++ ){
            list.add(i);
            dfs(res, list, n - i, i + 1, k);
            list.remove(list.size() - 1);
        }
    }
}

