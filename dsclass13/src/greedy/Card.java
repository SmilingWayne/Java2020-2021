//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package greedy;

public class Card {
    public Card() {
    }
    public static void fun3(int[] cards){
        int total = 0;
        int target = 0;
        int count = 0;
        /*
        这个思路的根本其实是要找到最多的那一堆，向左右两边派发分解

         */
        for(int i = 0 ; i < cards.length; i ++ ){
            total += cards[i];
        }
        target = total / cards.length;
        while(true){
            int p = -1;
            int max = -1;
            for(int i = 0 ; i < cards.length; i ++ ){
                if (cards[i] > max){

                    max = cards[i];

                    p = i;
                }
            }
            if(max == target){
                System.out.println(count);
                return;
            }
            int left = 0;
            int right = 0;
            for(int i = 0 ; i < cards.length; i ++ ){
                if(i < p ){
                    left += cards[i];
                }
                if(i > p ){
                    right += cards[i];
                }
            }
            if(p > 0 && left < p * target){
                cards[p - 1] += p * target - left;
                count ++ ;
            }
            if(p < cards.length - 1 && right < (cards.length - 1 - p) * target){
                cards[p + 1] += (cards.length - 1 - p) * target - right;
                count ++;
            }
            cards[p] = target;
        }
    }
    public static void fun(int[] cards) {
        int count = 0;
        int sum = 0;

        int target;
        for(target = 0; target < cards.length; ++target) {
            sum += cards[target];
        }

        target = sum / cards.length;

        while(true) {
            int max = -1;
            int p = -1;


            for(int j = 0; j < cards.length; ++j) {
                if (cards[j] > max) {
                    max = cards[j];
                    p = j;
                }
            }

            if (max == target) {
                System.out.println(count);
                return;
            }

            int left = 0;
            int right = 0;

            for(int i = 0; i < cards.length; ++i) {
                if (i < p) {
                    left += cards[i];
                } else if (i > p) {
                    right += cards[i];
                }
            }

            if (p > 0 && left < p * target) {
                ++count;
                cards[p - 1] += p * target - left;
            }

            if (p < cards.length - 1 && right < (cards.length - p - 1) * target) {
                ++count;
                cards[p + 1] += (cards.length - p - 1) * target - right;
            }

            cards[p] = target;
        }
    }

    public static void fun2(int[] cards) {
        int sum = 0;

        int target;
        for(target = 0; target < cards.length; ++target) {
            sum += cards[target];
        }

        target = sum / cards.length;
        int count = 0;

        for(int i = 0; i < cards.length - 1; ++i) {
            if (cards[i] != target) {
                ++count;
                cards[i + 1] -= target - cards[i];
            }

            cards[i] = target;
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] cards = new int[]{9, 8, 17, 6,14, 6, 21,3, 6};
        fun3(cards);
    }
}
