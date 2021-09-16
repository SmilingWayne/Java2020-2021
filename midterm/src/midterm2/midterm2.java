package midterm2;

import java.util.*;


/**
 * 数据结构期中考试第二问
 */
public class midterm2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String line1 = scan.next();
        String line2 = scan.next();
        if(judge(line1,line2)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
    public static boolean judge(String line1,String line2){
        int flag = -1;
        Stack<Character> stack1 = new Stack<>();
        if(line1.length() < line2.length()){
            return false;
        }
        for(int i = 0; i < line2.length(); i++){
            for(int j = flag + 1; j < line1.length(); j++){
                if(!stack1.isEmpty()) {
                    if (stack1.peek() == line2.charAt(i)) {
                        stack1.pop();
                        line1 = line1.substring(0, j) + line1.substring(j + 1);

                        flag = j;
                        break;
                    }
                }
                if(stack1.isEmpty() && line1.charAt(j) == line2.charAt(i)){
                    flag++;
                    stack1.push(line1.charAt(j));
                    stack1.pop();
                    break;
                }
                while(stack1.isEmpty() || line1.charAt(j)!=line2.charAt(i) || stack1.peek()!=line2.charAt(i)){
                    stack1.push(line1.charAt(j));
                    j++;
                    flag ++;
                    if(stack1.peek()!=line2.charAt(i) && j >= line1.length()){
                        return false;
                    }
                    if(stack1.peek() == line2.charAt(i)) {
                        stack1.pop();
                        break;
                    }
                }

            }
        }
        return true;
    }
}
