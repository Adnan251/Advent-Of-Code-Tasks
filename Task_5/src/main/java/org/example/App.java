package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class App
{
    public static void main( String[] args ) {
        try{
            FileReader file = new FileReader("moves.txt");
            BufferedReader br = new BufferedReader(file);
            String line;

            List<Character> l1 = Arrays.asList('N','R','G','P');
            List<Character> l2 = Arrays.asList('J','T','B','L','F','G','D','C');
            List<Character> l3 = Arrays.asList('M','S','V');
            List<Character> l4 = Arrays.asList('L','S','R','C','Z','P');
            List<Character> l5 = Arrays.asList('P','S','L','V','C','W','D','Q');
            List<Character> l6 = Arrays.asList('C','T','N','W','D','M','S');
            List<Character> l7 = Arrays.asList('H','D','G','W','P');
            List<Character> l8 = Arrays.asList('Z','L','P','H','S','C','M','V');
            List<Character> l9 = Arrays.asList('R','P','F','L','W','G','Z');

            ArrayList<Group> arr = new ArrayList<Group>();
            ArrayList<ArrayList<Integer>> instructions = new ArrayList<ArrayList<Integer>>();

            arr.add(new Group(l1));
            arr.add(new Group(l2));
            arr.add(new Group(l3));
            arr.add(new Group(l4));
            arr.add(new Group(l5));
            arr.add(new Group(l6));
            arr.add(new Group(l7));
            arr.add(new Group(l8));
            arr.add(new Group(l9));

            while((line = br.readLine()) != null){
                ArrayList<Integer> rr = new ArrayList<Integer>();
                String str[] =line.split(" ");

                rr.add(Integer.parseInt(str[1]));
                rr.add(Integer.parseInt(str[3]));
                rr.add(Integer.parseInt(str[5]));

                instructions.add(rr);
            }

            arr.get(1).getBox();

            for(int i = 0; i < instructions.size(); i++){
                int amount = instructions.get(i).get(0);
                int from = instructions.get(i).get(1);
                int to = instructions.get(i).get(2);

                System.out.println(arr.get(from-1).toStringy());
                System.out.println(arr.get(to-1).toStringy());

                while (amount > 0) {
                    arr.get(to - 1).setBox(arr.get(from - 1).getBox());
                    amount--;
                }

            }

            for(int i = 0; i < arr.size(); i++){
                System.out.print(arr.get(i).getBox());
            }

        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
