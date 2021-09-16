package OOPclass11;

public class question3 {
    public static void main(String[] args) {
        int[] cards = {9,8,17,6};
        int count = 0;
        int sum = 0;
        for(int i = 0; i < cards.length; i++){
            sum += cards[i];
        }
        int avg = sum/cards.length;
        while(true){
            int max = -1;
            int p = -1;
            for(int i = 0; i < cards.length; i++){
                if(cards[i] > max){
                    max = cards[i];
                    p = i;
                }
            }
            if(max == avg){
                break;
            }
            int left = 0;
            int right = 0;
            for(int i = 0; i < p ; i++){
                left += cards[i];
            }
            for(int i = p + 1; i < cards.length ; i ++){
                right += cards[i];
            }
            if(p > 0 && left < p*avg){
                count ++;
                cards[p - 1] += p*avg - left;
            }
            if(p < cards.length - 1 && right < (cards.length - p - 1)){
                count ++;
                cards[p + 1] += (cards.length - p - 1)* avg - right;
            }

        }
    }
}
