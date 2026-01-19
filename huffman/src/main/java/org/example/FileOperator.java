package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    public void writeToFile(String s) throws IOException {
        File file = new File("../output.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(s);//not writing
        fileWriter.close();

    }

}
