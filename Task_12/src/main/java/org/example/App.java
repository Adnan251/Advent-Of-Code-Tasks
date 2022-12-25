package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class App
{
    public static void main( String[] args ) {
        try{
            FileReader file = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(file);
            String line;

            ArrayList<ArrayList<Character>> grid = new ArrayList<ArrayList<Character>>();


            while((line = br.readLine()) != null){
                ArrayList<Character> row = new ArrayList<>();
                for (char c : line.toCharArray()) {
                    row.add(c);
                }
                grid.add(row);
            }
            int rows = grid.size();
            int cols = grid.get(0).size();

            int sRow = 0;
            int sCol = 0;
            int eRow = 0;
            int eCol = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid.get(i).get(j) == 'S') {
                        sRow = i;
                        sCol = j;
                    } else if (grid.get(i).get(j) == 'E') {
                        eRow = i;
                        eCol = j;
                    }
                }
            }
            HightMap map = new HightMap(grid,rows,cols,sRow, sCol, eRow, eCol);
            System.out.println(map.findShortestPath());
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
