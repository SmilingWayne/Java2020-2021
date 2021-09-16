package InsertSearch;
//差值查找算法：计算和最开始的点的差距是多少//
public class insertsearch {
    public static void main(String[] args){
        //mid = (high - low)*(key - a[low])/(a[high] - a[low]) + low;
        //自适应
        //在数字连续的情况下，定位速度很快
        int[] arr = {1,2,3,4,6,9,12,14};
        System.out.println(insertSearch(arr,0,7,9));

    }
    public static int insertSearch(int[] arr, int left, int right, int findVal){
        if(left > right || findVal < arr[left] || findVal > arr[right])
            return -1;
        System.out.println("hello_");
        int mid = left + (right - left)*(findVal - arr[left])/(arr[right] - arr[left]);
        int midVal = arr[mid];
        if(findVal > midVal){
            return insertSearch(arr,mid +1,right,findVal);
        }
        else if(findVal < midVal){
            return insertSearch(arr, left,mid - 1,findVal);
        }
        else{
            return mid;
        }
    }

}
