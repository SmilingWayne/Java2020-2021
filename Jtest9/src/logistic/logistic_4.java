package logistic;

import java.util.*;

public class logistic_4 {
    public static void main(String[] args) {
        int[][] c = {{4,12,20,6},{2,10,25,10},{3,4,16,14},{6,5,9,2},{18,12,7,3},{14,4,4,9},{20,30,2,11},{24,12,6,22}};
        int[] d = {100,50,120,80,200,70,60,100};
        int[] new_d_2 = new int[d.length];
        for(int i = 0; i < new_d_2.length; i ++ ){
            new_d_2[i] = d[i] + 15;
        }
        double[][] new_c_2 = new double[c.length][c[0].length];
        for(int i = 0 ; i < new_c_2.length; i ++ ){
            for(int j = 0 ; j < new_c_2[0].length; j ++ ){
                new_c_2[i][j] = c[i][j] +(double)(2+5)/2;
            }
        }

        function_1(c, d);
        System.out.println("\n\t\t------------------------");
        function_2(new_c_2, new_d_2);
        System.out.println("\n\t\t------------------------");
        calculate_3(new int[]{-2,2,-20,20}, 1);
        calculate_3(new int[]{-1,1,-10,10},2);
        calculate_3(new int[]{2,5,10,20},3);

    }

    /**
     * 计算最大后悔值, int 类型
     * @param deviation
     */
    public static void calculate_3(int[] deviation, int num){
        // deviation = [-2,2,-20,20];
        int[] choice = new int[]{1,1,1,1,3,3,3,3};
        int[][] c = {{4,12,20,6},{2,10,25,10},{3,4,16,14},{6,5,9,2},{18,12,7,3},{14,4,4,9},{20,30,2,11},{24,12,6,22}};
        int[][] original_c = new int[c.length][c[0].length];
        for(int i = 0; i < original_c.length; i ++ ){
            for(int j = 0; j < original_c[0].length; j ++ ) {
                original_c[i][j] = c[i][j];
            }
        }
        int[] d = {100,50,120,80,200,70,60,100};
        for(int i = 0; i < c.length; i ++ ){
            for(int j = 0; j < c[0].length; j ++ ){
                if(j == choice[i] - 1){
                    c[i][choice[i] - 1] += deviation[1];
                }
                else{
                    c[i][j] += deviation[0];
                }
            }
        }
        int[] new_choice = function_3(c,d, num);
//        for(int i = 0; i < new_choice.length; i ++ ){
//            System.out.println(new_choice[i]);
//        }
        // new_choice = [4,4,2,4,4,2,4,2]
        int regrets = 0;
        for(int i = 0 ; i < new_choice.length; i ++ ){
            if(c[i][new_choice[i] - 1] > c[i][choice[i] - 1]){
                d[i] += deviation[2];
                regrets -= ((c[i][new_choice[i] - 1] - c[i][choice[i] - 1])*d[i]);
            }
            else if(c[i][new_choice[i] - 1] < c[i][choice[i] - 1]){
                d[i] += deviation[3];
                regrets += ((c[i][choice[i] - 1] - c[i][new_choice[i] - 1]) * d[i]);
            }
        }
        System.out.println("\t\t情景" + " " +  num + " 最大后悔值: " + regrets);
        System.out.println("\t\t具体安排如下：");
        for(int i = 0; i < d.length; i ++ ){
            System.out.println("\t\t超市 " + (i + 1) + " 由 " + new_choice[i] + " 物流中心运输 " + d[i] + " 单位的货物" );
        }
        System.out.println("\n\t\t------------------------");

    }

    public static void calculate_4(int[] deviation , int num){

    }
    /**
     *
     * @param c double 类型的c数组
     * @param d
     */
    public static void function_2(double[][] c , int[] d){
        System.out.println("\t\t情景3:");
        Set<Integer> choice = new HashSet<>();
        int[] supermarket = new int[c.length];
        for(int i = 0; i < c.length; i ++ ){
            int index = 0;
            for(int j =0 ; j < 4; j ++ ){
                if(c[i][j] < c[i][index]){
                    index = j;
                }
            }
            supermarket[i] = index + 1;
        }
        int totalcenter = 4;
        while(totalcenter > 2){
            int[] lost = new int[4];
            if(choice.size() > 0){
                for(int i : choice){
                    lost[i] = Integer.MAX_VALUE;
                }
            }
            for(int i = 0 ; i < c.length; i ++ ){
                double count = Integer.MAX_VALUE;
                for(int j = 0 ; j < c[0].length; j ++ ){
                    if(j != supermarket[i] - 1 && !choice.contains(j)){
                        if(c[i][j] - c[i][supermarket[i] - 1] < count){
                            count = c[i][j] - c[i][supermarket[i] - 1];
                        }
                    }
                }
                lost[supermarket[i] - 1] += count * d[i];
            }
            int current_index = 0;
            for(int i : choice){
                lost[i] = Integer.MAX_VALUE;
            }
            for(int i = 1 ; i < lost.length; i ++ ){
                if(lost[i] < lost[current_index]){
                    current_index = i;
                }
            }
            System.out.println("\t\t删除 " + (current_index+1) + " 物流中心");
            choice.add(current_index);
            for(int i = 0; i < c.length; i ++ ){
                int index = 0;
                for(int j = 0 ; j < 4; j ++ ){
                    if(c[i][j] < c[i][index] && !choice.contains(j)){
                        index = j;
                    }
                }
                supermarket[i] = index + 1;
            }
            totalcenter -- ;
        }
        Set<Integer> finalchoice = new HashSet<>();
        for(int i = 0 ; i < c[0].length; i ++ ){
            if(!choice.contains(i)){
                finalchoice.add(i + 1);
            }
        }
        int[] ans = new int[finalchoice.size()];
        int index = 0;
        for(int j : finalchoice){
            ans[index ++ ] = j;
        }
        double total = 0;
        for(int i = 0 ; i < c.length; i ++ ){
            if(c[i][ans[0] - 1] < c[i][ans[1] - 1]){
                System.out.println("\t\t超市 " + (i + 1) + " 由" + ans[0] + " 物流中心运输 " + d[i] + " 单位的货物");
                total += c[i][ans[0]  - 1] * d[i];
            }
            else{
                System.out.println("\t\t超市 " + (i + 1) + " 由" + ans[1] + " 物流中心运输 " + d[i] + " 单位的货物");
                total += c[i][ans[1]  - 1] * d[i];
            }
        }
        System.out.println("\t\t一共 " + String.format("%.2f", total) +  " 成本");
    }


    /**
     *
     * @param c int 类型的c数组
     * @param d
     */
    public static int[] function_3(int[][] c, int[] d, int num){
        System.out.println("\t\t情景 " + num + " :" );
        Set<Integer> choice = new HashSet<>();
        int[] supermarket = new int[c.length];
        for(int i = 0; i < c.length; i ++ ){
            int index = 0;
            for(int j =0 ; j < 4; j ++ ){
                if(c[i][j] < c[i][index]){
                    index = j;
                }
            }
            supermarket[i] = index + 1;
        }
        int totalcenter = 4;
        while(totalcenter > 2){
            int[] lost = new int[4];
            if(choice.size() > 0){
                for(int i : choice){
                    lost[i] = Integer.MAX_VALUE;
                }
            }
            for(int i = 0 ; i < c.length; i ++ ){
                int count = Integer.MAX_VALUE;
                for(int j = 0 ; j < c[0].length; j ++ ){
                    if(j != supermarket[i] - 1 && !choice.contains(j)){
                        if(c[i][j] - c[i][supermarket[i] - 1] < count){
                            count = c[i][j] - c[i][supermarket[i] - 1];
                        }
                    }
                }
                lost[supermarket[i] - 1] += count * d[i];
            }
            int current_index = 0;
            for(int i : choice){
                lost[i] = Integer.MAX_VALUE;
            }
            for(int i = 1 ; i < lost.length; i ++ ){
                if(lost[i] < lost[current_index]){
                    current_index = i;
                }
            }
            System.out.println("\t\t删除 " + (current_index+1) + " 物流中心");
            choice.add(current_index);
            for(int i = 0; i < c.length; i ++ ){
                int index = 0;
                for(int j = 0 ; j < 4; j ++ ){
                    if(c[i][j] < c[i][index] && !choice.contains(j)){
                        index = j;
                    }
                }
                supermarket[i] = index + 1;
            }
            totalcenter -- ;
        }
        Set<Integer> finalchoice = new HashSet<>();
        for(int i = 0 ; i < c[0].length; i ++ ){
            if(!choice.contains(i)){
                finalchoice.add(i + 1);
            }
        }
        int[] ans = new int[finalchoice.size()];
        int index = 0;
        for(int j : finalchoice){
            ans[index ++ ] = j;
        }
        int[] re = new int[c.length];
        for(int i = 0 ; i < c.length; i ++ ){
            if(c[i][ans[0] - 1] < c[i][ans[1] - 1]){
                re[i] = ans[0];
            }
            else{
                re[i] = ans[1];
            }
        }
        return re;
    }

    public static void function_1(int[][] c, int[] d){
        System.out.println("\t\t情景1、情景2:");
        Set<Integer> choice = new HashSet<>();
        int[] supermarket = new int[c.length];
        for(int i = 0; i < c.length; i ++ ){
            int index = 0;
            for(int j =0 ; j < 4; j ++ ){
                if(c[i][j] < c[i][index]){
                    index = j;
                }
            }
            supermarket[i] = index + 1;
        }
        int totalcenter = 4;
        while(totalcenter > 2){
            int[] lost = new int[4];
            if(choice.size() > 0){
                for(int i : choice){
                    lost[i] = Integer.MAX_VALUE;
                }
            }
            for(int i = 0 ; i < c.length; i ++ ){
                int count = Integer.MAX_VALUE;
                for(int j = 0 ; j < c[0].length; j ++ ){
                    if(j != supermarket[i] - 1 && !choice.contains(j)){
                        if(c[i][j] - c[i][supermarket[i] - 1] < count){
                            count = c[i][j] - c[i][supermarket[i] - 1];
                        }
                    }
                }
                lost[supermarket[i] - 1] += count * d[i];
            }
            int current_index = 0;
            for(int i : choice){
                lost[i] = Integer.MAX_VALUE;
            }
            for(int i = 1 ; i < lost.length; i ++ ){
                if(lost[i] < lost[current_index]){
                    current_index = i;
                }
            }
            System.out.println("\t\t删除 " + (current_index+1) + " 物流中心");
            choice.add(current_index);
            for(int i = 0; i < c.length; i ++ ){
                int index = 0;
                for(int j = 0 ; j < 4; j ++ ){
                    if(c[i][j] < c[i][index] && !choice.contains(j)){
                        index = j;
                    }
                }
                supermarket[i] = index + 1;
            }
            totalcenter -- ;
        }
        Set<Integer> finalchoice = new HashSet<>();
        for(int i = 0 ; i < c[0].length; i ++ ){
            if(!choice.contains(i)){
                finalchoice.add(i + 1);
            }
        }
        int[] ans = new int[finalchoice.size()];
        int index = 0;
        for(int j : finalchoice){
            ans[index ++ ] = j;
        }
        int total = 0;
        for(int i = 0 ; i < c.length; i ++ ){
            if(c[i][ans[0] - 1] < c[i][ans[1] - 1]){
                System.out.println("\t\t超市 " + (i + 1) + " 由" + ans[0] + " 物流中心运输 " + d[i] + " 单位的货物");
                total += c[i][ans[0]  - 1] * d[i];
            }
            else{
                System.out.println("\t\t超市 " + (i + 1) + " 由" + ans[1] + " 物流中心运输 " + d[i] + " 单位的货物");
                total += c[i][ans[1]  - 1] * d[i];
            }
        }
        System.out.println("\t\t一共 " + total  +  " 成本");
    }
}
