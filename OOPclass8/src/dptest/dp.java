package dptest;

public class dp {
    public static void main(String[] args){
        int[] nums = {1,1,1,1,1};
        int S = 3;
        Solution hp = new Solution(nums,S);
        System.out.println(hp.findTargetSumWays());



    }
}
class Solution {
    public int[] nums;
    public int S;
    public Solution(int[] nums, int S){
        this.nums = nums;
        this.S = S;
    }
    public int findTargetSumWays() {
        int length = 0;
        int totalMax = 0;
        for(int i = 0 ; i < nums.length; i++){
            length += nums[i];
        }
        int Length = nums.length;
        int[][] dp = new int[Length + 1][2*(length) + 3];

        for(int i = 0; i <= Length ; i ++){
            if(i == 0){
                for(int j = 0; j < length; j++){
                    if(j == 0){
                        dp[i][j + length] = 1;
                    }
                    else{
                        dp[i][j + length ] = 0;
                        dp[i][length - j ] = 0;
                    }
                }
            }
            else{
                for(int j = 0; j < length ; j ++){
                    if(length - j - nums[i - 1] >=0) {
                        dp[i][j + length] = dp[i - 1][length + j - nums[i - 1]] + dp[i - 1][j + nums[i - 1] + length];
                        dp[i][length - j] = dp[i - 1][length - j - nums[i - 1]] + dp[i - 1][nums[i - 1] + length - j];
                    }
                }
            }

        }
        for(int i = 0; i < dp.length; i++){
            for(int j = 0 ; j < dp[0].length; j ++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        int ans = length + Math.abs(S);
        return dp[nums.length][ans];
    }

}
