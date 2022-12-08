package org.example;

import java.io.*;


public class App {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("rock_paper_scissors.txt");
            BufferedReader br = new BufferedReader(file);
            String line;
            int sum = 0;
            while ((line = br.readLine()) != null) {
                if (line.contains("A") && line.contains("X")) {
                    sum += 3;
                } else if (line.contains("A") && line.contains("Y")) {
                    sum += 4;
                } else if (line.contains("A") && line.contains("Z")) {
                    sum += 8;
                } else if (line.contains("B") && line.contains("X")) {
                    sum += 1;
                } else if (line.contains("B") && line.contains("Y")) {
                    sum += 5;
                } else if (line.contains("B") && line.contains("Z")) {
                    sum += 9;
                } else if (line.contains("C") && line.contains("X")) {
                    sum += 2;
                } else if (line.contains("C") && line.contains("Y")) {
                    sum += 6;
                } else if (line.contains("C") && line.contains("Z")) {
                    sum += 7;
                }
            }
            System.out.println(sum);
        } catch(IOException e){
            throw new RuntimeException(e);
        }

    }
}
