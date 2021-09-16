package homework7;
import java.util.*;
public class homework7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[][] table = new int[length][length];
        for(int i = 0; i < length; i ++){
            for(int j = 0 ; j < length; j ++ ){
                table[i][j] = scan.nextInt();
            }
        }
        Hungary board = new Hungary(table);
        board.judge();
    }
}
class Hungary{
    public int[][] table;
    public int length ;
    public boolean[] x ;
    public boolean[] y ;
    public boolean[][] circleTable;
    public int[] ans;
    public Hungary(int[][] table){
        this.table = table;
        this.length = table.length;
        x = new boolean[table.length];
        y = new boolean[table.length];
        circleTable = new boolean[length][length];
        for(int i = 0; i < length; i ++ ) {
            for (int j = 0; j < length; j++) {
                circleTable[i][j] = false;
            }
        }
    }
    public void changeTable() {
        for (int i = 0; i < length; i++) {
            int ass1 = Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                if (table[i][j] == 0) {
                    break;
                } else {
                    ass1 = Math.min(ass1, table[i][j]);
                    if (j == length - 1) {
                        for (int k = 0; k < length; k++) {
                            table[i][k] = table[i][k] - ass1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < length; i++) {
            int ass1 = Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                if (table[j][i] == 0) {
                    break;
                } else {
                    ass1 = Math.min(ass1, table[j][i]);
                    if (j == length - 1) {
                        for (int k = 0; k < length; k++) {
                            table[j][i] = table[j][i] - ass1;
                        }
                    }
                }
            }
        }
    }
    public void operatOnTable(int xx, int yy){
        for(int i = 0 ; i < length; i ++ ){
            if(table[i][yy] == 0 && xx != i){
                circleTable[i][yy] = true;
            }
        }
        for(int i = 0; i < length; i ++){
            if(table[xx][i] == 0 && yy != i){
                circleTable[xx][i] = true;
            }
        }
        x[xx] = true;
        y[yy] = true;

    }
    public int getRowZero(int x, boolean flag){
        if(flag){
            for(int i = 0; i < length; i ++ ){
                if(table[x][i] == 0){
                    return i;
                }
            }
        }
        else{
            for(int i = 0 ; i < length; i ++ ){
                if(table[i][x] == 0){
                    return i;
                }
            }
        }
        return -1;
    }
    public void operateFunc(int xx, int yy){

    }
    public void judge() {
        /*
        find from all the row and column, if 1: immediately operate on this row/column
         */
        int tempRow = 0;
        int tempColumn = 0;
        int recordMinRow = Integer.MAX_VALUE;
        int recordMinColumn = Integer.MAX_VALUE;
        int operatorRow = -1;
        int operatorColumn = -1;
        for(int i = 0 ; i < length; i ++ ){
            int compare = recordMinColumn;
            recordMinColumn = Math.min(judgeColumn(i), recordMinColumn);
            if(recordMinColumn != compare){
                tempColumn = i;
            }
            if(recordMinColumn == 1){
                operatorColumn = i;
                break;
            }
        }
        if(operatorRow == -1 ){
            for(int i = 0 ; i < length; i ++ ){
                int compare = recordMinRow;
                recordMinRow = Math.min(judgeLine(i), recordMinRow);
                if(recordMinRow != compare){
                    tempRow = i;
                }
                if(recordMinRow == 1){
                    operatorRow = i;
                    break;
                }
            }
        }
        int operatX = -1;
        int operatY = -1;
        if(operatorColumn != -1 || operatorRow != -1){

            if(operatorRow != -1){
                operatX = operatorRow;
                operatY = getRowZero(operatX,true);
            }
            else if(operatorColumn != - 1){
                operatY = operatorColumn;
                operatX = getRowZero(operatY,false);
            }
        }
        else{
            if(judgeLine(tempRow) < judgeColumn(tempColumn)){
                operatX = tempRow;
                operatY = getRowZero(operatX,true);
            }
            else if(judgeLine(tempRow) > judgeColumn(tempColumn)){
                operatY = tempColumn;
                operatX = getRowZero(operatY,false);
            }
            else{
                int compareRowRoot = 10000;
                int compareLineRoot = 10000;
                int rememberRowRootPart = 0;
                int rememberColumnPart = 0;
                for(int i = 0; i < length; i ++){
                    if(table[i][tempColumn] == 0){
                        int compareA = compareRowRoot;
                        compareRowRoot = Math.min(compareRowRoot,judgeLine(i));
                        if(compareA != compareRowRoot){
                            rememberRowRootPart = i;
                        }
                    }
                }
                for(int i = 0; i < length; i ++){
                    if(table[tempRow][i] == 0){
                        int compareB = compareLineRoot;
                        compareLineRoot = Math.min(compareLineRoot, judgeColumn(i));
                        if(compareB != compareLineRoot){
                            rememberColumnPart = i;
                        }
                    }
                }
                if(compareRowRoot == Math.min(compareRowRoot,compareLineRoot)){
                    operatX = rememberRowRootPart;
                    operatY = tempColumn;
                }
                else if(compareLineRoot == Math.min(compareLineRoot, compareRowRoot)){
                    operatX = tempRow;
                    operatY = rememberColumnPart;
                }
            }
        }
        //System.out.println(operatX + " //" + operatY);

    }
    public int judgeLine(int x){
        int count = 0;
        for(int i = 0 ; i < length ; i ++ ){
            if(table[x][i] == 0 && circleTable[x][i] == false){
                count ++ ;
            }
        }
        return count;
    }
    public int judgeColumn(int y){
        int count = 0;
        for(int i = 0; i < length; i ++ ){
            if(table[i][y] == 0 && circleTable[i][y] == false){
                count ++;
            }
        }
        return count ;
    }
}