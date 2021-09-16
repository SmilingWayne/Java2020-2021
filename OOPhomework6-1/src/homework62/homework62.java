package homework62;
import java.util.Scanner;
public class homework62{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int numbers = scan.nextInt();
        int[] eachHour = new int[numbers];
        int Times = 0;
        int maxTime = 0;
        for (int i = 0; i < numbers; i++) {
            eachHour[i] = scan.nextInt();
            Times += eachHour[i];
        }
        int[][] countTable = new int[numbers + 1][Times + 1];
        for (int i = 0; i <= numbers; i++)
            for (int j = 0; j < Times; j++) {
                if (i ==  0)
                    countTable[i][j] = 0;
                else if (j < eachHour[i - 1])
                    countTable[i][j] = countTable[i - 1][j];
                else
                    countTable[i][j] = Math.max(countTable[i - 1][j], countTable[i - 1][j - eachHour[i - 1]] + eachHour[i - 1]);
            }
        for (int i = 0; i <= Times / 2; i++)
            maxTime = Math.max(maxTime, countTable[numbers][i]);

        System.out.println(Times - maxTime);
    }
}