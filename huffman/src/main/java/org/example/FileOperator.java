package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOperator {

    public String readFromFile(String path){
        File file = new File(path);
        String text = new String();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                text += scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return text;
    }

    public void writeToFile(String s, String path) {
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(s);
            fileWriter.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
