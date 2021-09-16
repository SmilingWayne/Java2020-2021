package dshomework1;

import java.util.*;

public class Node{

    public String data;

    public Node lchild;

    public Node rchild;


    private static Node parse(String str, int[] count){
        if(str.charAt(count[0]) == '#'){
            count[0] ++;
            return null;
        }
        else{
            Node node = new Node();
            node.data = str.substring(count[0], count[0] + 1);
            count[0] ++;
            node.lchild = parse(str, count);
            node.rchild = parse(str, count);
            return node;
        }
    }

    public static Node parse(String str){
        return parse(str, new int[1]);
    }

    public static String pre_order(Node node){
        if(node == null){
            return "";
        }
        else{
            String str = node.data;
            str += pre_order(node.lchild);
            str += pre_order(node.rchild);
            return str;
        }
    }

    public static String in_order(Node node){
        if(node == null){
            return "";
        }
        else{
            String str = in_order(node.lchild);
            str += node.data;
            str += in_order(node.rchild);
            return str;
        }
    }


    public static String post_order(Node node){
        if(node == null){
            return "";
        }
        else{
            String str = post_order(node.lchild);
            str += post_order(node.rchild);
            str += node.data;
            return str;
        }
    }

    public static int leaf_number(Node node){
        if(node == null){
            return 0;
        }
        if(node.lchild == null && node.rchild == null){
            return 1;
        }
        else {
            return leaf_number(node.lchild) + leaf_number(node.rchild);
        }
    }
    public static int depth(Node node){
        if(node == null){
            return 0;
        }
        else{
            return Math.max(depth(node.rchild),depth(node.lchild))  + 1;
        }
    }
    public static String in_order2(Node node){
        Stack<Node> stack = new Stack<>();
        String str = "";
        Node p = node;
        while(p != null && stack.isEmpty() == false){
            if(p != null){
                stack.push(p);
                p = p.lchild;
            }
            else if(stack.isEmpty() == false){
                p = stack.pop();
                str += p.data + "";
                p = p.rchild;
            }
        }
        return str;
    }

}