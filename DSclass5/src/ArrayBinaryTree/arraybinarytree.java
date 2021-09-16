package ArrayBinaryTree;

/**
 * 存储的完全二叉树？
 */
public class arraybinarytree {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        binaryTree tree = new binaryTree(arr);
        tree.postOrder(0);

    }
}
//顺序存储二叉树一定是完全二叉树吗 --是的，将来用于堆排序，记得前序遍历//

class binaryTree{
    private int[] arr;
    public binaryTree(int[] arr){
        this.arr = arr;
    }
    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
        }
        System.out.println(arr[index]);
        //向左递归遍历//
        if(index*2+1<arr.length){
            preOrder(index*2+1);
        }
        if(index*2+2<arr.length){
            preOrder(index*2+2);
        }
    }
    public void postOrder(int index){
        if(arr == null || arr.length ==0){
            System.out.println("数组为空");
        }
        if(index*2+1 < arr.length){
            postOrder(index*2+1);
        }
        if(index*2+2 < arr.length){
            postOrder(index*2+2);
        }
        System.out.println(arr[index]);
    }
    public void infixOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
        }
        if(index*2+1 < arr.length){
            postOrder(index*2+1);
        }
        System.out.println(arr[index]);
        if(index*2+2 < arr.length){
            postOrder(index*2+2);
        }

    }
}
