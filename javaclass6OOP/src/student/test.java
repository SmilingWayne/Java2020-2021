package student;

public class test {
    public static void main(String[] args){
        /*Phd phd = new Phd(2020210,"张三",0){
            public void publish(String papername){
                System.out.println(name + ":" + papername);
            }
        };
        //Student student1 = new Student(202020202,"李四");
        //Student student = (Student)phd;  //已经重载//
        System.out.println(phd.getName());
        phd.publish("Helloworld");
        if(student instanceof Phd){
            System.out.println("True");
        }
        System.out.println(student1 instanceof Phd);
        */
        Phd phd =  new Phd(202010, "李四", 0);
        Bachelor bachelor = new Bachelor(202011, "张三", 4.99);
        phd.process();
        bachelor.process();
        Exame exam = new Bachelor(202010, "张三", 5.0);
        exam.prepare();
        exam.takeExame();

        System.out.println("score: " + exam.getScore());
        ((Thesis) exam).write();
    }
}
