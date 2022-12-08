package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args )
    {
        ArrayList<Elf> list_of_Elfs = new ArrayList<Elf>();
        try {
            FileReader file = new FileReader("elf_calories.txt");
            BufferedReader br = new BufferedReader(file);
            int elf_counter = 1;
            String line;
            int sum = 0;
            while((line = br.readLine())!= null){
                if(line.isEmpty()) {
                    list_of_Elfs.add(new Elf(elf_counter, sum));
                    elf_counter++;
                    sum = 0;
                }
                else {
                    sum += Integer.parseInt(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(list_of_Elfs, Comparator.comparingInt(Elf::getCalories).reversed());

        System.out.println(list_of_Elfs.get(0).getCalories() + list_of_Elfs.get(1).getCalories() + list_of_Elfs.get(2).getCalories());

    }
}

