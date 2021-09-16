package dsclass1;

public class binarySOrtTree {
    public Node root = null;
    public static boolean insert(int data, String key, Node root){
        if(root == null){
            root = new Node();
            root.data = data;
            root.key = key;
            root.left = null;
            root.right = null;
            return true;
        }
        else{
            Node[] nodes = new Node[2];
            boolean flag = search(data , root, null, nodes);
            if(flag){
                return false;
            }
            else{
                Node helper = new Node();
                helper.data = data;
                helper.key = key;
                helper.left = null;
                helper.right = null;
                if(nodes[1].data > helper.data ){
                    nodes[1].left = helper;
                }
                else{
                    nodes[1].right = helper;
                }
                return true;
            }

        }
    }
    public static Node searchTree(Node node, int key){
        Node[] ret = new Node[2];
        boolean flag = search(key, node, null, ret);
        if(flag){
            return ret[0];
        }
        else{
            return null;
        }
    }
    public static boolean search(int data, Node node, Node parent, Node[] ret){
        if(node == null){
            ret[0] = null;
            ret[1] = parent;
            return false;
        }
        else if(node.data == data){
            ret[0] = node;
            ret[1] = parent;
            return true;
        }
        else if(node.data < data){
            return search(data, node.right, node, ret);
        }
        else {
            return search(data, node.left, node, ret);
        }
    }
}
