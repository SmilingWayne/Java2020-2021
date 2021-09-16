//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mergesort;

import java.util.ArrayList;
import java.util.Random;

public class MergeSort {
    public MergeSort() {
    }
    /*
    public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> c = new ArrayList();
        int i = 0;
        int j = 0;

        while(i < a.size() && j < b.size()) {
            if ((Integer)a.get(i) < (Integer)b.get(j)) {
                c.add((Integer)a.get(i));
                ++i;
            } else if ((Integer)a.get(i) > (Integer)b.get(j)) {
                c.add((Integer)b.get(j));
                ++j;
            } else {
                c.add((Integer)a.get(i));
                c.add((Integer)b.get(j));
                ++i;
                ++j;
            }
        }

        while(i < a.size()) {
            c.add((Integer)a.get(i));
            ++i;
        }

        while(j < b.size()) {
            c.add((Integer)b.get(j));
            ++j;
        }

        return c;
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> a) {
        if (a.size() <= 1) {
            return a;
        } else {
            ArrayList<Integer> b = new ArrayList();
            ArrayList<Integer> c = new ArrayList();

            int i;
            for(i = 0; i < a.size() / 2; ++i) {
                b.add((Integer)a.get(i));
            }

            for(i = a.size() / 2; i < a.size(); ++i) {
                c.add((Integer)a.get(i));
            }

            ArrayList<Integer> d = sort(b);
            ArrayList<Integer> e = sort(c);
            return merge(d, e);
        }
    }

     */
    public static ArrayList<Integer> sort(ArrayList<Integer> a){
        if(a.size() <= 1){
            return a;
        }
        else{
            ArrayList<Integer> b = new ArrayList<>();
            ArrayList<Integer> c = new ArrayList<>();
            for(int i = 0; i < a.size() /2; i ++ ){
                b.add(a.get(i)) ;
            }
            for(int i = a.size() /2; i < a.size() ; i ++ ){
                c.add(a.get(i));
            }
            ArrayList<Integer> d = sort(b);
            ArrayList<Integer> e = sort(c);
            return merge(d,e);
        }
    }
    public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0 ;
        int j = 0;
        while(i < a.size() && j < b.size()){
            if(a.get(i) < b.get(j)){
                res.add(a.get(i));
                i ++;
            }
            else if(a.get(i) > b.get(j)){
                res.add(b.get(j));
                j ++ ;

            }
            else{
                res.add(a.get(i));
                res.add(b.get(j));
                i ++;
                j ++;

            }
        }
        while(i < a.size()){
            res.add(a.get(i));
            i ++;
        }
        while(j < b.size()){
            res.add(b.get(j));
            j ++;
        }
        return res;
    }
    public static void main(String[] args) {
        Random rand = new Random(1L);
        ArrayList<Integer> a = new ArrayList();

        for(int i = 0; i < 10; ++i) {
            a.add(rand.nextInt(100));
        }

        ArrayList<Integer> b = sort(a);
        System.out.println(a);
        System.out.println(b);
    }
}
