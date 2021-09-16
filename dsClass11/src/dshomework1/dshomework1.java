package dshomework1;

public class dshomework1{

    public static void main(String[] args){
        String str = "ABD#E##FG###CH##I##";
        Node root = Node.parse(str);
        System.out.println(Node.pre_order(root));
        System.out.println(Node.in_order(root));
        System.out.println(Node.post_order(root));
        System.out.println(Node.leaf_number(root));
        System.out.println(Node.depth(root));



    }
}