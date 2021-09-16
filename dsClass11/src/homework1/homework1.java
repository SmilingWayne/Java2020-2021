package homework1;
import java.util.*;
public class homework1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String target = scan.next();
        scan.close();
        Node root = new Node();
        root = Node.parse(target);
        System.out.println(Node.in_order(root));
        System.out.println(Node.post_order(root));
        System.out.println(Node.level_order(root));
        System.out.println(Node.depth(root));
        System.out.println(Node.leaf_number(root));
    }

    public static class Node {
        public String data;
        public Node lchild;
        public Node rchild;
        private static Node parse(String s, int[] count){
            if(s.charAt(count[0]) == '#'){
                count[0] ++;
                return null;
            }
            else{
                Node node = new Node();
                node.data = s.substring(count[0], count[0] + 1);
                count[0] ++ ;
                node.lchild = parse(s, count);
                node.rchild = parse(s, count);
                return node;
            }
        }
        public static Node parse(String s){
            return parse(s,new int[1]);
        }
        public static String pre_order(Node node){
            if(node == null){
                return "";
            }
            else{
                String str = "";
                str += node.data;
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
                String str = "";

                str += in_order(node.lchild);
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
                String str = "";

                str += post_order(node.lchild);
                str += post_order(node.rchild);
                str += node.data;
                return str;
            }
        }
        public static String level_order(Node node){
            Queue<Node> queue= new LinkedList<>();
            String str = "";
            queue.add(node);
            if(node == null){
                return "";
            }
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0 ; i < size; i ++){
                    Node helper = queue.poll();
                    if(helper.lchild != null){
                        queue.add(helper.lchild);
                    }
                    if(helper.rchild != null){
                        queue.add(helper.rchild);
                    }

                    str = str + helper.data;
                }
            }
            return str;
        }
        public static int leaf_number(Node node){
            if(node == null){
                return 0;
            }
            else if(node.lchild == null && node.rchild == null){
                return 1;
            }
            else{
                return leaf_number(node.lchild) + leaf_number(node.rchild);
            }
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
}
