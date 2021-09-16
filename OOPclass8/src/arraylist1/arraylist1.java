package arraylist1;

import java.util.*;

public class arraylist1 {
    /*
    arraylist用于查询操作，少用于插入删除
     */
    public static void main(String[] args){
        int n = 100000;
        ArrayList<Integer> arr1 = new ArrayList<>();
        LinkedList<Integer> lin1 = new LinkedList<>();

        student stu1 = new student(12,"2121",100);

        student stu2 = new student(13,"3121",83);

        ArrayList<student> arr2 = new ArrayList<student>();

        Random rand = new Random(1L);
        for(int j = 0; j < 10;j++){
            int u = rand.nextInt(101);
            student pu = new student(j + 1,100 + j + "",u);
            arr2.add(pu);
        }

        Collections.sort(arr2,(i,j)->{
            return j.score - i.score;
        });

        for(int i = 0; i <arr2.size(); ++i) {
            student k = arr2.get(i);

            System.out.println(k.number + " " + k.no + " " + k.score);
        }

        HashMap<student,Integer> map2 = new HashMap<student,Integer>();

        map2.put(stu1,90);

        map2.put(stu2,100);

        for(Map.Entry<student,Integer> entry :map2.entrySet()){
            student key = entry.getKey();
            Integer credit = entry.getValue();
            System.out.println(key.number + " " + key.no + " " + credit );
        }

        HashSet<Integer> hash = new HashSet<>();//只会出现一次//

        HashMap<String,String> map = new HashMap<>();

        map.put("1","abcdsds");

        map.put("a","A");

        map.put("1","W");
        /*
        key is only;
         */
        for(String s : map.keySet()){
            System.out.println(s);
        }
        for(String b: map.values()){
            System.out.println(b);
        }
        for(Map.Entry<String,String> entry :map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue() );
        }
        System.out.println(map.get("1"));
        System.out.println(map.containsKey("1"));
        System.out.println(map.containsValue("W"));
        for(int i = 0 ; i < n; i++){
            arr1.add(0,i);
            if(arr1.contains(i) == false){
                arr1.add(i);
            }
        }

        for(int i = 0; i < n; i++){
            lin1.add(0,i);
        }
        double t1 = System.nanoTime();
        while(arr1.isEmpty() == false){
            arr1.remove(arr1.size() - 1);
        }
        double t2 = System.nanoTime();
        while(lin1.isEmpty() == false){
            lin1.remove(lin1.size() -1);
        }

        double t3 = System.nanoTime();
        System.out.println("arr1 : " + (t2 - t1)/1e9);
        System.out.println("lin1 : " + (t3 - t2)/1e9);
    }
}
