package org.example;

import java.util.*;

public class HightMap {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private ArrayList<ArrayList<Character>> grid;
    private int rows;
    private int cols;
    private int startRow;
    private int endRow;
    private int startCol;
    private int endCol;

    public HightMap(ArrayList<ArrayList<Character>> grid, int rows, int cols, int startRow, int startCol, int endRow, int endCol) {
        this.grid = grid;
        this.rows = rows;
        this.cols = cols;
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = endRow;
        this.endCol = endCol;
    }

    public int findShortestPath() {
        Queue<int[]> queue = new LinkedList<>();
        Set<int[]> visited = new HashSet<>();
        queue.offer(new int[]{startRow, startCol, 0});
        visited.add(new int[]{startRow, startCol});

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int row = p[0];
            int col = p[1];
            int steps = p[2];

            if (row == endRow && col == endCol) {
                return steps;
            }

            for (int[] direction : DIRECTIONS) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid.get(nextRow).get(nextCol) - grid.get(row).get(col) <= 1) {
                    if (!visited.contains(new int[]{nextRow, nextCol})) {
                        queue.offer(new int[]{nextRow, nextCol, steps + 1});
                        visited.add(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
        return -1;
    }
}
