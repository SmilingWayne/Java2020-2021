package rePolandcal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class repolandcal {
    public static void main(String[] args){
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +"; //4*5 - 8 + 60 + 8/2//
        //3 4 + 5 * 6 -//
        //使用空格隔开//
        List<String> rpnlist = getListString(suffixExpression);
        System.out.println(rpnlist);
        System.out.println(calculate(rpnlist));

    }
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele:split){
            list.add(ele);
        }
        return list;
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
