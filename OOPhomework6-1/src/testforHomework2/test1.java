package testforHomework2;

//这里是对第二个DP问题的补充//
import java.util.Scanner;

public class test1 {

    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);
        int numberOfItems = scan.nextInt();
        int[] hourForEach = new int[numberOfItems];//该一维数组用于存储每个零件的打造耗时。
        int totalTime = 0;
        int maxTime = 0;

        for (int i = 0; i < numberOfItems; i++) {
            hourForEach[i] = scan.nextInt();
            totalTime += hourForEach[i];
        }

        int[][] countTable = new int[numberOfItems + 1][totalTime + 1];
        for (int i = 0; i <= numberOfItems; i++)
            for (int j = 0; j < totalTime; j++) {
                if (i == 0)//将第一行初始化
                    countTable[i][j] = 0;
                else if (j < hourForEach[i - 1])//当列数j<下一个零件的打造时长时。
                    countTable[i][j] = countTable[i - 1][j];//复制上一行同列的结果
                else //当列数j>=下一个零件的打造时长时。
                    countTable[i][j] = Math.max(countTable[i - 1][j], countTable[i - 1][j - hourForEach[i - 1]] + hourForEach[i - 1]);
            }

        print(countTable);

        for (int i = 0; i <= totalTime / 2; i++)//打印countTable最后一行，第totalTime / 2列中的内容即为结果。
            maxTime = Math.max(maxTime, countTable[numberOfItems][i]);

        System.out.println(totalTime - maxTime);
    }

    public static void print(int[][] a){
        //可以加上这个打印函数查看二维数组countTable的内容。
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++)
                System.out.print(a[i][j]+", ");
            System.out.println();
        }
    }
}

