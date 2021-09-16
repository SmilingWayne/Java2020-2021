package AVLtree;
import java.util.*;

/**
 * 经典AVL树？
 */
public class avltree {
    public static void main(String[] args){
        AVL tree = new AVL();
        int[] naga = {4,3,5,6,7,8};
        for(int i = 0 ; i < 6; i++){
            Node node = new Node(naga[i]);
            tree.add(node);
        }
        System.out.println(tree.getRoot().leftHeight());
        System.out.println(tree.getRoot().rightHeight());
    }
}
class AVL{
    public Node root;
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }
    public Node getRoot(){
        return root;
    }
    public void infix_Order(){
        if(root != null){
            root.infixOrder();
        }
        else{
            System.out.println("No");
        }
    }



    public Node getTarget(int val){
        if(root == null){
            return null;
        }
        else{
            return root.search(val);
        }
    }
    public Node getParentNode(int val){
        if(root == null){
            return null;
        }
        else{
            return root.searchParent(val);
        }
    }
    public int delRightNumber(Node node){
        Node temp = node;
        if(node == null){

        }
        while(temp.left != null){
            temp = temp.left;
        }
        int res = temp.val;
        delete_Val(res);
        return res;
    }
    public void delete_Val(int val){
        Node parentNode = getParentNode(val);
        Node targetNode = getTarget(val);

        if(targetNode.left == null && targetNode.right == null){
            if(parentNode!=null && parentNode.left!=null && parentNode.left == targetNode ){
                parentNode.left = null;
            }
            else if(parentNode != null && parentNode.right != null && parentNode.right == targetNode){
                parentNode.right = null;
            }
        }
        else if(targetNode.left != null && targetNode.right != null){
            int min = delRightNumber(targetNode.right);
            targetNode.val = min;
        }
        else{
            if(targetNode.left == null){
                if(parentNode.right == targetNode){
                    parentNode.right = targetNode.right;
                }
                else if(parentNode.left == targetNode){
                    parentNode.left = targetNode.right;
                }
            }
            if(targetNode.right == null){
                if(parentNode.right == targetNode){
                    parentNode.right = targetNode.left;

                }
                else if(parentNode.left == targetNode){
                    parentNode.left = targetNode.left;
                }
            }
        }

    }


}
class Node {
    int val;
    Node left;
    Node right;
    public int getHeight(){
        return Math.max(this.left == null ? 0:this.left.getHeight(), this.right == null ? 0:this.right.getHeight()) + 1;

    }
    public int leftHeight(){
        if(this.left == null){
            return 0;
        }
        else{
            return left.getHeight();
        }
    }

    //left rotate, first NewNode, then right.left....
    //calm down
    public void rotateLeft(){
        Node newNode = new Node(val);
        newNode.left = this.left;
        newNode.right = this.right.left;
        this.val = this.right.val;
        this.right = this.right.right;
        this.left = newNode;

    }
    public void rotateRight(){
        Node newNode = new Node(val);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.val = this.left.val;
        this.left = this.left.left;
        this.right = newNode;
    }
    public int rightHeight(){
        if(this.right == null){
            return 0;
        }
        else{
            return right.getHeight();
        }
    }

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.val < this.val) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }

        } else {
            if (this.val < node.val) {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.add(node);
                }
            }
        }
        if(right != null && rightHeight() - leftHeight() > 1){
            if(right != null && right.rightHeight() < right.leftHeight()){
                right.right.rotateLeft();
            }
            rotateLeft();
        }
        else if(left != null && leftHeight() - rightHeight() > 1){
            if(left != null && left.rightHeight() > left.leftHeight()){
                left.left.rotateRight();
            }
            rotateRight();
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this.val);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public Node searchParent(int value) {
        //because we need parentRoot and targetRoot for Situation3
        if (this.left != null && this.left.val == value || this.right != null && this.right.val == value) {
            return this;
        } else if (this.val > value && this.left != null) {
            return this.left.searchParent(value);
        } else if (this.val < value && this.right != null) {
            return this.right.searchParent(value);
        } else {
            return null;
        }
    }

    public Node search(int value) {
        if (this.val == value) {
            return this;
        }
        if (val < value) {
            if (this.right != null) {
                return this.right.search(value);
            }
        } else if (val > value) {
            if (this.left != null) {
                return this.left.search(value);
            }
        }

        return null;

    }
}
