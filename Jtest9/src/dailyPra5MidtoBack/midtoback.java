package dailyPra5MidtoBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//中缀表达式转换成后缀表达式//
public class midtoback {
    public static void main(String[] args) {
        //1+(2+3)*4-5
        String expression = "1+(2+3)*4+5";
        List<String> res = toInfixExpressionList(expression);
        List<String> ans = parseSuffixExpressionList(res);
        System.out.println(ans);
        int answer = calculate(ans);
        System.out.println(answer);
    }
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        Stack<String> stack1 = new Stack<>();
        //Stack<String> stack2 = new Stack<>();
        //stack2 可以使用arrayLIst替代，stack2没有pop操作，逆序输出，太麻烦//
        List<String> s2 = new ArrayList<String>();
        //遍历//
        for (String item : ls) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                stack1.push(item);
            } else if (item.equals(")")) {
                while (!stack1.peek().equals("(")) {
                    s2.add(stack1.pop());
                }
                stack1.pop();//"("弹出//
            } else {
                while(stack1.size()!=0&&operation.getValue(stack1.peek())>operation.getValue(item)){
                    s2.add(stack1.pop());
                }
                stack1.push(item);
            }
        }
        while(stack1.size()!=0){
            s2.add(stack1.pop());
        }
        return s2;
    }


    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<String>();
        int i = 0;
        String str;
        char c ;
        do{
            if((c=s.charAt(i))<48||(c=s.charAt(i))>57){ //ASICC编码表示数字//
                ls.add(""+c);
                i++;
            }
            else{
                str = "";
                while(i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str+=c;//拼接的过程//
                    i++;
                }
                ls.add(str);
            }
        }while(i<s.length());
        return ls;
    }
    public static int calculate(List<String> ls){
        //这里只需要一个栈
        Stack<String> stack= new Stack<String>();
        for(String item:ls){
            //使用正则表达式//
            if(item.matches("\\d+")){
                //匹配的是多位数//
                stack.push(item);
            }
            else{
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num2 + num1;
                }
                else if(item.equals("-")){
                    res = num1 - num2;
                }
                else if(item.equals("*")){
                    res = num2 * num1;
                }
                else if(item.equals("/")){
                    res = num1 / num2;
                }
                else{
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈//
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());

    }

}
class operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;
    public static int getValue(String operation){
        int result = 0;
        switch(operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}

//关键点应该在如何转换到String组中//