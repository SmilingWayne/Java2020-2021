package divideandc2;

import java.util.*;

public class divideandc2 {
    public static void main(String[] args) {
        String a = "2+1+1";
        System.out.println(partition(a));
    }
    public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b, char opt){
        ArrayList<Integer> c = new ArrayList<Integer>();
        for(int i = 0 ; i < a.size(); i ++ ){
            for(int j = 0 ; j < b.size(); j ++ ){
                if(opt == '+'){
                    c.add(a.get(i) + b.get(j));
                }
                else if(opt == '-'){
                    c.add(a.get(i) - b.get(j));
                }
                else if(opt == '*'){
                    c.add(a.get(i)*b.get(j));
                }

            }
        }
        return c;
    }
    public static ArrayList<Integer> partition(String a){
        ArrayList<Integer> ret = new ArrayList<>();

        boolean is_opt = false;

        for(int i = 0; i < a.length(); i ++){
            String b = a.substring(i ,i + 1);
            if(b.equals("+") || b.equals("-") || b.equals("*")){
                is_opt = true;
                String c = a.substring(0, i );
                String d = a.substring(i + 1);
                ArrayList<Integer> ret1 = partition(c);
                ArrayList<Integer> ret2 = partition(d);
                ArrayList<Integer> ret3 = merge(ret1, ret2, b.charAt(0));
                for(int j = 0 ; j < ret3.size(); j ++ ){
                    if(!ret.contains(ret3.get(j))){
                        ret.add(ret3.get(j));
                    }
                }
            }

        }
        if(!is_opt){
            ret.add(Integer.parseInt(a));
        }
        return ret;
    }
}
