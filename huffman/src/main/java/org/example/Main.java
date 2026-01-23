package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
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
        fop.writeToFile(ht.encodeString(inputText), "../encoded-output.txt");

        String encodedText = fop.readFromFile("../encoded-output.txt");
        fop.writeToFile(ht.decodeString(encodedText), "../decoded-output.txt");


        //convert binary string into bytes
        String s = ht.encodeString(inputText);
        System.out.println(s);

        byte[] byteArray = new byte[s.length()/8+1];
        //take each 8 bits and turn into byte
        //00111100-00111100 -> byte 00111100, byte 00111100
        //byte.parseByte(s,2) turns a string representation of a binary number into byte
        //it is signed.
       //take first 8 elements of s, turn into byte. take next, turn into byte.


        String s1 = "00000100";
        byte s1b = Byte.parseByte(s1, 2);
        System.out.println(s1b);

        String s2 = "000001001"; //9 chars - first 8 into byte, then take the 9th and pad and write to byte
        s2.toCharArray();
        byte s2b = Byte.parseByte(s1, 2);
        System.out.println(s1b);

    }
}