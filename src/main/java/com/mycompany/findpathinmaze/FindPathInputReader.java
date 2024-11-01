/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.findpathinmaze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author BlackSnake
 */
public abstract class FindPathInputReader {

    static boolean[][] visited;
    static List<String> smerCesty = new ArrayList<>();
    static List<String> smerCestyNajmensi = new ArrayList<>();

    public int[] findMatrixStart(char[][] aMatrix) {

        int[] start = {-1, -1};
        int row = aMatrix.length;
        int col = aMatrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (aMatrix[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        //System.out.println(Arrays.toString(start));
        return start;
    }

    ;
    public int[] findMatrixEnd(char[][] aMatrix) {
        int[] end = {-1, -1};
        int row = aMatrix.length;
        int col = aMatrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (aMatrix[i][j] == 'X') {
                    end[0] = i;
                    end[1] = j;
                }

            }
        }
        //System.out.println(Arrays.toString(end));
        return end;
    }

    ;
   static int findShortestPathLength(char[][] aMatrix, int[] start, int[] end) {
        if (aMatrix.length == 0 || start[0] == -1 || end[0] == -1) {
            System.out.println("You are missing start or exit or Matrix is too small");
            return -1;
        }

        int row = aMatrix.length;
        int col = aMatrix[0].length;

        visited = new boolean[row][col];

        //Matrix of visited places
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = false;
            }
        }

        int dist = Integer.MAX_VALUE;
        dist = findShortestPath(aMatrix, start[0], start[1], end, dist, 0, smerCesty);
        if (dist != Integer.MAX_VALUE) {
            return dist;
        }

        return -1;
    }

    static int findShortestPath(char[][] aMatrix, int i, int j, int[] end, int dist, int minDist, List<String> smerCesty) {

        // if start and end of maze is on the same spot
        if (i == end[0] && j == end[1]) {
            //System.out.println("Found Exit");
            if (smerCestyNajmensi.isEmpty()) {
                smerCestyNajmensi.addAll(smerCesty);
                System.out.println("Found new shortest path ");
                System.out.println(Arrays.toString(smerCestyNajmensi.toArray()));
            } else if (smerCestyNajmensi.size() > smerCesty.size()) {
                smerCestyNajmensi.clear();
                smerCestyNajmensi.addAll(smerCesty);
                System.out.println("Found new shortest path ");
                System.out.println(Arrays.toString(smerCestyNajmensi.toArray()));
            }
            
            minDist = Math.min(dist, minDist);
            smerCesty.remove(smerCesty.size() - 1);
            return minDist;
        }
        //set current position as visited
        visited[i][j] = true;

        //go down
        if (canMove(aMatrix, visited, i + 1, j)) {
            //System.out.println("down");
            smerCesty.add("down");
            minDist = findShortestPath(aMatrix, i + 1, j, end, dist, minDist, smerCesty);
        }
        //go right
        if (canMove(aMatrix, visited, i, j + 1)) {
            //System.out.println("right");
            smerCesty.add("right");
            minDist = findShortestPath(aMatrix, i, j + 1, end, dist, minDist, smerCesty);
        }
        //go up
        if (canMove(aMatrix, visited, i - 1, j)) {
            //System.out.println("up");
            smerCesty.add("up");
            minDist = findShortestPath(aMatrix, i - 1, j, end, dist, minDist, smerCesty);
        }
        //ho left
        if (canMove(aMatrix, visited, i, j - 1)) {
            //System.out.println("left");
            smerCesty.add("left");
            minDist = findShortestPath(aMatrix, i, j - 1, end, dist, minDist, smerCesty);
        }
        //if dead end going back
        //System.out.println("going back");
        if (!smerCesty.isEmpty()) {
            smerCesty.remove(smerCesty.size() - 1);
        }
        return minDist;

    }

    static boolean canMove(char[][] aMatrix, boolean[][] visited, int x, int y) {

        /*if ((x >= 0 && x < aMatrix.length && y >= 0 && y < aMatrix[0].length && aMatrix[x][y] == '.' && !visited[x][y]) ||
                (x >= 0 && x < aMatrix.length && y >= 0 && y < aMatrix[0].length && aMatrix[x][y] == 'X' && !visited[x][y])) {
            System.out.println("is true");
        }*/
        return ((x >= 0 && x < aMatrix.length && y >= 0 && y < aMatrix[0].length && aMatrix[x][y] == '.' && !visited[x][y])
                || (x >= 0 && x < aMatrix.length && y >= 0 && y < aMatrix[0].length && aMatrix[x][y] == 'X' && !visited[x][y]));

    }
    
}
