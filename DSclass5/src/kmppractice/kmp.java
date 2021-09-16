package kmppractice;

/**
 * 学了几年依旧学不会的KMP算法
 */
public class kmp {
    public static void main(String[] args){
        String a = "CABCDCAC";
        String b = "BCD";
        System.out.println(kmp(a,b));
    }
    public static int kmp(String s,String t){
        int i = 0;
        int j = -1;
        int[] next = kmp_index(t);
        while( i < s.length() && j < t.length()){
            if( j == -1 || s.charAt(i) == t.charAt(j)){
                i++;
                j++;

            }
            else{
                j = next[j];
            }
        }
        if( j >= t.length()){
            return i - t.length();
        }
        else{
            return -1;
        }
    }
    public static int[] kmp_index(String s){
        int[] res = new int[s.length()];
        res[0] = -1;
        int i = 0 ;
        int j = -1;
        while( i < s.length() -1){
            if( j == -1 || s.charAt(i) == s.charAt(j)){
                i++;
                j++;
                if(s.charAt(i) == s.charAt(j)){
                    res[i] = j;
                }
                else{
                    res[i] = res[j];
                }
            }
            else{
                j = res[j];
            }
        }
        return res;

    }
}
