/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.findpathinmaze;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author BlackSnake
 */
public class FindPathInputReaderStdIn extends FindPathInputReader {

    private int[] matrixStart;
    private int[] matrixEnd;

    private char[][] mat;

    public FindPathInputReaderStdIn() {
        mat = askForInput();
        printInput();
        matrixStart = findMatrixStart(mat);
        matrixEnd = findMatrixEnd(mat);
       
        findShortestPathLength(mat, matrixStart, matrixEnd);
        
    }

    private char[][] askForInput(){
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();
        
        mat = new char[rows][cols];
        
        System.out.println("Enter elements row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = scanner.next().charAt(0);
            }
        }
        } catch (java.util.InputMismatchException e){
            System.out.println("Wrong Inputs for size of Matrix");
        }
        
    return mat;
    }
    
    private void printInput() {
        System.out.println("Input");
        for (int i = 0; i< mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] +" ");
            }
            System.out.println();
        }
    }

;

}
