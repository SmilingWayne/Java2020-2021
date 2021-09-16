package dshomework6;
import java.util.*;
public class homework6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int answer = Integer.MAX_VALUE;
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] total = new int[n][n];


        boolean[][] judge = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int value = scan.nextInt();
            total[a - 1][b - 1] = value;
            judge[a - 1][b - 1] = true;
        }
        scan.close();
        int[] arr = new int[n];
        Arrays.fill(arr,-1);
        int[] lineJudge = new int[n];
        Arrays.fill(lineJudge,-1);
        assistant Lord = new assistant(0,judge,total,arr,answer,lineJudge);
        Lord.sort(0,judge,total,arr);
        System.out.println(Lord.answer);
    }
}
class assistant{
    public int i;
    public boolean[][] judge;
    public int[][] total;
    public int[] arr;
    public int answer;
    public int[] lineJudge;
    public assistant(int i ,boolean[][] judge, int[][] total, int[] arr,int answer,int[] lineJudge){
        this.i = i;
        this.judge = judge;
        this.total = total;
        this.arr = arr;
        this.answer = answer;
        this.lineJudge = lineJudge;
    }
    public void sort(int i ,boolean[][] judge, int[][] total,int[] arr){
        int x = 0;
        int originalList = 0;
        if(i == 0 && lineJudge[i] == total.length - 1){
            return;
        }
        if(lineJudge[i] != -1 && lineJudge[i] != total.length - 1){
            originalList = arr[i];
            arr[i] = -1;
            lineJudge[i] = -1;
            x = originalList + 1;
        }
        if(lineJudge[i] == total.length - 1){

            arr[i] = -1;
        }

        for(;x < total[0].length; x++){
            if(judgeNumber(judge,arr,i,x,total)){
                arr[i] = x;
                System.out.println(total[i][x]);
                if(i == arr.length - 1){
                    int helpMe = 0;

                    for(int y = 0; y < total.length; y++){
                        helpMe += total[y][arr[y]];
                    }
                    this.answer = Math.min(helpMe,this.answer);
                    //System.out.println(this.answer);
                    lineJudge[i] = x;
                    if(x < total[0].length -1 ) {
                        sort(i, judge, total, arr);
                        return ;
                    }
                    else if( x == total[0].length - 1){
                        lineJudge[i - 1] ++;
                        lineJudge[i] = -1;
                        sort(i  - 1,judge,total,arr);
                        return;
                    }
                }
                if(i < arr.length - 1) {
                    sort(i + 1, judge, total, arr);
                }
            }
        }
        if(x == total.length){
            lineJudge[i] = total.length - 1;
            if(i == 0){
                return;
            }
        }
    }
    public boolean judgeNumber(boolean[][] judge,int[] arr,int i ,int j,int[][] total){
        if((!judge[i][j]) || existInList(arr,j)){
            return false;
        }
        return true;
    }
    public boolean existInList(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(target == arr[i]){
                return true;
            }
        }
        return false;
    }
}