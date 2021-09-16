package BST;
//终于实现啦！！！
public class bst {
    public static void main(String[] args){

        binarySortTree tree = new binarySortTree();
        int[] naga = {5,2,3,1,7,9,12};
        for(int i = 0 ; i < 7; i++){
            Node node = new Node(naga[i]);
            tree.add(node);
        }
        tree.delete_Val(2);
        tree.infix_Order();

    }
}
class binarySortTree{
    public Node root;
    public void add(Node node){
        if(root == null){
            root = node;
        }
        else{
            root.add(node);
        }
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
class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
    public void add(Node node){
        if(node == null){
            return;
        }
        if(node.val < this.val ){
            if(this.left == null){
                this.left = node;
            }
            else{
                this.left.add(node);
            }

        }
        else{
            if(this.val < node.val){
                if(this.right == null){
                    this.right = node;
                }
                else{
                    this.right.add(node);
                }
            }
        }
    }
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this.val);
        if(this.right != null){
            this.right.infixOrder();
        }
    }
    public Node searchParent(int value){
        //because we need parentRoot and targetRoot for Situation3
        if(this.left != null && this.left.val == value || this.right != null && this.right.val == value){
            return this;
        }
        else if(this.val > value && this.left != null){
            return this.left.searchParent(value);
        }
        else if(this.val < value && this.right != null){
            return this.right.searchParent(value);
        }
        else{
            return null;
        }
    }
    public Node search(int value){
        if(this.val == value){
            return this;
        }
        if(val < value){
            if(this.right != null) {
                return this.right.search(value);
            }
        }
        else if(val > value){
            if(this.left != null) {
                return this.left.search(value);
            }
        }

        return null;

    }

}