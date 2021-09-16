package search;

public class search{

    public static int search(int[] A, int aStart, int[] B, int bStart, int k){
        if(aStart >= A.length){
            return B[k];
        }
        if(bStart >= B.length){
            return A[k];
        }
        if(k == 1){
            return Math.min(A[aStart], B[bStart]);
        }
        int aMedian = Integer.MAX_VALUE;
        if(aStart + k / 2 - 1 < A.length){
            aMedian = A[aStart + k / 2 - 1];
        }
        int bMedian = Integer.MAX_VALUE;
        if(bStart + k / 2 - 1 < B.length){
            bMedian = B[bStart + k / 2 - 1];
        }
        if(aMedian < bMedian){
            return search(A, aStart + k / 2, B, bStart, k - k / 2);
        }
        else{
            return search(A, aStart, B, bStart + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args){
        int[] A = {1, 3};
        int[] B = {2, 4};
        int k = (int) Math.ceil((A.length + B.length) / 2.0) + 1;
        int ret = search(A, 0, B, 0, k);
        System.out.println(ret);
    }
}