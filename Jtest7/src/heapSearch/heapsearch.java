package heapSearch;

import java.util.PriorityQueue;

//每个节点的数值<=左右孩子的数值：小顶堆
//每个节点的数值>=左右孩子的数值：大顶堆
//一定是完全二叉树
//升序采用大顶堆，降序采用小顶堆
//把待排序序列构造成一个大顶堆，整个堆的根节点就是堆顶的最大值
//
public class heapsearch {
    public static void main(String[] args){
        int[] arr = {4,6,8,5,9};
    }
    public static void heapSort(int[] arr){

    }

    /**
     *
     * @param arr 待调整的数组
     * @i 叶子节点在数组中的索引 i = 1 得到4 9 8 5 6 ，i = 0-> 9 6 8 5 4
     * @param length 逐渐减少
     * 方法的功能：将以i 对应的叶子节点调整成大顶堆
     */
    public static void adjustHeap(int[] arr,int i, int length){
        int temp = arr[i];
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1){
            if(k + 1 < length && arr[k] < arr[k + 1]){
                k ++ ; //k指向了右子节点
            }
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }
            else{
                break;
            }
        }
        arr[i] = temp;

    }
}
