package Queen;

/**
 * 这里给出了八皇后的解法和总共的个数
 */
public class eightqueen {
    int max = 8;
    static int count = 0;
    int[] array = new int[max]; //定义皇后所在的格子：可共享的数组结果//
    public static void main(String[] args){
        eightqueen queue8 = new eightqueen();
        queue8.check(0);
        System.out.printf("一共解法：%d",count);

    }
    private void check(int n ){
        if(n == max){
            print();
            count++;
            return;
        }
        for(int i = 0 ; i < max ; i++){
            array[n] = i;
            if(judge(n)){
                check(n+1);
            } //这里已经产生了回溯？？？？？//
        }
    }
    private boolean judge(int n){
        //n在数组中序号表示第n个皇后，n也表示皇后所在的列：在同一条直线上：斜率为1：就能解释前面的绝对值对比得出judge方法//
        for(int i = 0; i < n; i++){
            if(array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true; //说明：表示判断第n个皇后是否和前面的皇后在同一列或者同一斜线//
    }
    private void print(){
        for(int i = 0; i < max; i ++){
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }
}
