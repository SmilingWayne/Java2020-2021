package circleSIngleLinkedList;

public class circlelinkedlist {
    public static void main(String[] args) {
        CircleLinkedLists circles = new CircleLinkedLists();
        int[] codes = {1,2,3,4,5};
        int[][] delta = new int[codes.length][2];
        circles.addBoy(5
                ,codes);
        circles.showBoy();
        /*int end = codes.length;
        int start = 0;
        int a = 1;
        int b = codes[0];
        while(start<end){
            delta[start] = circles.printBoy(b);
            delta[start][0] = a;
            delta[start][1] = b;
            start++;
            System.out.println(a);
        }*/
        int[] triangle = circles.countBoy(1,6,codes.length);
        int a = triangle[0];
        int b = triangle[1];
        for(int count1 = 1;count1 < codes.length;count1++ ){
            triangle = circles.countBoy(a,b,codes.length - count1);
            a = triangle[0];
            b = triangle[1];
        }

    }
}
class CircleLinkedLists{
    public Boy first = null;
    public void addBoy(int nums,int[] codes){
        if(nums<1){
            System.out.println("Incorrect");
            return;
        }
        Boy curBoy = null;
        for(int i = 1; i <= nums; i++ ){
            Boy boy = new Boy(i,codes[i-1]);
            if(i==1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }
            else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }
    public void showBoy(){
        if(first==null) {
            System.out.println("空");
            return;
        }
        else{
            Boy curBoy = first;
            while(true){
                System.out.printf("编号%d,号码是%d\n",curBoy.no,curBoy.code);
                if(curBoy.next == first){
                    break;
                }
                curBoy = curBoy.getNext();
            }
        }
    }
    public int[] countBoy(int startno,int countno,int nums){
        if(first == null||startno <1 ){
            System.out.println("有错误，重新输入");
        }
        Boy helper = first;
        int[] ans = new int[2];
        if(helper.next==first){
            System.out.printf("小孩%d出,号码是%d",helper.no,helper.code);
            ans[0] = helper.no;
            ans[1] = helper.code;
            return ans;
        }
        while(true){
            if(helper.getNext()==first){
                break;
            }
            helper = helper.getNext();
        }

        while(first.no != startno){
            first = first.getNext();
            helper = helper.getNext();
        }
        while(true){
            if(helper==first){
                ans[0] = helper.no;
                ans[1] = helper.code;
                break;
            }
            else{
                for(int j = 0; j< countno-1;j++){
                    first = first.getNext();
                    helper = helper.getNext();
                }
                System.out.printf("小孩%d出,号码是%d\n",first.no,first.code);
                ans[1] = first.code;
                ans[0] = first.next.no;
                first = first.next;
                helper.next = first;
                return ans;
            }
        }
        return ans;
    }
    public int[] printBoy(int target) {
        Boy helper = first;
        int[] res3 = new int[2];
        if (helper.next == helper) {
            res3[0] = helper.no;
            res3[1] = helper.code;
        }
        else {
            int count = 1;
            while (count != target) {
                helper = helper.next;
                count++;
            }
            int res = helper.no;
            int res2 = helper.code;
            helper.no = helper.next.no;
            helper.code = helper.next.code;
            helper.next = helper.next.next;
            first = helper;
            res3[0] = res;
            res3[1] = res2;
            return res3;
        }
        return res3;
    }

}
class Boy{
    public int no;
    public  int code;
    public Boy next;
    public Boy(int no, int code){
        this.no = no;
        this.code = code;
    }

    public void setNext(Boy boy2){
        this.next = boy2;
    }
    public Boy getNext(){
        return next;
    }
    public void setNo(int n){
        this.no = n;
    }


}
