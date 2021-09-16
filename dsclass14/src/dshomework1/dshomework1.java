package dshomework1;
import java.util.*;
public class dshomework1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        String[] operator = new String[total];
        int[] operatNumber = new int[total];
        for(int i = 0; i < total; i ++ ){
            operator[i] = scan.next();
            operatNumber[i] = scan.nextInt();
        }

        scan.close();

        BinarySortTree Tree = new BinarySortTree();
        for(int i = 0; i < total; i ++ ){
            if(operator[i].equals("I")){
                Tree.insert(operatNumber[i]);
            }
            else if(operator[i].equals("D")){
                Tree.delete(operatNumber[i]);
            }
        }
        System.out.println(Tree.pre_Order());
        System.out.println(Tree.in_Order());

    }

}
class BinarySortTree{
    public Node root;
    public String pre_Order(){
        return pre_Order(root);
    }
    public String in_Order(){
        return in_Order(root);
    }
    public void delete(int data){
        if(root == null){
            return;
        }
        Node[] nodes = new Node[2];
        boolean exist = search(data, root, null, nodes);
        if(!exist){
            return;
        }
        if(nodes[0].lchild != null && nodes[0].rchild != null){
            Node p = nodes[0].lchild;
            Node q = nodes[0];
            while(p.rchild != null){
                q = p;
                p = p.rchild;
            }

            nodes[0].data = p.data;
            nodes[0] = p;
            nodes[1] = q;

        }


        if(nodes[0].lchild == null){
            if(nodes[1] == null){
                root = nodes[0].rchild;
            }
            else{
                if(nodes[1].rchild == nodes[0]){
                    nodes[1].rchild = nodes[0].rchild;
                }
                else {
                    nodes[1].lchild = nodes[0].rchild;
                }
            }
        }
        else if(nodes[0].rchild == null){
            if(nodes[1] == null){
                root = nodes[0].lchild;
            }
            else{
                if(nodes[1].rchild == nodes[0]){
                    nodes[1].rchild = nodes[0].lchild;
                }
                else{
                    nodes[1].lchild = nodes[0].lchild;
                }
            }
        }
    }
    public void insert(int data){
        if(root == null){
            root = new Node();
            root.data = data;
            root.rchild = null;
            root.lchild = null;
        }
        else{
            Node[] nodes = new Node[2];
            boolean flag = search(data, root, null, nodes );
            if(flag){
                return;
            }
            else{
                Node addNode = new Node();
                addNode.data = data ;
                addNode.rchild = null;
                addNode.lchild = null;
                if(nodes[1].data > data){
                    nodes[1].lchild = addNode;
                }
                else{
                    nodes[1].rchild = addNode;
                }
            }
        }
    }
    public Node search(int data){
        Node[] nodes = new Node[2];
        boolean flag = search(data, root, null, nodes );
        if(flag){
            return nodes[0];
        }
        else{
            return null;
        }
    }
    public boolean search(int data, Node node, Node parent , Node[] nodes ){
        if(node == null){
            nodes[0] = null;
            nodes[1] = parent;
            return false;
        }
        else{
            if(node.data == data){
                nodes[0] = node;
                nodes[1] = parent;
                return true;
            }
            else if( data < node.data){
                return search(data, node.lchild, node, nodes);
            }
            else{
                return search(data, node.rchild , node , nodes);
            }
        }
    }
    public String in_Order(Node node){
        if(node == null){
            return "";
        }
        else{
            String ans = in_Order(node.lchild) + "";
            ans += node.data + " ";
            ans += in_Order(node.rchild);
            return ans;
        }

    }
    public String pre_Order(Node node){
        if(node == null){
            return "";
        }
        else{
            String ans = node.data + " ";
            ans += pre_Order(node.lchild);
            ans += pre_Order(node.rchild);
            return ans;
        }

    }
}
class Node{
    public int data;
    public Node lchild;
    public Node rchild;
}
