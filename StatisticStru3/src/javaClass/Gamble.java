package javaClass;
import java.util.Random;
public class Gamble {
    public static void main(String[] args){
        int numberOfScenario = 10000;
        int numberOfWin = 0;
        int numberOfwrong = 0;
        int initialMoney = 50;
        int target = 250;
        Random rand = new Random(1);
        for(int i =0 ; i<numberOfScenario;i++){
            int count=0;
            int money = initialMoney;
            while(money>0&&money<target){
                double p= rand.nextDouble();
                if(p<0.5)
                    money++;
                else
                    money--;
                count++;
            }
            if(money>=target)
                numberOfWin+=1;
            numberOfwrong+=count;

        }
        System.out.println("Probability of winning:"+(double)numberOfWin/numberOfScenario);
        System.out.println("Probability of running:"+(double)numberOfwrong/numberOfScenario);

    }
}
