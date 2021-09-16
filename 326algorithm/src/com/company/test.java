package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class test {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("training");
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()) {
            System.out.println(scan.nextLine());
            System.out.println(scan.nextLine());
        }
    }
}
