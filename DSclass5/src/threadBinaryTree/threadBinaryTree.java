package threadBinaryTree;
import java.io.File;
import java.util.*;


//线索化二叉树
//也一定是完全二叉树
public class threadBinaryTree {
    public static void main(String[] args) throws Exception{
        File file = new File("src/number_name");
        Scanner scan = new Scanner(file);
        /*heroNode hero1 = new heroNode(1,"tom");
        heroNode hero2 = new heroNode(2,"Jack");
        heroNode hero3 = new heroNode(3,"nancy");
        heroNode hero4 = new heroNode(4,"lalaland");*/
        heroNode[] heros = new heroNode[6];
        for(int i = 0 ; i < 6;i++) {
            String[] temp = scan.nextLine().split(" ");
            System.out.println(temp[0]);
            heros[i] = new heroNode(Integer.parseInt(temp[0]), temp[1]);
        }
        scan.close();
        heros[0].setLeft(heros[1]);
        heros[0].setRight(heros[2]);
        heros[1].setLeft(heros[3]);
        heros[1].setRight(heros[4]);
        heros[2].setLeft(heros[5]);
        Binary binaryHelpertree = new Binary();
        binaryHelpertree.setRoot(heros[0]);
        binaryHelpertree.threadsNodes2(heros[0]);
        binaryHelpertree.threadDisplay();
        //System.out.println(heros[2].left);
    }
}

class Binary{
    public heroNode root;
    public heroNode pre = null;
    public void setRoot(heroNode root){
        this.root = root;
    }
    public void threadDisplay(){
        heroNode node = root;
        while(node!=null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            while ( node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }
    public void threadNodes(heroNode node){
        if(node == null){
            return;
        }
        threadNodes(node.getLeft());
        if(node.getLeft() == null){
            node.setLeft(pre);
            node.setLeft(1);
        }
        if(pre!=null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRight(1); //为什么一定是修改pre的right判别数值？因为是深复制//
            //node.setRight(1);
        }
        pre = node;
        threadNodes(node.getRight());
    }
    public void threadsNodes2(heroNode node){
        if(node == null){
            return;
        }
        if(node.getLeft() == null){
            node.setLeft(pre);
            node.setLeft(1);
        }
        else{
            threadsNodes2(node.left);
        }
        if(node.right!=null && node.getRight() !=null){
            threadsNodes2(node.right);
        }
        if(pre!=null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRight(1); //为什么一定是修改pre的right判别数值？因为是深复制//
            //node.setRight(1);
        }
        pre = node;




    }
    public void preOrder(){
        if(this.root!=null){
            this.root.preNode();
        }
        else{
            System.out.println("空");
        }
    }
    public void infixOrder(){
        if(this.root!=null){
            this.root.midNode();
        }
        else{
            System.out.println("空");
        }
    }
    public void postOrder(){
        if(this.root!=null){
            this.root.postNode();
        }
        else{
            System.out.println("空");
        }
    }
    public void delNode(int number){
        if(root == null)
            System.out.println("空树，无法删除");
        if(root.getNo() == number){
            root = null;
        }
        else{
            root.delNode(number);
        }
    }
}
class heroNode {
    public int no;
    public String name;
    public heroNode left;
    public heroNode right;
    public int leftType ;
    public int rightType ;

    public heroNode getLeft(){
        return left;
    }
    public heroNode getRight(){
        return right;
    }
    public int getLeftType(){
        return this.leftType;
    }
    public int getRightType(){
        return this.rightType;
    }
    public void setLeft(int left) {
        this.leftType = left;
    }
    public void setRight(int right){
        this.rightType = right;
    }

    public heroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name1) {
        this.name = name1;
    }

    public void setNo(int number) {
        this.no = number;

    }

    public void setLeft(heroNode left1) {
        this.left = left1;
    }

    public void setRight(heroNode right1) {
        this.right = right1;
    }

    public void preNode() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preNode();
        }
        if (this.right != null) {
            this.right.preNode();
        }
    }

    public void midNode() {
        if (this.left != null) {
            this.left.midNode();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midNode();
        }
    }

    public void postNode() {
        if (this.right != null) {
            this.right.postNode();
        }
        if (this.left != null) {
            this.left.postNode();
        }
        System.out.println(this);
    }

    public heroNode preOrderSearch(int number) {
        if (this.no == number) {
            return this;
        }
        heroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(number);
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(number);
        }
        return resNode;
    }

    public heroNode postOrderSearch(int number) {
        heroNode resNode = null;
        if (this.right != null) {
            resNode = this.right.postOrderSearch(number);
        }
        if (resNode != null)
            return resNode;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(number);
        }
        if (resNode != null)
            return resNode;   //使用这种方式的时候一定要先检查上一次递归是否找到了结果，找到了就要赶快返回//
        if (this.no == number) {
            return this; //注意这里很重要
        }
        return resNode;
    }

    public void delNode(int number) {
        if (this.left != null && this.left.no == number) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == number) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(number);
        }
        if (this.right != null) {
            this.right.delNode(number);
        }
    }
    @Override
    public String toString(){
        return "[Name = " + this.name + " , "+ "no = "+ this.no + "].";
    }
}
