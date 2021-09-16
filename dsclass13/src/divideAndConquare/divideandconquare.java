package divideAndConquare;
import java.util.*;
public class divideandconquare {
    public static void main(String[] args) {

    }
    public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> c = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < a.size() || j < b.size()){
            if(a.get(i) < b.get(j)){
                c.add(a.get(i));
                i++;
            }
            else if(a.get(i) > b.get(j)){
                c.add(b.get(j));
                j ++;
            }
            else{
                c.add(a.get(i));
                c.add(b.get(j));
                i ++;
                j ++;
            }
        }
        while(i < a.size()){
            c.add(a.get(i));
            i ++;
        }
        while( j < b.size()){
            c.add(b.get(j));
            j ++ ;
        }
        return c;
    }
    public static ArrayList<Integer> sort(ArrayList<Integer> a){
        if(a.size() <=1){
            return a;
        }
        else{
            ArrayList<Integer> b = new ArrayList<>();
            ArrayList<Integer> c = new ArrayList<>();
            for(int i = 0 ; i < a.size() /2 ; i ++ ){
                b.add(a.get(i));
            }
            for(int i = a.size()/2 ; i < a.size(); i ++ ){
                c.add(b.get(i));
            }
            ArrayList<Integer> d = sort(b);
            ArrayList<Integer> e = sort(c);
            return merge(d,e);

        }
    }
}
