package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ){
        try {
            FileReader file = new FileReader("moves.txt");
            BufferedReader br = new BufferedReader(file);
            String line;

            ArrayList<ArrayList<String>> arr_list = new ArrayList<ArrayList<String>>();

            for(int i = 0; i < 1000; i++){
                int j = 0;
                ArrayList<String> arr = new ArrayList<String>();
                for(int k = j ; k < 1000; k++){
                    if(i == 500 && j == 500){
                        arr.add("#");
                        continue;
                    }else {
                        arr.add(".");
                    }
                }
                arr_list.add(arr);
            }

            int[] head = {500, 500};
            int[] tail = {500, 500};

            while((line = br.readLine()) != null){
                String[] list = line.split(" ");
                int num = Integer.parseInt(list[1]);

                num = Integer.parseInt(list[1]);
                if(list[0].equals("R")){
                    while (num > 0){
                        head[1]++;
                        if((head[1] == tail[1]+2) && (head[0] == tail[0])){
                            arr_list.get(tail[0]).set(tail[1],"#");
                            tail[1]++;
                        }
                        else if ((head[1] == tail[1]+2) && ((head[0] == tail[0]+1) || (head[0] == tail[0]-1) )){
                            arr_list.get(tail[0]).set(tail[1],"#");
                            tail[1]++;
                            tail[0] = head[0];
                        }
                        num--;
                    }
                } else if (list[0].equals("L")) {
                    while (num > 0) {
                        head[1]--;
                        if ((head[1] == tail[1] - 2) && (head[0] == tail[0])) {
                            arr_list.get(tail[0]).set(tail[1], "#");
                            tail[1]--;
                        }
                        else if ((head[1] == tail[1]-2) && ((head[0] == tail[0]+1) || (head[0] == tail[0]-1))) {
                            arr_list.get(tail[0]).set(tail[1], "#");
                            tail[1]--;
                            tail[0] = head[0];
                        }
                        num--;
                    }
                } else if (list[0].equals("U")) {
                    while(num > 0){
                        head[0]--;
                        if((head[0] == tail[0]-2) && (head[1] == tail[1])){
                            arr_list.get(tail[0]).set(tail[1], "#");
                            tail[0]--;
                        } else if ((head[0] == tail[0]-2) && ((head[1] == tail[1]+1) || (head[1] == tail[1]-1))) {
                            arr_list.get(tail[0]).set(tail[1], "#");
                            tail[0]--;
                            tail[1] = head[1];
                        }
                        num--;
                    }
                } else if (list[0].equals("D")) {
                    while(num > 0){
                        head[0]++;
                        if((head[0] == tail[0]+2) && (head[1] == tail[1])){
                            arr_list.get(tail[0]).set(tail[1], "#");
                            tail[0]++;
                        } else if ((head[0] == tail[0]+2) && ((head[1] == tail[1]+1) || (head[1] == tail[1]-1))) {
                            arr_list.get(tail[0]).set(tail[1], "#");
                            tail[0]++;
                            tail[1] = head[1];
                        }
                        num--;
                    }
                }
            }
            int counter = 0;
            for(int i = 0; i < 1000; i++){
                for(int j = 0; j < 1000; j++){
                    System.out.print(arr_list.get(i).get(j));
                    if (arr_list.get(i).get(j) == "#") {
                        counter++;
                    }
                }
                System.out.println();
            }
            System.out.println(counter);

        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
