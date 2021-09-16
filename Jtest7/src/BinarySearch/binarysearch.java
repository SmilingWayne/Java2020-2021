package BinarySearch;
//二分查找算法//
import java.util.*;
import java.util.ArrayList;
public class binarysearch {

    public static void main(String[] args){
        int[] arr = {1,2,3,4,6,9,12,88};
        List<Integer> helper = binarySearch(arr,0,arr.length -1,9);
        System.out.println(helper);
    }
    public static List<Integer> binarySearch(int[] arr, int left, int right,int findVal ){
        //此方法只能获取一个数，无法获取所有相同的数值//
        ArrayList<Integer> res = new ArrayList<>();
        System.out.println("hello");
        int med = (left+right)/2;
        int midVal = arr[med];
        if(left > right)
            return new ArrayList<Integer>();    //这里对于返回空的操作来看一下：
        if(findVal > midVal){
            return binarySearch(arr,med+1,right,findVal);
        }
        else if(findVal < midVal){
            return binarySearch(arr,left,med - 1,findVal);
        }
        else{
            res.add(med);
            int temp = med -1;
            while(true){
                if(temp < 0 || arr[temp] !=findVal){
                    break;
                }
                res.add(temp);
                temp --;
            }
            temp = med + 1;
            while(true){
                if(temp > arr.length  || arr[temp]!=findVal){
                    break;
                }
                res.add(temp);
                temp ++;
            }
        }
        return res;

    }
}
