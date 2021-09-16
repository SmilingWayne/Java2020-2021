package binarysortTree;
//二叉排序树的建立
public class binarysorttree {
    public static void main(String[] args){
        int[] arr = {7,3,10,13,5,1,9,2};
        BinaryTree bt = new BinaryTree();
        for(int i = 0; i < arr.length; i++){
            bt.add(new Node(arr[i]));
        }
        bt.infixOrder();
    }
}
class BinaryTree{
    private Node root;
    public void add(Node node){
        if(root == null){
            root = node;
        }
        else{
            root.add(node);
        }
    }
    public void infixOrder(){
        if(root!=null){
            root.infixOrder();
        }
        else{
            System.out.println("无法进行");
        }
    }
}
class Node{
    int value;
    Node left;
    Node right;
    @Override
    public String toString(){
        return "Node : [value = " + value + "].";
    }
    public Node(int value){
        this.value = value;

    }
    public void add(Node node){
        if(node == null){
            return;
        }
        else{
            if(node.value < this.value){
                if(this.left == null){
                    this.left = node;
                }
                else if(this.left!= null) {
                    this.left.add(node);
                }
            }
            if(node.value > this.value){
                if(this.right == null){
                    this.right = node;
                }
                else if(this.right!=null){
                    this.right.add(node);
                }
            }
        }
    }
    public void infixOrder(){
        if(this.left!= null){
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

}