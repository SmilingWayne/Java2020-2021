package JTest5;
import java.time.LocalDate;
import java.util.*;
public class JTest5 {
    public static void main(String[] args){
        /*String s="OOK";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s.hashCode()+" "+sb.hashCode());
        String t= new String("OOK");
        StringBuilder tb=new StringBuilder(t);
        System.out.println(t.hashCode()+" "+tb.hashCode());*/

        //上面这段是调用了所有字符串的散列码//
        //StringBuilder作用是修改字符内容？？//
        Manager boss=new Manager("Carl Cracker",900000,1987,12,10);
        boss.setbonus(50000);
        Employee[] staff = new Employee[3];
        staff[0]=boss;
        Manager tom=new Manager("Harry Hacker",50000,1918,10,1);
        tom.setbonus(400);
        staff[1]=tom;
        staff[2]=new Manager("Tony Tester",30000,1980,4,5);
        for(Employee e:staff){
            System.out.println(e.getName()+" "+e.getSalary());
        }
        Object obj=new Manager("Tomson",50000,1989,10,9);
        ArrayList<Manager>staff2=new ArrayList<>(1000);
        //这里的1000表示加入的最多元素的个数//
        //右边<>中也可以加上Manager//
        //上面的ArrayList是泛型数组,不限制加入的具体个数//
        /*staff2.ensureCapacity(200);*/
        //这里表示限定储存的元素的数量//


        staff2.add(new Manager("Dinghang",190000,2001,9,20));
        staff2.add(new Manager("Edith",70000,1999,6,3));
        staff2.add(new Manager("JonSnow",4000,1992,7,15));
        //这里最好的插入方法，是先声明再直接插入//
        //这样可以加入bonus再里面//

        System.out.println(staff2.size());
        //返回当前元素数量//
        staff2.set(1,tom);
        staff2.add(1,boss);//将序号处的设置为boss,后面的都后移一个单位//
        /*Manager ui=staff2.remove(0);*/
        //将序号处的元素传递给ui,删除这个元素，后续元素前移//

        Manager jack=(Manager)staff2.get(1);
        //get的调用者必须对返回值进行结构转换//

        for(Manager s:staff2){
            s.raiseSalary(5);
            System.out.println("Name:"+s.getName()+" Salary:"+s.getSalary());
        }

        ArrayList<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        for(int i=0;i<2;i++){
            System.out.println(String.format("%d",list.get(i)));
            //这里也可以printf表示（同C语言）//
        }
        String length=Size.SMALL.toString();
        int OrderOfMedium=Size.MEDIUM.ordinal();
        //这个意思是取MEDIUM在枚举数组中的序号//
        int haha=Size.MEDIUM.detailedLength;
        System.out.print(length+" "+haha+OrderOfMedium);
    }
    public enum Size
    {
        SMALL("S",5),MEDIUM("M",6),LARGE("L",7),
        EXTRA_LARGE("XL",8);
        private String
                abbreviation;
        private Integer detailedLength;
        private Size(String abbreviation,Integer detailedLength){
            this.abbreviation=abbreviation;
            this.detailedLength=detailedLength;
        }
        public String getAbbreviation(){
            return abbreviation;
        }
    }

}
