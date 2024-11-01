/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.findpathinmaze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author BlackSnake
 */
public class FindPathInMaze {

    public static void main(String[] args) throws IOException {
        System.out.println("Press number 1 for manual input or press number 2 for pre-made file");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));        
        int option = parseInt(reader.readLine());
        if(option == 1) {
        FindPathInputReaderStdIn result = new FindPathInputReaderStdIn();
        }else if (option == 2) {
            FindPathInputReaderFile vysledok = new FindPathInputReaderFile();
        } else {
            System.out.println("Options number:" + option + " dont exist. Exiting program");
        }
            
            
        
         
        
        

    }

    
}
