package doubleLinkedList;



public class doublelinkedlist {
    public static void main(String[] args){
        //略//
    }
}
class doublelist{
    private HeroNode2 head = new HeroNode2(0,"","");
    public void showLinkedlist(){
        if(head.next == null )
            return ;
        else{
            HeroNode2 temp = head.next;
            while(true){
                if(temp == null )
                    break;
                else{
                    System.out.println(temp);
                    temp = temp.next;
                }

            }
        }
    }
    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp=temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;

    }
    public void update(HeroNode2 heroNode){ //内容修改和单项链表一样的//
        HeroNode2 temp = head;
        if(head.next==null)
            System.out.println("kong");
        else{
            while(temp.no!=heroNode.no&&temp.next!=null){
                temp = temp.next;
            }
            if(temp.no!=heroNode.no){
                System.out.println("查无此相对应");
            }
            else{
                temp.nickname = heroNode.nickname;
                temp.name=heroNode.name;
            }
        }
    }
    public void delete(int no){
        boolean flag = true;
        if(head.next==null){
            System.out.println("空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        while(true){
            if(temp==null)
                break;
            if(temp.no==no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.pre.next = temp.next;
            if(temp.next!=null) {
                temp.next.pre = temp.pre;
            }
        }
        else{
            System.out.println("bucunzai");
        }

    }


}
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;
    public HeroNode2(int nNo,String nname,String nnickname){
        this.no = nNo;
        this.name = nname;
        this.nickname = nnickname;
    }
    @Override
    public String toString(){
        return "HeroNode [No = "+no + ", name = "+ name + ", nickname = " + nickname+".";
    }
}
