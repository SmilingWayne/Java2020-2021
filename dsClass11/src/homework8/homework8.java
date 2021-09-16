package homework8;
import java.util.*;
public class homework8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        String s2 = scan.next();
        int length = s1.length();
        int i = 0;
        int compare = 0;
        while(i < length){
            String preString = "";
            String infixString = "";
            for(int j = i ; j < length; j ++ ){
                if(s2.charAt(j) == s1.charAt(i)){
                    preString = s1.substring(i,j + 1);
                    infixString = s2.substring(i, j + 1);
                    i = j + 1;
                    //System.out.println(preString);
                    //System.out.println(infixString);
                    break;
                }
            }
            Node ass1 = recover(preString,infixString);
            int ans = depth(ass1);
            compare = Math.max(compare,ans);
        }
        System.out.println(compare);

    }

    public static Node recover(String pre_order, String in_order) {
        if(pre_order.length() == 0 || in_order.length() == 0){
            return null;
        }
        Node helper = new Node();
        helper.data = pre_order.substring(0,1);
        for(int i = 0 ; i < pre_order.length(); i ++){
            if(pre_order.substring(0,1).equals(in_order.substring(i,i+1))){
                if(pre_order.length() > 1){
                    for(int j = 0 ; j < pre_order.length(); j ++ ){
                        if(pre_order.substring(1,2).equals(in_order.substring(j, j + 1))){
                            helper.lchild = recover(pre_order.substring(1,j + 2),in_order.substring(0,j + 1));
                            helper.rchild = recover(pre_order.substring(j + 2),in_order.substring(j + 1,in_order.length() -1));
                        }
                    }
                }
                else {
                    return helper;
                }
            }
        }
        return helper;

    }
    public static int depth(Node node){
        if(node == null){
            return 0;
        }
        else{
            return Math.max(depth(node.lchild), depth(node.rchild)) + 1;
        }
    }

}
class Node{
    public String data ;
    public Node lchild;
    public Node rchild;

}
