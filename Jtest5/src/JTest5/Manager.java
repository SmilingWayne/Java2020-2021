package JTest5;

import java.time.LocalDate;

public class Manager extends Employee{
    private double bonus;
    public void setbonus(double bonus){
        this.bonus=bonus;
    }
    public double getSalary()
    {
        double baseSalary=super.getSalary();
        return baseSalary+bonus;
    }
    public Manager(String name,double salary,int year,int month,int day)
    {
        this.name=name;
        this.salary=salary;
        hireDay=LocalDate.of(year,month,day);
    }
    public boolean equals (Object otherObject)
    {
        if(!super.equals(otherObject))
            return false;
        Manager other = (Manager) otherObject;
        return bonus==other.bonus;

    }
}
