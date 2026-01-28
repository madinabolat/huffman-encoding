package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        String path = "../input.txt";
        FileOperator fop = new FileOperator();
        String inputText = fop.readFromFile(path);
        HuffmanTree ht = new HuffmanTree(inputText);
//        fop.writeToFile(ht.encodeString(inputText), "../encoded-output.txt");
//
//        String encodedText = fop.readFromFile("../encoded-output.txt");
//        fop.writeToFile(ht.decodeString(encodedText), "../decoded-output.txt");
          System.out.println(ht.encodeToBytes(ht.encodeString(inputText)));
          fop.writeToByteFile(ht.encodeToBytes(ht.encodeString(inputText)));
          fop.readByteFile("../encoded.hf");

          System.out.println(ht.decodeFromBytes(fop.readByteFile("../encoded.hf")));

    }
}