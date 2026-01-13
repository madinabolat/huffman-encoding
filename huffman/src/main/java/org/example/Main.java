package org.example;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        String s = "ABRACADABRA";
        HuffmanTree ht = new HuffmanTree(s);//to build a tree need to call this method - should I change this?
        ht.preOrderTraverse(ht.root);
        System.out.println(ht.encodeChar('C', ht.root));

        HashMap<Character, String> encodingDict = ht.buildEncodingDict();
        System.out.println(encodingDict);
        System.out.println(ht.encodeString());
    }
}