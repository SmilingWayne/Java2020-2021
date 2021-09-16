package com.company;
import java.time.LocalDate;
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireday;
    public Employee(String n,double s, int year,int month,int day)
    {
        name=n;
        salary=s;
        hireday=LocalDate.of(year,month,day);
    }
    public static void swap(Employee x,Employee y){
        Employee temp=x;
        x=y;
        y=temp;
    }
    public String getname()
    {
        return name;
    }
    public double getsalary()
    {
        return salary;
    }
    public LocalDate getHireday()
    {
        return hireday;
    }
    public void raiseSalary(double byPercent)
    {
        double raise=salary*byPercent/100;
        salary+=raise;
    }
}
