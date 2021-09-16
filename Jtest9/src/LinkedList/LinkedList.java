package LinkedList;

public class LinkedList {
    public static void main(String[] args){
        HeroNode hero1 = new HeroNode(1,"Jack","HelloCoke");
        HeroNode hero2 = new HeroNode(2,"JackyC","HelloNancy");
        HeroNode hero3 = new HeroNode(3,"Demon","Illusion");
        HeroNode hero4 = new HeroNode(3,"Sancy","David");
        singleLinkedList singleList = new singleLinkedList();
        singleList.add(hero1);
        singleList.add(hero3);
        singleList.addByNumber(hero2);
        singleList.showLinkedlist();
        singleList.update(hero4);
        singleList.showLinkedlist();
        singleList.delete(hero1);
        singleList.showLinkedlist();
    }
}
class singleLinkedList{
    private HeroNode head = new HeroNode(0,"","");
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp=temp.next;
        }
        temp.next = heroNode;

    }
    public void update(HeroNode heroNode){
        HeroNode temp = head;
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
    public void delete(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = true;
        if(head.next==null)
            return;
        if(temp.no==heroNode.no){
            temp = temp.next;
            head = temp;
        }
        else {
            while (temp.next != null ) {
                if (temp.next.no==heroNode.no) {
                    if(temp.next.next!=null){
                        temp.next= temp.next.next;
                        break;
                    }
                    else{
                        temp.next=null;
                        break;
                    }

                } else
                {
                    temp = temp.next;
                }
            }
        }
    }
    public void addByNumber(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no>heroNode.no){
                break;
            }
            else if (temp.no==heroNode.no){
                flag = true;
                break;
            }
            else{
                temp = temp.next;
            }
        }
        if(flag == true) {
            System.out.println("已存在，不能添加");
        }
        else{
            heroNode.next = temp.next;
            temp.next = heroNode;

        }
    }
    public void showLinkedlist(){
        if(head.next == null )
            return ;
        else{
            HeroNode temp = head.next;
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

}
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    public HeroNode(int nNo,String nname,String nnickname){
        this.no = nNo;
        this.name = nname;
        this.nickname = nnickname;
    }
    @Override
    public String toString(){
        return "HeroNode [No = "+no + ", name = "+ name + ", nickname = " + nickname+".";
    }
}
