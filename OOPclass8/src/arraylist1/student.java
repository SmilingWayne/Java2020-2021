package arraylist1;

import java.util.Objects;

public class student implements Comparable<student>{
    public int number;
    public String no;
    public int score;
    public student(int number,String no,int score){
        this.number = number;
        this.no = no;
        this.score = score;
    }
    public int hashCode(){
        return Objects.hash(number);
    }
    public boolean equals(Object obj){
        return no == ((student) obj).no;
    }
    public int compareTo(student st){
        return st.score - this.score;

    }

}
