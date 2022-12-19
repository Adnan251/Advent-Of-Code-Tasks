package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App
{
    public static void main( String[] args ){

        try {
            FileReader file = new FileReader("trees.txt");
            BufferedReader br = new BufferedReader(file);
            String line;

            ArrayList<ArrayList<Integer>> main_arr = new ArrayList<ArrayList<Integer>>();

            while((line = br.readLine()) != null){
                String[] stringy = line.split("");

                ArrayList<Integer> list = new ArrayList<>();
                for(String s : stringy){
                    list.add(Integer.parseInt(s));
                }
                main_arr.add(list);
            }
            int counter = 0;
            int check = 0;
            for(int i = 1; i < main_arr.size()-1; i++){
                for(int j = 1; j< main_arr.get(i).size()-1; j++){
                    check = 0;
                    for(int k = 0; k < j; k++){
                        if(main_arr.get(i).get(k) < main_arr.get(i).get(j)){
                            check++;
                        }
                    }
                    if(check == j){
                        counter++;
                        continue;
                    }


                    check = 0;
                    for(int l = j+1; l > 98; l++){
                        if(main_arr.get(i).get(l) < main_arr.get(i).get(j)){
                            check++;
                        }
                    }
                    if(check == main_arr.get(i).size()-j-1){
                        counter++;
                        continue;
                    }


                    check = 0;
                    for(int m = 0; m < i; m++){
                        if(main_arr.get(m).get(j) < main_arr.get(i).get(j)){
                            check++;
                        }
                    }
                    if(check == i){
                        counter++;
                        continue;
                    }


                    check = 0;
                    for(int n = i+1; n < main_arr.size(); n++){
                        if(main_arr.get(n).get(j) < main_arr.get(i).get(j)){
                            check++;
                        }
                    }
                    if(check == main_arr.size()-i-1){
                        counter++;
                        continue;
                    }

                }

            }
            counter += 392;
            System.out.println(counter);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
