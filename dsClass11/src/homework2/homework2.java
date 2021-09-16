package homework2;
import homework1.homework1;

import java.util.*;
public class homework2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pre_order = scan.next();
        String post_order = scan.next();
        scan.close();
        int start = 0;
        boolean[] judge = new boolean[pre_order.length()];
        Arrays.fill(judge,true);
        Node ans = Node.recover(pre_order,post_order);
        Queue<Node> queue = new LinkedList<>();
        boolean[] confirm = new boolean[post_order.length()];
        Arrays.fill(confirm,false);

        System.out.println(Node.post_Order(ans));
        //System.out.println(depth(ans));
        if(isCBT(ans) == true){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
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
    public static boolean isCBT(Node node){
        if(node == null){
            return true;
        }
        else{
            Queue<Node> queue = new LinkedList<>();
            Node l = null;
            Node r = null;
            boolean leaf = false;
            queue.offer(node);
            while(queue.size() != 0 ){

                Node helper = queue.poll();
                l = helper.lchild;
                r = helper.rchild;
                if(leaf && ( l != null || r != null) || (r != null && l == null)){
                    return false;
                }
                if(l != null){
                    queue.offer(l);
                }
                if(r != null){
                    queue.offer(r);
                }
                else{
                    leaf = true;
                }
            }
            return true;
        }
    }
    public static class Node{
        public String data;
        public Node lchild;
        public Node rchild;
        public static String post_Order(Node node){
            String str = "";
            if(node == null){
                return "";
            }
            else{
                if(node.lchild != null){
                    str += post_Order(node.lchild);
                }
                if(node.rchild != null){
                    str += post_Order(node.rchild);
                }
                str += node.data;
            }
            return str;
        }
        public static Node recover(String pre_order, String in_order) {
            if(pre_order.length() == 0 || in_order.length() == 0){
                return null;
            }
            Node helper = new Node();
            helper.data = pre_order.substring(0,1);
            for(int i = 0 ; i < pre_order.length(); i ++){
                if(pre_order.substring(0,1).equals(in_order.substring(i,i+1))){
                    helper.lchild = recover(pre_order.substring(1,i + 1),in_order.substring(0,i));
                    helper.rchild = recover(pre_order.substring(i + 1, pre_order.length()),in_order.substring(i + 1,pre_order.length()));
                }
            }
            return helper;

        }

    }
}