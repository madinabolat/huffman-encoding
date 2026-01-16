package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileOperator {

    public String readFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String text = new String();
        while (scanner.hasNextLine()){
            text += scanner.nextLine();
        }
        return text;
    }

    public void writeToFile(String s) {
        //create new file
        //write to file
        //return path to file? 

    }

}
