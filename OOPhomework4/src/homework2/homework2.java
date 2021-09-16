package homework2;
public class homework2 {
    /**
     * 分别计算数值(很水)
     * @param args
     */
    public static void main(String[] args){
        char[] A = {'a','b','c'};
        char[] B = {'x','y','z'};
        int[][] res = new int[3][3];

        for(int i = 0 ; i < 3; i++){
            if(A[i] == 'a'&&B[i] == 'x'){
                char temp = B[2];
                B[2] = B[i];
                B[i] = temp;
            }
            if((A[i] == 'c'&&B[i] == 'z')||(A[i] == 'c'&&B[i] == 'x')){
                char temp = B[1];
                B[1] = B[i];
                B[i] = temp;
            }

        }

        System.out.println(A[0]+":"+B[0]);
        System.out.println(A[1]+":"+B[1]);
        System.out.println(A[2]+":"+B[2]);
    }
}
