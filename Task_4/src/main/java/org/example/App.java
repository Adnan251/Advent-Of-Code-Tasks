package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class App
{
    public static void main( String[] args ) {
        try{
            ArrayList<ArrayList<Integer>> arrMain = new ArrayList<ArrayList<Integer>>();

            FileReader file = new FileReader("sectors.txt");
            BufferedReader br = new BufferedReader(file);
            String line;

            while((line = br.readLine()) != null){
                ArrayList<Integer> arr = new ArrayList<Integer>();
                String str[] =line.split("[-,]");
                for(int i = 0; i < str.length; i++){
                    arr.add(Integer.parseInt(str[i]));
                }
                arrMain.add(arr);
            }
            int counter1 = 0;
            int counter2 = 0;
            for(int j = 0; j < arrMain.size(); j++){
                if((arrMain.get(j).get(2) >= arrMain.get(j).get(0)) && (arrMain.get(j).get(3) <= arrMain.get(j).get(1))
                        || (arrMain.get(j).get(0) >= arrMain.get(j).get(2)) && (arrMain.get(j).get(1) <= arrMain.get(j).get(3))){
                    counter1++;
                }
            }

            for(int j = 0; j< arrMain.size(); j++){
                if((arrMain.get(j).get(0) <= arrMain.get(j).get(3) && arrMain.get(j).get(0) >= arrMain.get(j).get(2)) ||
                        (arrMain.get(j).get(1) >= arrMain.get(j).get(2) && arrMain.get(j).get(1) <= arrMain.get(j).get(3))){
                    counter2++;
                }
                else if((arrMain.get(j).get(2) >= arrMain.get(j).get(0) && arrMain.get(j).get(3) <= arrMain.get(j).get(1)) ||
                        (arrMain.get(j).get(0) >= arrMain.get(j).get(2) && arrMain.get(j).get(1) <= arrMain.get(j).get(3))){
                    counter2++;
                }
            }

            System.out.println(counter1);
            System.out.println(counter2);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
