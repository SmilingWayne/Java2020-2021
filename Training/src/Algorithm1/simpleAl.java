package Algorithm1;
/*这一章是字符串查找算法。。。好难*/
public class simpleAl {
    public static void main(String[] args){
        String a = "namcyhelloworlddsd";
        String b = "helloworld";
        String c = "aaaab";
        String d = "wqqdaabdjcswwdisa";
        System.out.println(simple_indexof(a,b));
        for(int i:get_nextval(c)) {
            System.out.print(i);
        }
        System.out.println("");
        //System.out.println(kmp_indexof(c,d));
    }
    public static int simple_indexof(String s,String t){
        if(s.length()<t.length())
            return -1;
        for(int i = 0; i< s.length()-t.length()+1;i++){
            boolean match = true;
            for(int j = 0; j<t.length();j++){
                if(s.charAt(i+j)!=t.charAt(j)){
                    match = false;
                    break;
                }
            }
            if(match){
                return i;
            }
        }
        return -1;
    }//简单算法//
    public static int[] get_next(String t){
        int[]next = new int[t.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while(i<t.length()-1){
            if(j==-1||t.charAt(i)==t.charAt(j)){
                i++;
                j++;
                next[i] = j;
            }
            else{
                j = next[j];
            }
        }
        return next;
    }
    public static int[] get_nextval(String t){
        int[] next = new int[t.length()];
        next[0]=-1;
        int i = 0,j = -1;
        while(i<t.length()-1){
            if(j==-1||t.charAt(i)== t.charAt(j)){
                i++;
                j++;
                if(t.charAt(i)!=t.charAt(j)){
                    next[i] = j;
                }
                else{
                    next[i] = next[j];
                }
            }
            else{
                j = next[j];
            }   //回溯算法？？//
        }
        return next;
    }
    public static int kmp_indexof(String a , String b){
        int[] next  = get_nextval(b);
        int i = 0, j = 0;
        while(i < a.length() && j <b.length()){
            if(j==0||a.charAt(i)==b.charAt(j)){
                i++;
                j++;
            }
            else{
                j = next[j];
            }

        }
        if(j>=b.length())
            return i-b.length();
        else
            return -1;
     }
}
