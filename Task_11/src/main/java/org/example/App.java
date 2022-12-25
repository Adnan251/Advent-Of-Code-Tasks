package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App
{
    public static void main( String[] args ){
        try{
            FileReader file = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(file);
            String line;
            ArrayList<Monkey> monkeyGroup = new ArrayList<Monkey>();
            ArrayList<Integer> nums = new ArrayList<>();

            while((line = br.readLine()) != null){
                int j = 0;
                int name = 0;
                String operation ="";
                int divisible = 0;
                String operator ="";
                int ifTrue;
                int ifFalse;
                ArrayList<Integer> arr = new ArrayList<>();

                for(int i = 0; i < 6; i++){
                    String x = br.readLine();
                    String[] list = x.split(" ");

                    if(i == 0){
                        name = Integer.parseInt(list[list.length-1].replace(":",""));
                    }
                    else if (i == 1) {
                        while(j < list.length){
                            if(list[j].matches("\\d+")){
                                arr.add(Integer.parseInt(list[j]));
                            }
                            j++;
                        }
                    }
                    else if (i == 2) {
                        operation = list[list.length-2];
                        operator = list[list.length-1];
                    }
                    else if (i == 3) {
                        divisible = Integer.parseInt(list[list.length-1]);
                    }
                    else if (i == 4) {
                        nums.add(Integer.parseInt(list[list.length-1]));
                    }
                    else if (i == 5) {
                        nums.add(Integer.parseInt(list[list.length-1]));
                    }
                }

                Monkey monkey = new Monkey(name,divisible,operation, operator);

                for(int i = 0; i < arr.size(); i++){
                    monkey.addItem(arr.get(i));
                }
                monkeyGroup.add(monkey);
            }
            int c = 0;

            for (Monkey m : monkeyGroup){
                for(Monkey n : monkeyGroup){
                    if(n.getName() == nums.get(c)-1){
                        m.setTr(n);
                        c++;
                        break;
                    }
                }
                for(Monkey n : monkeyGroup){
                    if(n.getName() == nums.get(c)-1){
                        m.setFa(n);
                        c++;
                        break;
                    }
                }
            }

            int roundCounter = 0;

            while(roundCounter < 20){
                for(Monkey m : monkeyGroup){
                    m.goThrough();
                }
                roundCounter++;
            }

            int max = 0;
            int secMax = 0;

            for(Monkey m : monkeyGroup){
                System.out.println(m.getAllItems());
            }

            for(Monkey m : monkeyGroup){
                if(m.getInpect() > max){
                    max = m.getInpect();
                }
                else if (m.getInpect() > secMax && m.getInpect() < max) {
                    secMax = m.getInpect();
                }
            }

            System.out.println(max * secMax);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
