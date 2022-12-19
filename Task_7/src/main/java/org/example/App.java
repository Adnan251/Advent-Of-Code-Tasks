package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class App
{
    public static void main( String[] args ){
        try{
            FileReader file = new FileReader("sectors.txt");
            BufferedReader br = new BufferedReader(file);
            String line;
            String curent = "";

            Tree tree = new Tree("/");

            while ((line = br.readLine()) != null){
                String[] list = line.split(" ");
                if(list[1] == "cd"){
                    curent = list[2];
                }

                else if( list[0]=="$" && list[1]=="ls"){
                    line = br.readLine();
                    list = line.split(" ");
                    while(list[0] != "$"){
                        if(line == null){
                            break;
                        }
                        else{
                            if(list[0] == "dir"){
                                tree.getNodeByName(tree.getRoot(), curent).addChild(new Node(list[1]));
                            }
                            else if(list[0].matches("[0-9]*")){
                                tree.getNodeByName(tree.getRoot(), curent).addChild(new Node(list[1],Integer.parseInt(list[0])));
                            }
                        }
                    }
                }
            }



        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
