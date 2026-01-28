package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
//        String s = "ABRACADABRA";
//        HuffmanTree ht = new HuffmanTree(s);
//        ht.preOrderTraverse(ht.root);
//        //System.out.println(ht.encodeChar('C', ht.root));
//        HashMap<Character, String> encodingDict = ht.buildEncodingDict(s);
//        System.out.println(encodingDict);
//        System.out.println(ht.encodeString(s));
//        System.out.println(ht.decodeString(ht.encodeString(s)));

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
          System.out.println(fop.readByteFile("../encoded.hf"));


          String s = new String();

          for (byte b : fop.readByteFile("../encoded.hf")){
              String s1 =Integer.toBinaryString(b & 0xFF);
              while (s1.length()<8){
                  s1 = "0"+s1;
              }
              s += s1;
          }
        System.out.println(s);
        System.out.println(ht.decodeString(s));
    }
}