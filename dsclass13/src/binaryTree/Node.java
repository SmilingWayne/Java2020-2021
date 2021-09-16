//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package binaryTree;

import java.util.Stack;

public class Node {
    public String data;
    public Node lchild;
    public Node rchild;
    public int ltag = 1;
    public int rtag = 1;

    public Node() {
    }

    private static Node parse(String str, int[] count) {
        //int var10002;
        if (str.charAt(count[0]) == '#') {
            //var10002 = count[0]++;
            count[0] ++;
            return null;
        } else {
            Node node = new Node();
            node.data = str.substring(count[0], count[0] + 1);
            //var10002 = count[0]++;
            count[0] ++;
            node.lchild = parse(str, count);
            node.rchild = parse(str, count);
            return node;
        }
    }

    public static Node parse(String str) {
        return parse(str, new int[1]);
    }

    public static String pre_order(Node node) {
        if (node == null) {
            return "";
        } else {
            String str = node.data;
            str = str + pre_order(node.lchild);
            str = str + pre_order(node.rchild);
            return str;
        }
    }

    public static String in_order(Node node) {
        if (node == null) {
            return "";
        } else {
            String str = in_order(node.lchild);
            str = str + node.data;
            str = str + in_order(node.rchild);
            return str;
        }
    }

    public static String post_order(Node node) {
        if (node == null) {
            return "";
        } else {
            String str = post_order(node.lchild);
            str = str + post_order(node.rchild);
            str = str + node.data;
            return str;
        }
    }

    public static int leaf_number(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.lchild == null && node.rchild == null ? 1 : leaf_number(node.lchild) + leaf_number(node.rchild);
        }
    }

    public static int depth(Node node) {
        return node == null ? 0 : 1 + Math.max(depth(node.lchild), depth(node.rchild));
    }

    public static String in_order2(Node node) {
        String str = "";
        Stack<Node> stack = new Stack();
        Node p = node;

        while(p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.lchild;
            } else {
                p = (Node)stack.pop();
                str = str + p.data;
                p = p.rchild;
            }
        }

        return str;
    }

    public static void thread(Node node) {
        Stack<Node> stack = new Stack();
        Node p = node;
        Node pre = null;

        while(p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.lchild;
            } else {
                p = (Node)stack.pop();
                if (p.lchild == null) {
                    p.lchild = pre;
                    p.ltag = 2;
                }

                if (pre != null && pre.rchild == null) {
                    pre.rchild = p;
                    pre.rtag = 2;
                }

                pre = p;
                p = p.rchild;
            }
        }

    }

    public static String thread_visit(Node node) {
        String str = "";
        Node p = node;

        while(p != null) {
            while(p != null && p.ltag == 1) {
                p = p.lchild;
            }

            for(boolean flag = true; p != null && flag; p = p.rchild) {
                str = str + p.data;
                if (p.rtag == 1) {
                    flag = false;
                }
            }
        }

        return str;
    }
}
