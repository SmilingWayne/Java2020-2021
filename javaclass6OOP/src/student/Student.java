package student;

public abstract class Student{

    protected int id;

    protected String name;

    protected String thesis;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getThesis(){
        return thesis;
    }

    public void setThesis(String thesis){
        this.thesis = thesis;
    }

    public void takeClass(String className){
        System.out.println(name + " takes class " + className);
    }

    public abstract void graduate();

    public void process(){
        System.out.println(name + " enter University");
        System.out.println(name + " prepare thesis");
        graduate();
    }

}