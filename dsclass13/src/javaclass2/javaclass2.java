package javaclass2;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class javaclass2 {
    public static int[] int2array(int s, int size){
        int[] a = new int[size];
        int iter= 0;
        while(s > 0){
            a[size - 1 - iter] = s % 10;
            s /= 10;
            iter ++;
        }
        return a;
    }

    public static int array2int(int[] a){
        int ret = 0;
        for(int i = 0; i < a.length; i++){
            ret = ret * 10 + a[i];
        }
        return ret;
    }

    public static int bfs(int target, HashSet<Integer> deadends){
        ArrayList<int[]> queue = new ArrayList<int[]>();
        HashSet<Integer> visited = new HashSet<Integer>();
        int[] init = new int[2];
        queue.add(init);
        visited.add(init[0]);
        while(queue.isEmpty() == false){
            int[] s = queue.get(0);
            queue.remove(0);
            if(s[0] == target){
                return s[1];
            }
            if(deadends.contains(s[0])){
                continue;
            }
            int[] a = int2array(s[0], 4);
            for(int i = 0; i < 4; i++){
                //1. up
                int temp = a[i];
                if(a[i] == 9){
                    a[i] = 0;
                }
                else{
                    a[i] ++;
                }
                int[] s1 = new int[2];
                s1[0] = array2int(a);
                s1[1] = s[1] + 1;
                if(visited.contains(s1[0]) == false){
                    visited.add(s1[0]);
                    queue.add(s1);
                }
                a[i] = temp;
                //2. down
                if(a[i] == 0){
                    a[i] = 9;
                }
                else{
                    a[i] --;
                }
                int[] s2 = new int[2];
                s2[0] = array2int(a);
                s2[1] = s[1] + 1;
                if(visited.contains(s2[0]) == false){
                    visited.add(s2[0]);
                    queue.add(s2);
                }
                a[i] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        Scanner scan =  new Scanner(new File("data/input4"));
        int target = scan.nextInt();
        int n = scan.nextInt();
        HashSet<Integer> deadends = new HashSet<Integer>();
        for(int i = 0; i < n; i++){
            deadends.add(scan.nextInt());
        }
        scan.close();
        System.out.println(bfs(target, deadends));
    }
}
