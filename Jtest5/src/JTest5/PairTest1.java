package JTest5;

public class PairTest1 {
    public static void main(String[] args){
        String[] words={"Mary","had","a","little","lamb"};
        Pair<String> mm=Pair.minmax(words);
        System.out.println("min="+mm.getFirst());
        System.out.println("Max="+mm.getSecond());
        System.out.println("The first="+mm.getThird());
    }
}
