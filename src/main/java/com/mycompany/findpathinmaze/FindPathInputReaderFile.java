/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.findpathinmaze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BlackSnake
 */
public class FindPathInputReaderFile extends FindPathInputReader {

    private int[] matrixStart;
    private int[] matrixEnd;
    private char[][] mat;

    public FindPathInputReaderFile() {
        mat = loadFile();
        matrixStart = findMatrixStart(mat);
        matrixEnd = findMatrixEnd(mat);
        findShortestPathLength(mat,matrixStart,matrixEnd);
        

    }

    private char[][] loadFile() {

        File f = new File("Matrix.txt");
        System.out.println(f.getAbsolutePath());

        String filePath = "..\\FindPathInMaze\\Matrix.txt";
        List<List<String>> matrix = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.trim().split(",");
                List<String> row = new ArrayList<>();
                for (String value : values) {
                    row.add(value);
                }
                matrix.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the loaded matrix
        System.out.println("File Input Matrix");
        for (List<String> row : matrix) {
            for (String value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        mat = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = (matrix.get(i).get(j)).charAt(0) ;
            }
        }
        return mat;
    }

}
