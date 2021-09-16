package JTest5;
import java.util.*;
public class SetTest {
    public static void main(String[] args){
        Set<String>words=new HashSet<>();
        long totalTime=0;
        try(Scanner in= new Scanner(System.in)) {
            String word = in.next();
            long callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis() - callTime;
            totalTime+=callTime;
        }
        Iterator<String> iter=words.iterator();

    }
}
