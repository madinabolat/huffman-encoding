package org.example;

import java.io.*;
import java.util.Scanner;

public class FileOperator {

    public String readTextFromFile(String path){
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

    public void writeTextToFile(String s, String path) {
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


    public void writeToByteFile(byte[] bytesArray, String outputPath){
        try (FileOutputStream fos = new FileOutputStream(outputPath)){
            //expects array of bytes. change the original method - to produce array of bytes and change input in this method
            fos.write(bytesArray);
            System.out.println("Encoded bytes were written to file successfully");
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public byte[] readByteFile(String path){
        byte[] bytesArray = null;
        try (FileInputStream file = new FileInputStream(path)){
            bytesArray = file.readAllBytes();
            System.out.println("Read bytes from encoded file successfully");
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return bytesArray;
    }
}
