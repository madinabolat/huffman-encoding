package org.example;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        String s = "ABRACADABRA";
        HuffmanTree ht = new HuffmanTree();
        ht.buildTree(s); //to build a tree need to call this method - should I change this?
        ht.preOrderTraverse(ht.root);
        System.out.println(ht.encode('A', ht.root));
    }
}