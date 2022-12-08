package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App
{
    public static void main( String[] args ) {
        try {
            ArrayList<String> arr = new ArrayList<String>();
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            int num = 1;
            for(char a = 'a'; a <= 'z'; a++){
                map.put(a,num);
                num++;
            }
            for(char a = 'A'; a <= 'Z'; a++){
                map.put(a,num);
                num++;
            }

            FileReader file = new FileReader("items.txt");
            BufferedReader br = new BufferedReader(file);
            String line;
            int sum = 0;

            while((line = br.readLine()) != null){
                arr.add(line);
                String part1 = line.substring(0,line.length()/2);
                String part2 = line.substring(line.length()/2);

                for(int i = 0; i < part1.length(); i++){
                    char c = part1.charAt(i);
                    if(part2.contains(Character.toString(c))){
                        sum += map.get(c);
                        break;
                    }
                }
            }
            int other_sum = 0;
            for(int i = 0; i < arr.size(); i=i+3){
                for(int j = 0; j < arr.get(i).length(); j++){
                    char f = arr.get(i).charAt(j);
                    if(arr.get(i+1).contains(Character.toString(f)) && arr.get(i+2).contains(Character.toString(f))){
                       other_sum += map.get(f);
                       break;
                    }
                }
            }

            System.out.println(other_sum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
