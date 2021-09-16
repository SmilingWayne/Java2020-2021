package JTest5;
import java.time.*;
public class Employee {
    public String name;
    public double salary;
    public LocalDate hireDay;              //这里的LocalDate应该类似String这种类型吧//

    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public LocalDate getHireDay(){
        return hireDay;
    }
    public void raiseSalary(double byPercent){
        double raise=salary*byPercent/100;
        salary+=raise;
    }
    public int hashCode()
    {
        return 7*name.hashCode();
    }
    public boolean equals(Object otherObject){
        if(this == otherObject)
            return true;
        if(getClass()!=otherObject.getClass()) {
            return false;
        }
        Employee other = (Employee) otherObject;
        return name.equals(other.name)&&salary==other.salary
                &&hireDay.equals(other.hireDay);
    }

}
