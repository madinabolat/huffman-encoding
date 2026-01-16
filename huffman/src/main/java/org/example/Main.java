package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
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
        String s = fop.readFromFile(path);
        System.out.println(s);
                HuffmanTree ht = new HuffmanTree(s);
        ht.preOrderTraverse(ht.root);
        //System.out.println(ht.encodeChar('C', ht.root));
        HashMap<Character, String> encodingDict = ht.buildEncodingDict(s);
        System.out.println(encodingDict);
        System.out.println(ht.encodeString(s));
        System.out.println(ht.decodeString(ht.encodeString(s)));

        fop.writeToFile(ht.encodeString(s));
    }
}