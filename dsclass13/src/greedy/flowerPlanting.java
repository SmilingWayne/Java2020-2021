package greedy;
import java.util.*;
//Leetcode.605
public class flowerPlanting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        /*
        Length of the array
         */
        int[] flowerbed = new int[n];
        for(int i = 0 ; i < n ; i ++ ){
            flowerbed[i] = scan.nextInt();
            //numbers
        }
        int target = scan.nextInt();
        //target flowers;
        Solution sl = new Solution();
        System.out.println(sl.canPlaceFlowers(flowerbed, target));

    }
}
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int[] flower = new int[len + 2];

        for(int i = 0 ; i < flower.length; i ++ ){
            if(i == 0 || i == len + 1){
                flower[i] = 0;
            }
            else{
                flower[i] = flowerbed[i - 1];
            }
        }
        int count = 0;
        for(int i = 0 ; i < len + 2; i ++ ){
            if(flower[i] == 0){
                int start = i;
                while(i < len + 2 && flower[i] == 0){
                    i ++ ;
                }
                count += (i - start - 1) / 2;
            }
            else{
                continue;
            }

        }
        return count >= n ? true : false;

    }
}
