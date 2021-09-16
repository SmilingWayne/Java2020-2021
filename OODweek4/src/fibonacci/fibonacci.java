package fibonacci;

public class fibonacci {
    public static StringBuilder sb = new StringBuilder();
    private static long[] f = new long[92];
    public static long fibonacci(int n){
        if(n == 0)
            return 0;
        if(n ==1)
            return 1;
        if(f[n]>0)
            return f[n];
        else{
            f[n] = fibonacci(n-1)+fibonacci(n-2);
        }
        return f[n];
    }
    public static long fibo22(int x){
        long[] ff = new long[x+1];
        f[0] =0;
        f[1] =1;
        for(int i = 2 ;i < x+1; i++){
            f[i] = f[i-2]+f[i-1];
        }
        return f[x];
    }
    public static int LCScompare(String a, String b){
        if(a.length() == 0 ||b.length() == 0)
            return 0;
        else{
            if(a.substring(0,1).equals(b.substring(0,1))){
                return LCScompare(a.substring(1,a.length()),b.substring(1,b.length()))+1;
            }
            else{
                int c = LCScompare(a.substring(1,a.length()),b);
                int d = LCScompare(a,b.substring(1,b.length()));
                return Math.max(c,d);
            }
        }
    }
    public static void LCSresult(String a ,String b){
        int a_length = a.length();
        int b_length = b.length();

    }

    public static void main(String[] args){
        String a = "CCTAACCG";
        String b ="GGTTACTCCG";
        //答案是GGTCCG//
        System.out.println(LCScompare(a,b));

    }

}
