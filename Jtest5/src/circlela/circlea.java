package circlela;
import java.util.*;
public class circlea {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Input the number of boys:");
        int number = scan.nextInt();
        scan.close();
        create_boy_circle hello = new create_boy_circle();
        hello.addboys(number);
        hello.display();
    }
}
class create_boy_circle{
    public Boy first = null;
    public Boy curboy = null;
    public void addboys(int nums){
        for(int i =1 ; i <= nums ; i ++ ){
            if(i == 1){
                Boy boy = new Boy(i);
                first = boy;
                boy.setNext(first);
                curboy = first;
            }
            else{
                Boy other_boys = new Boy(i);
                curboy.setNext(other_boys);
                other_boys.setNext(first);
                curboy = other_boys;
            }
        }

    }
    public void display(){
        if(first == null )
            return;
        else{
            Boy curBoy = first;
            while(true){
                System.out.println(curBoy.number);
                if(curBoy.next == first){
                    break;
                }
                curBoy = curBoy.next;
            }
        }
    }
}
class Boy{
    public int number;
    public Boy next;
    public Boy(int nnumber){
        this.number = nnumber;

    }
    public void setNext(Boy boy2){
        this.next = boy2;
    }
}