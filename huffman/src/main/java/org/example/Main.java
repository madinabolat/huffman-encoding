package org.example;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        String s = "ABRACADABRA";
        HuffmanTree ht = new HuffmanTree(s);
        ht.preOrderTraverse(ht.root);
        //System.out.println(ht.encodeChar('C', ht.root));
        HashMap<Character, String> encodingDict = ht.buildEncodingDict(s);
        System.out.println(encodingDict);
        System.out.println(ht.encodeString(s));
        System.out.println(ht.decodeString(ht.encodeString(s)));
    }
}