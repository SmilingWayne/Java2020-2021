package homework;
import java.util.*;
public class homework29 {
    /*载入数据的问题已解决
    Solved
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String t = scan.nextLine();
        String[] s1 = s.split(" ");
        String[] t1 = t.split(" ");
        LiNode arr1 = new LiNode();
        LiNode arr2 = new LiNode();
        LiNode help1 = new LiNode();
        LiNode help2 = new LiNode();
        for(int i = 0 ; i < s1.length; i += 2 ){
            arr1.coefficient = Integer.parseInt(s1[i]);
            arr1.index = Integer.parseInt(s1[i + 1]);
            if(i == 0){
                help1 = arr1;
            }
            if( i + 2 >= s1.length){
                arr1.next = null;
                break;
            }
            else {
                arr1.next = new LiNode();
                arr1 = arr1.next;
            }
        }
        for(int j = 0; j < t1.length ; j += 2){
            arr2.coefficient = Integer.parseInt(t1[j]);
            arr2.index = Integer.parseInt(t1[j + 1]);
            if(j == 0){
                help2 = arr2;
            }
            if(j + 2 >= t1.length){
                arr2.next = null;
                break;
            }
            else {
                arr2.next = new LiNode();
                arr2 = arr2.next;
            }
        }
        //LiNode k = plus(help1, help2);
        /*while(k!=null){
            if(k.coefficient != 0) {
                System.out.print(k.coefficient + " " + k.index + " ");
            }
            k = k.next;
        }

         */
        LiNode k2 = multiple(help1, help2);
        while(k2 != null){
            if(k2.coefficient != 0) {
                System.out.print(k2.coefficient + " " + k2.index + " ");
            }
            k2 = k2.next;
        }
    }
    public static LiNode multiple(LiNode a, LiNode b){
        LiNode help1 = a;
        LiNode help2 = b;
        LiNode c = new LiNode();
        c.index = 0;
        c.coefficient = 0;
        LiNode ans = new LiNode();
        while(help1 != null){
            while(c.index != help1.index){
                c = c.next;
            }
            while(help2 != null){
                c.coefficient += ( help1.coefficient * help2.coefficient );
                c.index = help1.index + help2.index;
                if(c.index == 0){
                    ans = c;
                }
                c.next = new LiNode();
                c = c.next;
                help2 = help2.next;
            }
            help1 = help1.next;
            help2 = b;
            c = ans;
        }
        return ans;
    }
    public static LiNode plus(LiNode a , LiNode b){
        LiNode c = new LiNode();
        LiNode a1 = a;
        LiNode b1 = b;
        LiNode ans = new LiNode();
        while(a1 != null && b1 != null){
            c.coefficient = a1.coefficient + b1.coefficient;
            c.index = a1.index;
            //System.out.println(c.coefficient + "::" + c.index);
            if(a1.index == 0){
                ans = c;
            }
            c.next = new LiNode();
            c = c.next;
            a1 = a1.next;
            b1 = b1.next;
        }
        while(a1 != null){
            c.coefficient = a1.coefficient;
            c.index = a1.index;
            c.next = new LiNode();
            c = c.next;
            a = a1.next;
        }
        while(b1 != null){
            c.coefficient = b1.coefficient;
            c.index = b1.index;
            c.next = new LiNode();
            c = c.next;
            b1 = b1.next;
        }
        return ans;
    }
    public static LiNode getMid(LiNode a){
        if(a.next == null){
            return a;
        }
        if(a.next.next == null){
            return a.next;
        }
        else{
            LiNode fast = a;
            LiNode slow = a;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

    }
}
class LiNode{
    public int coefficient;
    public int index;
    public LiNode next;
}
