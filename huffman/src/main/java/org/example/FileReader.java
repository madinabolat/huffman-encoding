package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public void readFile(){
        String pathToFile = "../text.txt";
        File file = new File(pathToFile);
        String s = new String();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                s = s.concat(scanner.nextLine());
            }
            scanner.close();
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(s);
        //new lines - just get appended. 
    }

}
