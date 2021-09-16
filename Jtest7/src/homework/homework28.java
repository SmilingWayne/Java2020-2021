package homework;

import java.util.*;
public class homework28 {
    /*
    验证栈序列能否实现：这里数据清洗了一下：
    直接贪心思路，每次都只有出现了flag所在的数据才行
    abcd
    dcba
    -> Yes
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        String s2 = scan.next();
        char[] pushed = s1.toCharArray();
        char[] popped = s2.toCharArray();
        if(validateStackSequences(pushed, popped)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }

    }
    public static boolean validateStackSequences(char[] pushed, char[] popped) {
        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        int flag = 0;
        for(int i = 0 ; i < pushed.length ; i ++ ){
            if(popped[flag] != pushed[i]){
                stack.push(pushed[i]);
                set.add(pushed[i]);
                continue;
            }
            else{
                stack.push(pushed[i]);
                set.add(pushed[i]);
                while(!stack.isEmpty() && stack.peek() == popped[flag]){
                    stack.pop();
                    set.remove(popped[flag]);
                    flag ++ ;
                }
            }
        }
        if(set.size() != 0 ){
            return false;
        }
        return true;
    }
}