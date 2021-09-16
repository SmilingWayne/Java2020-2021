package dp;

public class dpq1 {
    public static void main(String[] args) {
        int[] res = {-2,1,-3,4 ,-1 ,2 ,1 ,-5, 4};
        int[] dp = new int[res.length];
        int ans = 0;
        for(int i = 0; i < res.length; i ++ ){
            if(i == 0){
                dp[i] = Math.max(0, res[i]);
            }
            else{
                int add = Math.max(0, dp[i - 1]);
                ans = Math.max(add + res[i], ans);
                if(add + res[i]> 0){
                    dp[i] = add + res[i];
                }
                else{
                    dp[i] = 0;
                }
            }
        }
        System.out.println(ans);
    }
}
