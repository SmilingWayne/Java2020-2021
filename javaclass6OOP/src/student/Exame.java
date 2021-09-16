package student;

public interface Exame{

    default void prepare(){
        System.out.println("go to the libary");
    }

    void takeExame();

    public int getScore();
}