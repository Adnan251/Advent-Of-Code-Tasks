package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class App
{
    public static void main( String[] args ) {
        try{
            int cycle = 0;
            int counter = 0;
            int xRegister = 1;
            ArrayList<Integer> arr = new ArrayList<>();
            Integer c[] = {20, 60, 100, 140, 180, 220};

            FileReader file = new FileReader("commands.txt");
            BufferedReader br = new BufferedReader(file);
            String line;

            ArrayList<Character> ar6 = new ArrayList<Character>();
            ArrayList<Character> ar5 = new ArrayList<Character>();
            ArrayList<Character> ar4 = new ArrayList<Character>();
            ArrayList<Character> ar3 = new ArrayList<Character>();
            ArrayList<Character> ar2 = new ArrayList<Character>();
            ArrayList<Character> ar1 = new ArrayList<Character>();

            while((line = br.readLine()) != null){
                ArrayList<Character> sprite = new ArrayList<Character>();
                for(int i = 0; i < 40; i++){
                    if(i == xRegister-1){
                        sprite.add('#');
                        sprite.add('#');
                        sprite.add('#');
                        i += 2;
                        continue;
                    }
                    sprite.add('.');
                }

                String[] command = line.split(" ");
                if(command[0].equals("noop")){

                    if( cycle < 40) {
                        if (sprite.get(cycle) == '#') {
                            ar1.add('#');
                        }
                        else  ar1.add('.');
                    } else if (cycle >= 40 && cycle < 80) {
                        if (sprite.get(cycle-40) == '#') {
                            ar2.add('#');
                        }
                        else  ar2.add('.');
                    } else if (cycle >= 80 && cycle < 120) {
                        if (sprite.get(cycle-80) == '#') {
                            ar3.add('#');
                        }
                        else  ar3.add('.');
                    } else if (cycle >= 120 && cycle < 160) {
                        if (sprite.get(cycle-120) == '#') {
                            ar4.add('#');
                        }
                        else  ar4.add('.');
                    } else if (cycle >= 160 && cycle < 200) {
                        if (sprite.get(cycle-160) == '#') {
                            ar5.add('#');
                        }
                        else  ar5.add('.');
                    } else if (cycle >= 200 && cycle < 240) {
                        if (sprite.get(cycle - 200) == '#') {
                            ar6.add('#');
                        } else ar6.add('.');
                    }
                    cycle++;
                    if(Arrays.asList(c).contains(cycle)){
                        counter = xRegister * cycle;
                        arr.add(counter);
                    }


                } else if (command[0].equals("addx")){
                    Integer num = Integer.parseInt(command[1]);
                    for(int i = 0; i < 2; i++){
                        if( cycle < 40) {
                            if (sprite.get(cycle) == '#') {
                                ar1.add('#');
                            }
                            else  ar1.add('.');
                        } else if (cycle >= 40 && cycle < 80) {
                            if (sprite.get(cycle-40) == '#') {
                                ar2.add('#');
                            }
                            else  ar2.add('.');
                        } else if (cycle >= 80 && cycle < 120) {
                            if (sprite.get(cycle-80) == '#') {
                                ar3.add('#');
                            }
                            else  ar3.add('.');
                        } else if (cycle >= 120 && cycle < 160) {
                            if (sprite.get(cycle-120) == '#') {
                                ar4.add('#');
                            }
                            else  ar4.add('.');
                        } else if (cycle >= 160 && cycle < 200) {
                            if (sprite.get(cycle-160) == '#') {
                                ar5.add('#');
                            }
                            else  ar5.add('.');
                        } else if (cycle >= 200 && cycle < 240) {
                            if (sprite.get(cycle-200) == '#') {
                                ar6.add('#');
                            }
                            else  ar6.add('.');
                        }

                        cycle++;
                        if(Arrays.asList(c).contains(cycle)){
                            counter = xRegister * cycle;
                            arr.add(counter);
                        }

                    }
                    xRegister += num;
                }


            }
            int res = 0;
            for(int i = 0; i < 6; i++){
                res += arr.get(i);
            }
            System.out.println(res);

            System.out.println(ar1.toString());
            System.out.println(ar2.toString());
            System.out.println(ar3.toString());
            System.out.println(ar4.toString());
            System.out.println(ar5.toString());
            System.out.println(ar6.toString());
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
