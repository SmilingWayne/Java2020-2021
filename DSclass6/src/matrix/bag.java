package matrix;

public class bag {
    public static void main(String[] args){
        int[] weight = {1,2,3,4};
        int[] value = {1000,1200,3000,2000};
        int totalBag = 6;
        int ans = 0;
        int[][] total = new int[value.length + 1][totalBag + 1];
        for(int i = 0 ; i < total.length; i++){
            for(int j = 0; j < total[0].length; j++){
                if(i == 0){
                    total[i][j] = 0;
                }
                else{
                    if(j >= weight[i - 1]){
                        int k = j/ weight[i - 1];
                        total[i][j] = Math.max(total[i - 1][j - k*weight[i - 1]], k * value[i - 1]);
                    }
                    else if(j < weight[i - 1]){
                        total[i][j] = total[i - 1][j];
                    }
                }
            }
        }
        for(int i = 0; i < value.length + 1;i ++){
            ans = Math.max(ans,total[i][totalBag]);
        }
        System.out.println(ans);
    }
}