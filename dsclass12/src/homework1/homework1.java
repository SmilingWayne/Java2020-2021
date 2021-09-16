package homework1;
import java.util.*;
public class homework1 {
    //这是霍夫曼树例题的代码
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        scan.close();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < input.length() ; i++ ){
            map.put(input.substring(i,i+1),map.getOrDefault(input.substring(i, i + 1),0) + 1);
        }
        ArrayList<Node> total = new ArrayList<>();
        ArrayList<Node> prepare = new ArrayList<>();
        for(String s : map.keySet()){
            Node helper = new Node();
            helper.s = s;
            helper.number = map.get(s);
            helper.rchild = null;
            helper.lchild = null;
            helper.flag = "";
            total.add(helper);
            prepare.add(helper);
        }
        if(prepare.size() == 1){
            System.out.println(prepare.get(0).number);
        }
        else {
            //display(total);
            int[] hel = getSmallest(total);
            Node head = buildTree(total);
            String help = "";
            int res = getTotalLength(head, prepare, help);
            System.out.println(res);
        }

    }
    public static void display(ArrayList<Node> total){
        for(int i = 0; i < total.size(); i ++ ){
            System.out.println(total.get(i).s + " " + total.get(i).number );
        }
    }
    public static Node buildTree(ArrayList<Node> total){
        if(total.size() == 0){
            return null;
        }
        if(total.size() == 1){
            return total.get(0);
        }
        else{
            int[] twoMin = getSmallest(total);
            int first = twoMin[0];
            int second = twoMin[1];
            total.get(first).flag = "0";
            total.get(second).flag = "1";
            Node combine = new Node();
            combine.lchild = total.get(first);
            combine.rchild = total.get(second);
            combine.number = total.get(first).number + total.get(second).number;
            total.remove(first);
            if(second > first){
                second = second - 1;
            }
            total.remove(second);

            total.add(combine);
            //display(total);
            return buildTree(total);
        }
    }
    public static int getTotalLength(Node node, ArrayList<Node> total,String help){
        int answer = 0;
        if(node == null){
            return 0;
        }
        if(node.lchild != null && node.rchild != null){
            String help1 = help + node.lchild.flag + "";
            answer += getTotalLength(node.lchild,total,help1);
            String help2 = help + node.rchild.flag + "";
            answer += getTotalLength(node.rchild,total,help2);
        }
        else{
            if(node.lchild == null && node.rchild == null){
                for(int i = 0 ; i < total.size() ; i ++ ){
                    if(total.get(i).s.equals(node.s)){
                        answer = total.get(i).number * help.length();
                        break;
                    }
                }
            }
        }
        return answer;

    }
    public static int[] getSmallest(ArrayList<Node> total){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[2];
        if(total.size() == 0 || total.size() == 1){
            return new int[2];
        }
        else{
            for(int i = 0 ; i < total.size(); i ++ ){
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else if(stack.size() == 1){
                    if(total.get(i).number < total.get(stack.peek()).number){
                        int helper1 = stack.pop();
                        stack.push(i);
                        stack.push(helper1);
                    }
                    else{
                        stack.push(i);
                    }
                }
                else{
                    if(total.get(i).number >= total.get(stack.peek()).number){
                        continue;
                    }
                    else{
                        int helper1 = stack.pop();
                        if(total.get(i).number < total.get(stack.peek()).number){
                            helper1 = stack.pop();
                            stack.push(i);
                            stack.push(helper1);
                        }
                        else{
                            stack.push(i);
                        }
                    }
                }
            }
        }
        ans[1] = stack.pop();
        ans[0] = stack.pop();
        //System.out.println(ans[0] + " " + ans[1]);
        return ans;

    }

}
class Node{
    public String s;
    public int number;
    public String flag;
    public Node lchild;
    public Node rchild;

}
