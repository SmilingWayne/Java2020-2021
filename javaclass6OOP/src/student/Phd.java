package student;

public class Phd extends Student implements Exame, Thesis{
    protected int paperNumber;

    public Phd(int id, String name, int paperNumber){
        super(id,name);
        this.paperNumber = paperNumber;
        setName(name);
    }
    @Override
    public void setName(String name){
        this.name = "Dr." + name;
    }

    @Override
    public void graduate() {

    }

    public int getPaperNumber() {
        return paperNumber;
    }
    public void setPaperNumber(int paperNumber){
        this.paperNumber = paperNumber;
    }
    public void publish(String paperName){
        this.paperNumber ++;
        System.out.println("Name of paper:" + paperName);
    }
    public void graduation(){
        System.out.println("I graduated!");
    }

    @Override
    public void takeExame() {

    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public void write() {

    }
}
