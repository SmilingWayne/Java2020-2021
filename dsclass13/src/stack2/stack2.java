package stack2;
import java.io.File;
import java.util.*;
public class stack2 {
    public static void main(String[] args) {
        File file = new File("src/stack2/data");
        try{
            Scanner scan = new Scanner(file);
            String a = scan.nextLine();
            System.out.println(a);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                Stack<String> stack  = new Stack<>();
                for(int i = 0 ; i < line.length(); i ++ ){
                    String g = line.substring(i, i + 1);
                    if(g.equals("#")){
                        if(stack.isEmpty()){
                            continue;
                        }
                        else{
                            stack.pop();
                        }
                    }
                    else if(g.equals("@")){
                        while(!stack.isEmpty()){
                            stack.pop();
                        }
                    }
                    else{
                        stack.push(g);
                    }
                }
                String s = "";
                while(!stack.isEmpty()){
                    s = stack.pop() + s + "";
                }
                System.out.println(s);
            }
        }
        catch(Exception e){
            System.out.println("未找到文件");
        }

    }
}
