package com.company;
import java.time.LocalDate;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Date birthday=new Date();
        LocalDate.now();
        LocalDate newYearsEve=LocalDate.of(1999,12,31);
        System.out.println(birthday);
        int year=newYearsEve.getYear();
        int month=newYearsEve.getMonthValue();
        int day=newYearsEve.getDayOfMonth();
        LocalDate aThousandDaysLater=newYearsEve.plusDays(1000);
        System.out.println(aThousandDaysLater);
        Employee[] staff=new Employee[3];
        staff[0]=new Employee("Carl.Cracker",75000,1987,12,15);
        staff[1]=new Employee("Bill Clare",89000,1999,8,10);

    }
}
