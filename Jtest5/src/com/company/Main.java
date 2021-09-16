package com.company;
import java.util.Vector;
public class Main {

    public static void main(String[] args) {
        Vector<String> victor=new Vector<String>();
        Vector<String> victoria=new Vector<String>(300);
        victoria.add("Vance");
        victoria.add("Vernon");
        victoria.add("Velma");
        String name=victoria.get(1);//在Vector中检索元素//
        if(victoria.contains("Velma")){
            System.out.println("Velma Found");
        }
        else{
            System.out.println("Velma not Found!");
        }
        victoria.remove(0);
        victoria.remove("Vernon");
        victoria.add("Nancy");
        victoria.add("David");
        for(String names:victoria){
            System.out.println(names);
        }
        StringLister lister=new StringLister(args);




    }
}
