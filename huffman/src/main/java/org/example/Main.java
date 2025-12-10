package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String pathToFile = "/Users/madinabolat/Downloads/dataset_91069.txt";
//        File file = new File(pathToFile);
//        int count = 0;
//        try {
//            Scanner scanner = new Scanner(file);
//
//            if (scanner.hasNext()){
//                scanner.nextLine();
//            } else {
//                return;
//            }
//            while (scanner.hasNext()){
//                System.out.println(scanner.nextInt());
//            }
//            scanner.close();
//        }
//        catch(FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println(count);

        FileReader fileReader = new FileReader();
        fileReader.readFile();
    }
}