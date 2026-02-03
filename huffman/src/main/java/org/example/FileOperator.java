package org.example;

import java.io.*;
import java.util.Scanner;

public class FileOperator {

    public String readTextFromFile(String path) throws FileNotFoundException{
        File file = new File(path);
        String text = new String();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            text += scanner.nextLine() + "\n";
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
            System.out.println("Error: file not found - " + e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }


    public void writeToByteFile(byte[] bytesArray, String outputPath){
        try (FileOutputStream fos = new FileOutputStream(outputPath)){
            fos.write(bytesArray);
            System.out.println("Encoded bytes were written to file successfully");
        } catch (IOException e){
            System.out.println("Error: file not found - " + e.getMessage());
        }
    }

    public byte[] readByteFile(String path) throws IOException{
        byte[] bytesArray = null;
        FileInputStream file = new FileInputStream(path);
        bytesArray = file.readAllBytes();
        System.out.println("Read bytes from encoded file successfully");
        return bytesArray;
    }
}
