
import java.util.*;
public class dchomework1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < total; i ++ ){
            arr.add(scan.nextInt());
        }
        scan.close();
        helper o = new helper(arr, 0);
        o.sort(arr);
        o.display();
    }
}
class helper{
    public ArrayList<Integer> a;
    public int count ;
    public helper(ArrayList<Integer> x, int m){
        this.a = x;
        this.count = m;
    }
    public ArrayList<Integer> partitation(ArrayList<Integer> arr1, ArrayList<Integer> arr2 ){
        int i = 0;
        int j = 0;
        ArrayList<Integer> arr3 = new ArrayList<>();
        while(i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) < arr2.get(j)){
                arr3.add(arr1.get(i));
                i ++;
            }
            else if(arr1.get(i) > arr2.get(j)){

                arr3.add(arr2.get(j));
                j ++;
                this.count += arr1.size() - i;
            }
            else{
                arr3.add(arr1.get(j));
                arr3.add(arr2.get(i));
                i ++;
                j ++;
            }
        }
        while(i < arr1.size()){
            arr3.add(arr1.get(i));
            i ++;
        }
        while(j < arr2.size()){
            arr3.add(arr2.get(j));
            j ++;
        }
        return arr3;

    }
    public ArrayList<Integer> sort(ArrayList<Integer> a2){
        if(a2.size() <= 1){
            return a2;
        }
        else{
            ArrayList<Integer> b = new ArrayList<Integer>();
            ArrayList<Integer> c = new ArrayList<Integer>();
            for(int i = 0; i < a2.size() / 2; i++){
                b.add(a2.get(i));
            }
            for(int i = a2.size() / 2; i < a2.size(); i++){
                c.add(a2.get(i));
            }
            ArrayList<Integer> d = sort(b);
            ArrayList<Integer> e = sort(c);
            return partitation(d, e);
        }
    }
    public void display(){
        System.out.println(count);
    }

}
