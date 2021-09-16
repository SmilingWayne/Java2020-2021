
package student;

public class Bachelor extends Student implements Exame, Thesis{

    protected double gpa;

    public Bachelor(int id, String name, double gpa){
        super(id, name);
        this.gpa = gpa;
    }

    public double getGPA(){
        return gpa;
    }

    public void setGPA(double gpa){
        this.gpa = gpa;
    }

    public void applyMaster(String school){
        System.out.println(name + " apply " + school + " for graduate study");
    }

    public void graduate(){
        System.out.println("Hi hi hi, I graduate");
    }


    public void prepare(){
        System.out.println(name + " goes to the libary to prepare");
    }


    public void takeExame(){
        System.out.println(name + " goes to the classroom to take exame");
    }

    public int getScore(){
        return 90;
    }

    public void write(){
        System.out.println(name + "write thesis");
    }

}