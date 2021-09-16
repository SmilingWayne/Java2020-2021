package com.company;
import java.util.*;
import java.time.*;
public class Main {

    public static void main(String[] args) {
        int[] a = new int[10];//表示创建了一个新的数组了//
        String[] names = new String[10];
        Scanner in = new Scanner(System.in);
        System.out.print("How many numbers do you need to draw?");
        int k = in.nextInt();
        System.out.print("WHat is the highest number you can draw?");
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            int r = (int) (Math.random() * n);
            result[i] = numbers[r];
            numbers[r] = numbers[n - 1];
            n--;
        }
        Arrays.sort(result);
        System.out.println("Bet the following combination. It will make you rich.");
        for (int r : result)
            System.out.println(r);
        double[][] balances = new double[5][5];
        String all = String.join("/", "S", "N", "L");
        System.out.println(all);

        //注意了，java和python一样都是有join操作的//
        "Hello".equalsIgnoreCase("hello");
        //这是忽略大小写的表达方法//
        //检验是否为空
        if (balances.equals(""))
            System.out.print("Goodness!");
        String greetings = "Hello";
        char[] first = greetings.toCharArray();
        System.out.print(first);
        //把string类型的转换成字符数组//
        System.out.printf("%tc", new Date());//注意了这里是printf函数//
    }
}
