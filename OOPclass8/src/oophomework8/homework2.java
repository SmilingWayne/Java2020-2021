package oophomework8;

public class homework2 {
    public static void main(String[] args) {
        String a = "abcjsyr";
        int mask = 0;
        for(int i = 0 ; i < a.length(); i ++ ){
            mask |= (1 << a.charAt(i) - 'a');
        }
        System.out.println(Integer.toBinaryString(mask));
    }
}
