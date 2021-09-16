package backTrack;

import java.util.*;
public class fullPermutation3 {
    /*
    AAB -> A / AB / AA/ AAB / BA / B / BAA / ABA
    similar to movable Type printing ("活字印刷")
    return total Permutation
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String p = scan.next();
        scan.close();
        p = p.toLowerCase();
        int[] list = new int[26];
        for(int i = 0 ; i < p.length(); i ++ ){
            list[p.charAt(i) - 'a'] ++;
        }
        List<Character> help = new ArrayList<>();
        List<List<Character>> res = new ArrayList<>();
        dfs(list, res, help);
        for(List<Character> a : res){
            for(int i = 0 ; i < a.size(); i ++ ){
                System.out.print(a.get(i));
            }
            System.out.println("");
        }
        System.out.println(res.size() - 1);
    }
    public static void dfs(int[] list , List<List<Character>> res, List<Character> help){
        if(!res.contains(help)){
            res.add(new ArrayList<>(help));
        }
        for(int i = 0; i < 26; i ++ ){
            if(list[i] > 0){
                help.add((char)(i + 'a'));
                list[i] -- ;
                dfs(list , res, help);
                list[i] ++ ;
                help.remove(help.size() - 1);
            }
        }
    }
}
