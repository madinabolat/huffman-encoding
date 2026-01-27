package org.example;

import java.io.*;
import java.util.ArrayList;
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


    public void writeToByteFile(ArrayList<Byte> bytesList){
        try (FileOutputStream fos = new FileOutputStream("encoded.hf")){
            //expects array of bytes. change the original method - to produce array of bytes and change input in this method
            fos.write(bytesList);
            System.out.println("Encoded bytes were written to file successfully");
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
