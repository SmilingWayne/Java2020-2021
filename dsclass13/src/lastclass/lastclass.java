package lastclass;
import java.util.*;
public class lastclass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numbers = scan.nextInt();
        int capacity = scan.nextInt();
        int totalConflict = scan.nextInt();
        int totalPenalty = scan.nextInt();
        int[][] bag = new int[numbers][2];
        int[][] conflictArray = new int[totalConflict][2];
        ArrayList<ArrayList<Integer>> penality = new ArrayList<>();
        ArrayList<Integer> penalityNumber = new ArrayList<>();
        for(int i = 0 ; i < numbers ; i ++ ){
            bag[i][0] = scan.nextInt();
            bag[i][1] = scan.nextInt();
        }
        for(int i = 0 ; i < totalConflict; i ++ ){
            conflictArray[i][0] = scan.nextInt();
            conflictArray[i][1] = scan.nextInt();
        }
        for(int i = 0 ; i < totalPenalty ; i ++ ){
            ArrayList<Integer> helper = new ArrayList<>();
            for(int j = 0 ; j < 3; j ++ ){
                int a = scan.nextInt();
                helper.add(a);
            }
            penality.add(helper);
            int x = scan.nextInt();
            penalityNumber.add(x);
        }
        scan.close();
        boolean[][] conflict = new boolean[numbers][numbers];
        for(int i = 0 ; i < totalConflict; i ++ ){
            conflict[conflictArray[i][0]][conflictArray[i][1]] = true;
            conflict[conflictArray[i][1]][conflictArray[i][0]] = true;
        }
        ArrayList<Integer> best_solution = new ArrayList<>();
        int best_profit = 0;
        ArrayList<Integer> s = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> record = new ArrayList<>();

        int[][] f = dp(capacity, record, numbers, bag, penality, penalityNumber);
        dfs(s, 0, 0, -1,best_profit, capacity, best_solution,bag, numbers, conflict, f);
        System.out.println(best_profit);
        /*
        KPC kpc = new KPC(numbers, bag, capacity, conflict, penality, penalityNumber);
        kpc.solve();

        int t = kpc.best_profit;
        System.out.println(t);


         */
    }
    public static void dfs(ArrayList<Integer> s, int w, int p, int index, int best_profit, int capacity, ArrayList<Integer> best_solution,
                           int[][] bag, int numbers, boolean[][] conflict, int[][] f){
        if(p + f[index + 1][capacity - w] <= best_profit){
            return;
        }
        if(p > best_profit){
            best_profit = p;
            best_solution = new ArrayList<Integer>(s);
        }
        for(int i = index + 1; i < numbers ; i++){
            if(w + bag[i][0] > capacity){
                continue;
            }
            boolean feasible = true;
            for(int j = 0; j < s.size(); j++){
                if(conflict[s.get(j)][i]){
                    feasible = false;
                    break;
                }
            }
            if(feasible == false){
                continue;
            }
            s.add(i);
            if(f[0][w] == f[0][w + bag[i][0]]) {
                s.remove(s.size() - 1);
                continue;
            }
            else {
                dfs(s, w + bag[i][0], f[index + 1][w + bag[i][0]], i, best_profit, capacity, best_solution, bag, numbers, conflict, f);
            }
            s.remove(s.size() - 1);

        }
    }
    public static int[][] dp(int capacity, ArrayList<ArrayList<Integer>> record, int numbers, int[][] bag,
                   ArrayList<ArrayList<Integer>> penality, ArrayList<Integer> penalityNumber) {
        for (int i = 0; i <= capacity; i++) {
            record.add(new ArrayList<Integer>());
        }
        int[][] f = new int[numbers + 1][capacity + 1];
        int balance = 0;
        for (int i = numbers - 1; i >= 0; i--) {
            for (int w = 0; w <= capacity; w++) {
                if (bag[i][0] > w) {
                    f[i][w] = f[i + 1][w];
                } else {
                    record.get(w).add(i);
                    boolean[] judge = new boolean[penality.size()];

                    if (record.get(w).size() >= 2) {
                        int[] count = new int[penality.size()];
                        Arrays.fill(count, 0);
                        for (int k = 0; k < record.get(w).size(); k++) {
                            for (int m = 0; m < penality.size(); m++) {
                                if (penality.get(m).contains(record.get(w).get(k))) {
                                    count[m]++;
                                }
                                if (count[m] >= 2 && judge[m] == false) {
                                    balance = balance + penalityNumber.get(m);
                                    judge[m] = true;
                                    //System.out.println("ahah!");
                                    break;
                                }
                            }
                        }
                    }
                    boolean judgeSwitch = false;
                    int formal = f[i + 1][w];
                    f[i][w] = Math.max(f[i + 1][w], f[i + 1][w - bag[i][0]] + bag[i][1] - balance);
                    if (formal == f[i + 1][w] && formal != 0) {
                        record.get(w).remove(record.get(w).size() - 1);
                    }
                    balance = 0;
                }
            }
        }
        return f;
    }
}
/*
class KPC{
    public int numbers ;
    public int[][] bag ;
    public int capacity;
    public boolean[][] conflict ;
    public ArrayList<ArrayList<Integer>> penality;
    public ArrayList<Integer> penalityNumber;
    public int best_profit = 0;
    public ArrayList<ArrayList<Integer>> record = new ArrayList<>();
    public int[][] f;
    public ArrayList<Integer> best_solution = new ArrayList<>();
    public KPC(int numbers, int[][] bag, int capacity ,boolean[][] conflict, ArrayList<ArrayList<Integer>> penality,
               ArrayList<Integer> penalityNumber){
        this.bag = bag;
        this.numbers = numbers;
        this.capacity = capacity;
        this.conflict = conflict;
        this.penality = penality;
        this.penalityNumber = penalityNumber;
    }
    public void dfs(ArrayList<Integer> s, int w, int p, int index){
        if(p + f[index + 1][capacity - w] <= best_profit){
            return;
        }
        if(p > best_profit){
            best_profit = p;
            best_solution = new ArrayList<Integer>(s);
        }
        for(int i = index + 1; i < numbers ; i++){
            if(w + bag[i][0] > capacity){
                continue;
            }
            boolean feasible = true;
            for(int j = 0; j < s.size(); j++){
                if(conflict[s.get(j)][i]){
                    feasible = false;
                    break;
                }
            }
            if(feasible == false){
                continue;
            }
            s.add(i);
            if(f[0][w] == f[0][w + bag[i][0]]) {
                s.remove(s.size() - 1);
                continue;
            }
            else {
                dfs(s, w + bag[i][0], f[index + 1][w + bag[i][0]], i);
            }
            s.remove(s.size() - 1);

        }
    }
    public void dp(){
        for(int i = 0; i <= capacity; i ++){
            record.add(new ArrayList<Integer>());
        }
        f = new int[numbers + 1][capacity + 1];
        int balance = 0;
        for(int i = numbers - 1; i >= 0; i--){
            for(int w = 0; w <= capacity; w++){
                if(bag[i][0] > w){
                    f[i][w] = f[i + 1][w];
                }
                else{
                    record.get(w).add(i);
                    boolean[] judge = new boolean[penality.size()];

                    if(record.get(w).size() >= 2){
                        int[] count = new int[penality.size()];
                        Arrays.fill(count, 0);
                        for(int k = 0; k < record.get(w).size(); k ++ ){
                            for(int m = 0 ; m < penality.size(); m ++ ){
                                if(penality.get(m).contains(record.get(w).get(k))){
                                    count[m] ++;
                                }
                                if(count[m] >= 2 && judge[m] == false){
                                    balance = balance + penalityNumber.get(m);
                                    judge[m] = true;
                                    //System.out.println("ahah!");
                                    break;
                                }
                            }
                        }
                    }
                    boolean judgeSwitch = false;
                    int formal = f[i + 1][w];
                    f[i][w] = Math.max(f[i + 1][w], f[i + 1][w - bag[i][0]] + bag[i][1] - balance);
                    if(formal == f[i + 1][w] && formal != 0){
                        record.get(w).remove(record.get(w).size() - 1);
                    }
                    balance = 0;
                }
            }
        }

        for(int i = 0 ; i < f.length; i ++ ){
            for(int j = 0 ; j < f[0].length; j ++){
                System.out.print(f[i][j] + " ");
            }
            System.out.println("");
        }

    }
    public void solve(){
        best_profit = 0;
        ArrayList<Integer> s = new ArrayList<Integer>();
        dp();
        dfs(s, 0, 0, -1);
    }
}
*/
