package newMain;

import java.util.Arrays;
import java.util.Scanner;
public class newMain {
    public static final double CH_PER_INCH=2.54;//静态常量，在全部函数中都可以使用//
    public static void newMain(String[] args) {
        final int NMAX=10;//这里的final表明此数字只能被赋值一次，赋值之后不允许更改//
        int[][] odds=new int[NMAX+1][];//这里是先确定了行数，根据行数确定每一行
        // 几个元素//
        for(int n=0;n<=NMAX;n++){
            odds[n]=new int[n+1];
        }
        odds[0][0]=1;
        odds[1][0]=1;
        odds[1][1]=1;
        for (int t=2;t<odds.length;t++){
            for(int k=0;k<odds[t].length;k++){
                if(k==0||k==odds[t].length-1)
                    odds[t][k]=1;
                else{
                    odds[t][k]=odds[t-1][k-1]+odds[t-1][k];
                }
            }
        }
        System.out.println(Arrays.deepToString(odds));
        //这里的意思是直接全部输出成一个巨型数组//
        int[] happy=new int[10];
        for(int i=0;i<10;i++){
            happy[i]=19-i;
        }
        Arrays.sort(happy);//数组排序函数，对比python中.sort()函数//
        for(int i=0;i<10;i++){
            System.out.println(happy[i]);
        }
        int[] copiedLuckyNumbers=Arrays.copyOf(happy,happy.length);
        //复制一个数组//
        Scanner in=new Scanner(System.in);
        String input;
        do{
            System.out.println("Do you want to continue?");

            input=in.next();
        }while(input.equalsIgnoreCase("N"));
        String expletive="elx";
        String Hanls="Hanls";
        String totalhawaii=expletive+Hanls;
        //Java的字符串支持+的操作//
        String greetings="Hello";
        String n=greetings.substring(1,3);//从String中截取一部分，节点通过具体序号表示出来//
        //Java支持三元运算符//

        System.out.println(n);
        System.out.println(CH_PER_INCH);
        Integer a,b;//可以像C语言一样一起声明所有的要用的参数//
    }
}
//杨辉三角的制作！//