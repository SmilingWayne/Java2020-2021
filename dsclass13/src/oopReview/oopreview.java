package oopReview;

import java.io.File;
import java.util.*;
public class oopreview {
    public static void main(String[] args) {
        /*
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 10; i ++ ){
            list.add(i);
        }
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        Vector<Integer> vector = new Vector<>();
         */
        File file = new File("src/oopReview/data");
        try {
            Scanner scan = new Scanner(file);
            int a = scan.nextInt();

            PriorityQueue<String> pq = new PriorityQueue<>();
            for(int i = 0 ; i < a; i ++ ){
                pq.add(scan.next());
            }

            for(int i = 0; i < a ; i ++ ){
                System.out.println(pq.poll());
            }

        }catch(Exception x ){
            System.out.println("wrong!");
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(3);
        set.add(5);
        set.add(5);
        System.out.println(set.contains(5));
        ArrayList<Integer> y = new ArrayList<>();
        ArrayList<Integer> xx = new ArrayList<>();
        xx.addAll(0,y);
        for(Integer x : xx){
            System.out.println(x + "hahah");
        }
        y.add(5);
        y.add(8);
        y.set(1,6);//这里的1是从0开始编号的顺序//
        //y.remove(1);
        for(int i = 0 ; i < 2; i ++ ){
            System.out.println(y.get(i));
        }

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i = 8; i > 0; i-- ){
            ad.add(i);
        }

        for(int i = 0 ; i < 8; i ++ ){
            System.out.println(ad.getFirst());
            ad.remove();
        }/*
        for(int i = 0; i < 10; i ++ ){
            System.out.println("");
        }
        */
        vehicle audi = new vehicle("audi",42,198000);
        audi.setName("audi4");
        System.out.println(audi.sayHello());
        System.out.println(audi.getname());
        car A = audi;
        System.out.println(A.name);
        System.out.println(audi instanceof car);
        //判断是否是子类//
        //nested class 嵌套类//

        Random r = new Random(1);
        int[][] board = new int[10][2];
        for(int i = 0; i < 10; i ++ ){
            board[i][0] = r.nextInt(20);
            board[i][1] = r.nextInt(30);
        }
        for(int[] a:board){
            System.out.println(a[0] + " : " + a[1]);
        }
        /*
        Arrays.sort(board, (o1, o2) ->{
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            else{
                return o1[0] - o2[0];
            }
        });
         */
        Arrays.sort(board, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                else{
                    return o1[0] - o2[0];
                }
            }
        });
        /*for(int i =0 ; i < 10; i ++ ){
            System.out.println(board[i][0] + ", " + board[i][1] +"!");
        }

         */
        A.sayNihao();


    }
}

interface hello{
    public String nana = "hello";
    public void sayNihao();
}
class car implements hello{
    public String name;
    public int numbers;
    private String haha;
    public car(String name, int numbers){
        this.name = name;
        this.numbers = numbers;
    }
    public void sayNihao(){
        System.out.println(this.name + " what!");
    }
    public String sayHello(){
        return name + " hello";
    }
    public void happy(){

    }
    class inner{
        private String name;
        public inner(){
            this.name = car.this.name + " I am outer!";
        }
        public void printname(){
            System.out.println(name);
            System.out.println(car.this.name);
        }
    }
    MyPrinter mp = (s) -> System.out.println(s);

}
interface MyPrinter{
    public void print(String s);
}
enum COLOR{
    YELLOW (1),
    BLACK (2);
    public int level;
    COLOR(int level){
        this.level = level;
    }
}
class vehicle extends car{
    protected int price;
    public vehicle(String names, int numbers ,int price){
        super(names, numbers);
        this.price = price;
    }
    //子类必须super超类！！！Constructors are not inherited by subclasses, but a subclass constructor must call a
    // constructor in the superclass.
    public String getname(){
        return "the name is " + name;
    }
    public void setName(String a){
        this.name = a;
    }
    public String sayHello(){
        return name + " not ok!";
    }
    /*
    public String gethaha(){
        return haha;
    }

     */
    /*
    In Java you cannot override private methods from a superclass. If the superclass calls a private method internally
    from some other method, it will continue to call that
     method from the superclass, even if you create a private method in the subclass with the same signature
     */


}

