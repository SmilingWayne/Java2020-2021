package homework3;
import java.util.*;
public class homework3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Forest forest = new Forest();
        String total = scan.next();
        forest.length = total.length();
        for(int i = 0; i < total.length(); i ++){
            int helper2 = scan.nextInt();
            ForestNode helper = new ForestNode();
            helper.parentPosition = helper2;
            helper.position = i;
            helper.data = total.substring(i, i + 1);
            forest.forestNodes.add(helper);
        }
        scan.close();
        forest.buildForest();
        //forest.print();
        ForestNode ii = Forest.getRoot();
        //System.out.println(ii.data);
        Node create = forest.build(ii);
        System.out.println(Node.in_order(create));

        System.out.println(Node.post_order(create));
        System.out.println(Node.depth(create));

    }
    public static class ForestNode{
        public String data;
        public ForestNode parent;
        public int position;
        public int parentPosition;


    }
    public static class Forest{

        public static ArrayList<ForestNode> forestNodes = new ArrayList<>();
        public int current;
        public static int length ;

        public static ForestNode getRoot(){
            int count = 0;
            int flag = 0;
            ForestNode res = null;
            for(int i = 0; i < forestNodes.size() ; i  ++){
                if(forestNodes.get(i).parentPosition == -1){
                    res = forestNodes.get(i);
                    break;
                }
            }
            return res;
        }
        public static Node build(ForestNode helpNode){
            Node ans = new Node();
            ans.data = helpNode.data;
            boolean flag = false;
            for(int i = helpNode.position + 1; i < forestNodes.size(); i ++ ){
                if(i < forestNodes.size() && forestNodes.get(i).parentPosition == helpNode.parentPosition){
                    ans.rchild = build(forestNodes.get(i));
                    break;
                }
                else{
                    ans.rchild = null;
                    break;
                }
            }
            for(int i  = helpNode.position + 1; i < forestNodes.size(); i ++){
                if(i < forestNodes.size() && forestNodes.get(i).parentPosition == helpNode.position){
                    ans.lchild = build(forestNodes.get(i));
                    flag = true;
                    break;
                }
                if(flag == false && i == forestNodes.size() - 1){
                    ans.lchild = null;
                }
            }
            return ans;

        }

        public static ForestNode buildForest(){
            forestNodes.get(0).parent = null;
            for(int i  = length - 1 ;i > 0; i --){
                if(forestNodes.get(i).parentPosition == -1){
                    return forestNodes.get(i);
                }
                else{
                    forestNodes.get(i).parent = forestNodes.get(forestNodes.get(i).parentPosition);
                }
            }
            return forestNodes.get(0);
        }
        public static void print(){
            for(int i = length - 1; i > 0; i --){
                System.out.println(forestNodes.get(i).parent.data);
            }
        }


    }
    public static class Node{
        public String data;
        public Node lchild;
        public Node rchild;

        public static int depth(Node node){
            if(node == null){
                return 0;
            }
            else{
                return Math.max(depth(node.lchild),depth(node.rchild)) + 1;
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

    }
}
