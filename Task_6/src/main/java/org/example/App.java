package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class App
{
        public static void main( String[] args ){

                try {
                        FileReader file = new FileReader("subroutine.txt");
                        BufferedReader br = new BufferedReader(file);
                        int line;

                        ArrayList<Character> char_arr = new ArrayList<Character>();

                        while((line = br.read()) != -1){
                                char_arr.add((char)line);
                        }

                        int res = 0;

                        for(int i = 14; i < char_arr.size(); i++){
                                Set<Character> set = new HashSet<>();
                                ArrayList<Character> ar = new ArrayList<Character>();

                                for(int l = 14; l > 0; l--){
                                        ar.add(char_arr.get(i -l));
                                }

                                System.out.println(ar);

                                boolean checker = true;

                                for (char c : ar){
                                        if(!set.add(c)){
                                                checker = false;
                                                break;
                                        }
                                        checker = true;
                                }

                                if(checker){
                                        res = i + 1;
                                        break;
                                }

                        }

                        System.out.println(res);

                } catch (IOException e) {
                        throw new RuntimeException(e);
                }

        }
}
